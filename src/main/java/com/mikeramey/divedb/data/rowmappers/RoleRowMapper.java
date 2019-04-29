package com.mikeramey.divedb.data.rowmappers;

import com.mikeramey.divedb.logic.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("r_id"));
        role.setRole(rs.getString("r_name"));
        return role;
    }
}
