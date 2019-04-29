package com.mikeramey.divedb.data.dives;

import com.mikeramey.divedb.data.rowmappers.DiveRowMapper;
import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public class MySqlDiveRepository implements DivesRepository {

    private static final String TABLE_NAME = "dives";
    private static final String ALL_FIELDS = "*";
    private final DiveRowMapper rowMapper = new DiveRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + TABLE_NAME +
                " VALUES(null,  :date, :location, :durationInMinutes," +
                "        :depthInMeters, :waterCondition, :safetyStop ,:name )";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public List<Dive> getAllDives() {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME;
        simulateSlowService();
        return jdbcTemplate.query(query, rowMapper);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Dive getById(Integer id) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public Dive deleteById(Integer id) {
        Dive dive = getById(id);
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + " d_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(query, namedParameters);
        return dive;
    }

    @Override
    public Dive updateById(Dive dive) {
        String query = "UPDATE " + TABLE_NAME +
                " SET d_date = :date, d_location = :location, d_duration_in_minutes = :durationInMinutes, " +
                "d_depth_in_meters = :depthInMeters, d_water_condition = :waterCondition, d_safety_stop = :safetyStop, " +
                "d_name = :name WHERE " + " d_id = :id";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters);
        return dive;
    }

    @Override
    public Dive getByDate(LocalDate date) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_date = :date";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getByLocation(String location) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_location = :location";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location", location);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }


}
