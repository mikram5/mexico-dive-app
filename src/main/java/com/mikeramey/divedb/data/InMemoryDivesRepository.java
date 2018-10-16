package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryDivesRepository implements DivesRepository {

    private List<Dive> diveList = new ArrayList<>();

    public InMemoryDivesRepository() {

        Dive dive = new Dive();
        dive.setDate("2018-10-03");
        dive.setDepth(18);
        dive.setDuration(45);
        dive.setLocation("St. Croix");
        dive.setSafetyStop(true);
        dive.setWaterCondition("smooth");
        //set all the fields

        Dive dive2 = new Dive();
        dive2.setDate("2018-09-15");
        dive2.setDepth(15);
        dive2.setDuration(50);
        dive2.setLocation("Belize");
        dive2.setSafetyStop(true);
        dive2.setWaterCondition("choppy");
        //create dive 2
        diveList.add(dive);
        diveList.add(dive2);
    }

    @Override
    public Dive save(Dive dive) {
        diveList.add(dive);
        return dive;
    }

    @Override
    public List<Dive> getAllDives() {

        return diveList;
    }

}
