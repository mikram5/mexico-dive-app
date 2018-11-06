package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.repository.AuthenticationRepository;
import com.mikeramey.divedb.logic.model.ApiToken;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Resource
    private AuthenticationRepository authenticationRepository;

    public ApiToken createApiToken(String username, String password) {
        return authenticationRepository.createApiToken();
    }


}
