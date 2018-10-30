package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.presentation.api.ApiToken;

public interface AuthenticationRepository {

    ApiToken getApiToken(String username, String password);
}
