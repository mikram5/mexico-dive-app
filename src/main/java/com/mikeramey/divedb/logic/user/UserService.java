package com.mikeramey.divedb.logic.user;

import com.mikeramey.divedb.logic.model.Role;
import com.mikeramey.divedb.logic.user.User;
import com.mikeramey.divedb.logic.repository.RoleRepository;
import com.mikeramey.divedb.logic.user.UserRepository;
import com.mikeramey.divedb.logic.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//@Service
//public class UserService {
//
//    @Resource
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public User getUserByUserName(String username) {
//        return userRepository.getUserByUserName(username);
//    }
//
//    public void validateUser(String username, String password) {
//
//    }
//
//}

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserRoleRepository userRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User getUserByUserName(String username) {

        return userRepository.getUserByUserName(username);
    }

    public User validateUser(User user) {

        User userName = getUserByUserName(user.getUsername());

        if (userName != null &&
                bCryptPasswordEncoder.matches(user.getPassword(), userName.getPassword())) {
            return userName;
        } else {
            return null;
        }
    }

    @Transactional
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("USER");

        User savedUser = userRepository.save(user);
        userRoleRepository.addUserRoleLink(savedUser.getId(), userRole.getId());
        return savedUser;
    }

    public Boolean checkCredentials(String userName, String password) {
        User thisUser = userRepository.getUserByUserName(userName);
        boolean passwordMatch = bCryptPasswordEncoder.matches(password, thisUser.getPassword());
        if(passwordMatch){
            return true;
        } else {
            return false;
        }
    }

    public Integer getCurrentUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return getUserByUserName(currentUserName).getId();
        }
        return null;
    }
}