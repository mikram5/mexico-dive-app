package com.mikeramey.divedb.presentation;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.DivesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController("/user/logbook/dives/")
public class DivesController {

    @Resource
    private DivesService divesService;


    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @GetMapping
    public List<Dive> getAllDives() {

        return divesService.getAllDives();
    }

    @GetMapping("/date/{date}")
    public List<Dive> getByDate(@PathVariable String date) {
        return divesService.getByDate(date);
    }

//    @GetMapping("/location/{location}")
//    public List<Dive> getByLocation(@PathVariable String location) {
//        return divesService.getByLocaton(location);
//    }

}





