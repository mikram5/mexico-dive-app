package com.mikeramey.divedb.presentation.web;

import com.mikeramey.divedb.logic.service.DivesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class DivesController {

    @Resource
    private DivesService divesService;


    @GetMapping("/dives")
    public String home(Model model) {
        model.addAttribute("dives", divesService.getAllDives());
        return "dives";
    }
}
