package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.Dive;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.DelayQueue;

public interface DivesRepository {

    Dive save(Dive dive);

    List<Dive> getDivesByUserId(int userId);

    List<Dive> getDiveByLocation(String location);

    void deleteDiveById(int id);

    Dive updateDiveById(int id, Dive dive);
}

