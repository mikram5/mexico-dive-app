package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.Dive;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.DelayQueue;

public interface DivesRepository {

    Dive save(Dive dive);

    List<Dive> getAllDives();

    Dive getByDate(LocalDate date);

    List<Dive> getByLocation(String location);

    Dive getById(Integer id);

    void delete();

    void deleteById(Integer id);

}

