package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.logic.model.Dive;

import java.util.List;

public interface DivesRepository {

    Dive save(Dive dive);

    List<Dive> getDivesByUserId(int userId);

    List<Dive> getDiveByLocation(String location);

    void deleteDiveById(int id);
}

