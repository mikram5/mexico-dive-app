package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.ApiToken;
import com.mikeramey.divedb.logic.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MySqlAuthenticationRepository implements AuthenticationRepository {

    private static final String TABLE_NAME = "token";
    private static final String ALL_FIELDS = "*";
    private final AuthenticationRowMapper rowMapper = new AuthenticationRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlAuthenticationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ApiToken createApiToken() {
        String randomToken = UUID.randomUUID().toString();
        String query = "Insert Into " + TABLE_NAME + " Values " + "(" + randomToken + ")";
        ApiToken apiToken = new ApiToken();
        apiToken.setName(randomToken);
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(apiToken);
        jdbcTemplate.update(query, namedParameters);
        return apiToken;
    }
}



