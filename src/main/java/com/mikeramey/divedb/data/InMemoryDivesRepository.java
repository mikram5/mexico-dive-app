package com.mikeramey.divedb.data;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.repository.DivesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryDivesRepository  {

    private List<Dive> diveList = new ArrayList<>();
    private Integer integer = 0;

    public InMemoryDivesRepository() {

        Dive dive = new Dive();
        dive.setId(integer++);
       // dive.setDate("2018-10-03");
        dive.setDepthInMeters(18.0);
        dive.setDurationInMinutes(45.0);
        dive.setLocation("St. Croix");
        dive.setSafetyStop(true);
        dive.setWaterCondition("smooth");
        //set all the fields

        Dive dive2 = new Dive();
        dive2.setId(integer++);
       // dive2.setDate("2018-09-15");
        dive2.setDepthInMeters(15.0);
        dive2.setDurationInMinutes(50.0);
        dive2.setLocation("Belize");
        dive2.setSafetyStop(true);
        dive2.setWaterCondition("choppy");
        //create dive 2
        diveList.add(dive);
        diveList.add(dive2);
    }

//    @Override
//    public Dive save(Dive dive) {
//        dive.setId(integer++);
//        diveList.add(dive);
//        return dive;
//    }

//    @Override
//    public List<Dive> getAllDives() {
//        return diveList;
//    }
//
//    @Override
//    public List<Dive> getByDate(String date) {
//        return diveList.stream()
//                .filter(dive -> dive.getDate().equals(date))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dive> getByLocation(String location) {
//        return diveList.stream()
//                .filter(dive -> dive.getLocation().equals(location))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dive> getById(Integer id) {
//        return diveList.stream()
//                .filter(dive -> dive.getId().equals(id))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void delete() {
//        diveList.clear();
//        integer = 0;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        diveList.remove(id);
//    }
}
