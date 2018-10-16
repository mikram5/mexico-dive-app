package com.mikeramey.divedb.presentation;

import com.mikeramey.divedb.logic.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DiveCalculatorController {

    @Resource
    private CalculatorService calculatorService;


    @GetMapping("/dive_calculator")
    public Double calculate(@RequestParam(value = "firstDiveDepth", defaultValue = "20") Double firstDiveDepth,
                            @RequestParam(value = "firstDiveLength", defaultValue = "30") Double firstDiveLength,
                            @RequestParam(value = "secondDiveDepth", defaultValue = "15") Double secondDiveDepth,
                            @RequestParam(value = "secondDiveLength", defaultValue = "40") Double secondDiveLength) {
        return calculatorService.planDive(firstDiveDepth, firstDiveLength, secondDiveDepth, secondDiveLength);
    }


}
