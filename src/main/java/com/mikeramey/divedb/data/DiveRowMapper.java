package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.Dive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiveRowMapper implements RowMapper<Dive> {
    @Override
    public Dive mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dive dive = new Dive();
        dive.setId(rs.getInt("d_id"));
        dive.setName(rs.getString("d_name"));
        dive.setLocation(rs.getString("d_location"));
        dive.setDate(rs.getDate("d_date").toLocalDate());
        dive.setDurationInMinutes(rs.getDouble("d_duration_in_minutes"));
        dive.setDepthInMeters(rs.getDouble("d_depth_in_meters"));
        dive.setWaterCondition(rs.getString("d_water_condition"));
        dive.setSafetyStop(rs.getBoolean("d_safety_stop"));
        return dive;
    }
}
