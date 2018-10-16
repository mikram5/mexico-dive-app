package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DivesService {

    @Resource
    private DivesRepository divesRepository;

    public List<Dive> getAllDives() {

        List<Dive> diveList = divesRepository.getAllDives();
        return diveList;
    }

    public Dive save(Dive dive) {
        divesRepository.save(dive);
        return dive;
    }

}
