package com.mikeramey.divedb.presentation;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.DivesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DivesController {

    @Resource
    private DivesService divesService;


    @PostMapping
    public Dive save(@RequestBody Dive dive) {
        return divesService.save(dive);
    }

    @GetMapping("/user/logbook/dives/")
    public List<Dive> getAllDives() {

        return divesService.getAllDives();
    }

}


