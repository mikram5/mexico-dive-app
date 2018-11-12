package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.User;
import com.mikeramey.divedb.logic.repository.RoleRepository;
import com.mikeramey.divedb.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User getUserByUserNameAndPassword(String username, String password) {
        return userRepository.getUserByUserNameAndPassword(username, password);
    }

    public void validateUser(String username, String password) {

    }

}
