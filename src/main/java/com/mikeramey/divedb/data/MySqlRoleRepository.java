package com.mikeramey.divedb.data;

import com.mikeramey.divedb.data.rowmappers.RoleRowMapper;
import com.mikeramey.divedb.logic.model.Role;
import com.mikeramey.divedb.logic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class MySqlRoleRepository implements RoleRepository {
    private static final String TABLE_NAME = "role";
    private final RoleRowMapper roleRowMapper = new RoleRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlRoleRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role findByRole(String role) {
        String query = "SELECT * from " + TABLE_NAME + " where r_name = :role";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("role", role);
        return jdbcTemplate.queryForObject(query, namedParameters, roleRowMapper);
    }
}
