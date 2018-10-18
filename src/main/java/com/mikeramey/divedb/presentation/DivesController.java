package com.mikeramey.divedb.presentation;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.DivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user/logbook/dives/")
public class DivesController {

    @Resource
    private DivesService divesService;

    @Autowired
    public DivesController(DivesService divesService) { this.divesService = divesService; }

    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @GetMapping
    public List<Dive> getAllDives() {

        return divesService.getAllDives();
    }

    @GetMapping("/date/{date}")
    public Dive getByDate(@PathVariable LocalDate date) {
        return divesService.getByDate(date);
    }

    @GetMapping("/location/{location}")
    public List<Dive> getByLocation(@PathVariable String location) {
        return divesService.getByLocation(location);
    }

    @GetMapping("/{id}")
    public Dive getById(@PathVariable Integer id) {
        return divesService.getById(id);
    }

    @DeleteMapping
    public void delete() {
        divesService.delete();
    }

    @DeleteMapping("/{id}")
    public void deleteById(Integer id) {
        divesService.deleteById(id);
    }

}





