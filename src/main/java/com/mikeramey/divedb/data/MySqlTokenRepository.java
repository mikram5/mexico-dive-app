package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.ApiToken;
import com.mikeramey.divedb.logic.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MySqlTokenRepository implements TokenRepository {

    private static final String TABLE_NAME = "token";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlTokenRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ApiToken createApiToken(ApiToken apiToken) {
        String query = "Insert Into " + TABLE_NAME + " Values ( t_token = :value )";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(apiToken);
        jdbcTemplate.update(query, namedParameters);
        return apiToken;
    }
}



