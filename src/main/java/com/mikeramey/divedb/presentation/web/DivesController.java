package com.mikeramey.divedb.presentation.web;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.DivesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/newDive")
    public String newDive(Model model) {
        model.addAttribute("dive", new Dive());
        return "newDive";
    }

    @PostMapping("/newDive")
    public String newDiveSubmit(@ModelAttribute("dive") Dive dive) {
        divesService.save(dive);
        return "newDive";
    }


}
