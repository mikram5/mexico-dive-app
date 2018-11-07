package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.ApiToken;
import com.mikeramey.divedb.logic.repository.TokenRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class TokenService {

    @Resource
    private TokenRepository tokenRepository;

    public ApiToken createApiToken(String username, String password) {
        ApiToken apiToken = new ApiToken();
        apiToken.setValue(UUID.randomUUID().toString());
        return tokenRepository.createApiToken(apiToken);
    }


}
