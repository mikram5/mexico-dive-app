package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DivesService {

    @Resource
    private DivesRepository divesRepository;

    @Autowired
    public DivesService(DivesRepository divesRepository) {
        this.divesRepository = divesRepository;
    }

    public Dive save(Dive dive) {
        Dive savedDive = divesRepository.save(dive);
        return savedDive;
    }

    public List<Dive> getDivesByUserId(int userId) {
        return divesRepository.getDivesByUserId(userId);
    }

    public List<Dive> getDiveByLocation(String location) {
        return divesRepository.getDiveByLocation(location);
    }

    public void deleteDiveById(int id) {
        divesRepository.deleteDiveById(id);
    }
}

