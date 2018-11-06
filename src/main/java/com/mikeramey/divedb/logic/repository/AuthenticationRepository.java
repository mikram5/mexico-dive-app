package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.ApiToken;

public interface AuthenticationRepository {

    ApiToken createApiToken();
}
