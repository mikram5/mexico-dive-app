package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.User;
import com.mikeramey.divedb.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUserNameAndPassword(String username, String password) {
        return userRepository.getUserByUserNameAndPassword(username, password);
    }

    public void validateUser(String username, String password) {

    }

}
