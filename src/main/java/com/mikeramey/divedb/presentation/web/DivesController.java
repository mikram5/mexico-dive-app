package com.mikeramey.divedb.presentation.web;

import com.mikeramey.divedb.logic.model.Dive;
import com.mikeramey.divedb.logic.service.DivesService;
import com.mikeramey.divedb.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class DivesController {

    @Autowired
    private DivesService divesService;

    @Autowired
    private UserService userService;


    @GetMapping("/dives")
    public ModelAndView allDives(ModelAndView modelAndView) {
        modelAndView.addObject("dive", divesService.getDivesByUserId(userService.getCurrentUserId()));
        modelAndView.setViewName("/dives");
        return modelAndView;
    }

    @GetMapping("/addNewDive")
//    public String newDive(Model model) {
//        model.addAttribute("dive", new Dive());
//        return "addNewDive";
//    }
    public ModelAndView addNewDive(ModelAndView modelAndView) {
        Dive dive = new Dive();

        modelAndView.setViewName("addNewDive");
        modelAndView.addObject("dive", dive);
        return modelAndView;
    }

    @PostMapping("/addNewDive")
//    public String newDiveSubmit(@ModelAttribute("dive") Dive dive) {
//        divesService.save(dive);
//        return "addNewDive";
//    }
    public ModelAndView dive(@ModelAttribute Dive dive, ModelAndView modelAndView) {
        dive.setUserId(userService.getCurrentUserId());
        divesService.save(dive);
        modelAndView.setViewName("dives");
        return modelAndView;
    }

    @GetMapping("/deletedive")
    public RedirectView deleteDive(@RequestParam(name = "id") Integer id) {
        divesService.deleteDiveByUserId(id);
        return new RedirectView("/dives");
    }
}
