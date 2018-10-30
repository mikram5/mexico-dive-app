package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.repository.AuthenticationRepository;
import com.mikeramey.divedb.presentation.api.ApiToken;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;

public class AuthenticationService {

    @Resource
    private AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public ApiToken getApiToken(String username, String password) {
        return authenticationRepository.getApiToken(username, password);
    }


}
