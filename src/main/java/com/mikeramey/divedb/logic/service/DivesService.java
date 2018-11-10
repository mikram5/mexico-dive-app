package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class DivesService {

    @Resource
    private DivesRepository divesRepository;

    @Autowired
    public DivesService(DivesRepository divesRepository) {
        this.divesRepository = divesRepository;
    }

    public List<Dive> getAllDives() {
        return divesRepository.getAllDives();
    }

    public Dive save(Dive dive) {
        Dive savedDive = divesRepository.save(dive);
        return savedDive;
    }

    public Dive deleteById(Integer id) {
        return divesRepository.deleteById(id);
    }

    public Dive getByDate(LocalDate date) {
        return divesRepository.getByDate(date);
    }

    public List<Dive> getByLocation(String location) {
        return divesRepository.getByLocation(location);
    }

    public Dive getById(Integer id) {
        return divesRepository.getById(id);
    }


    public Dive updateById(Dive dive) {
        return divesRepository.updateById(dive);
    }
}

