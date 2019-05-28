package com.mikeramey.divedb.data.repositories;

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

import java.util.List;

@Primary
@Repository
public class MySqlDiveRepository implements DivesRepository {

    private final String TABLE_NAME = "dives";
    private final String ALL_FIELDS = "*";
    private final DiveRowMapper rowMapper = new DiveRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + TABLE_NAME +
                " VALUES(null,  :userId, :date, :location, :durationInMinutes," +
                "        :depthInMeters, :waterCondition)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public List<Dive> getDivesByUserId(int userId) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_u_id = :userId ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("userId", userId);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public void deleteDiveById(int id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + " d_id = :id ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(query, namedParameters);
    }

    @Override
    public List<Dive> getDiveByLocation(String location) {
        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_location = :location";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location", location);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

//    @Override
//    public Dive getByDate(LocalDate date) {
//        String query = "SELECT " + ALL_FIELDS + " FROM " + TABLE_NAME + " WHERE " + " d_date = :date";
//        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
//        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);

//    }
}
