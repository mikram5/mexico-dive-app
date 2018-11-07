package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.User;
import com.mikeramey.divedb.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class MySqlUserRepository implements UserRepository {

    private static final String TABLE_NAME = "user";
    private static final String ALL_FIELDS = "*";
    private final UserRowMapper rowMapper = new UserRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE u_name = :username u_password = :password";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("username", username)
                .addValue("password", password);
        try {
            return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
