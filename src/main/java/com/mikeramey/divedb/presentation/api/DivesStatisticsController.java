package com.mikeramey.divedb.presentation.api;

import com.mikeramey.divedb.logic.service.DivesStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/statistics")
public class DivesStatisticsController {

    @Resource
    private DivesStatisticsService divesStatisticsService;

    @Autowired
    public DivesStatisticsController(DivesStatisticsService divesStatisticsService) {
        this.divesStatisticsService = divesStatisticsService;
    }

    @GetMapping
    public Statistic getStatistics() {
        Statistic statistic = new Statistic();
        statistic.setTimeUnder(getTotalTimeUnderWater());
        statistic.setNumberOfDives(getNumberOfDives());
        return statistic;
    }


    private Integer getNumberOfDives() {
        return divesStatisticsService.getNumberOfDives();

    }


    private Double getTotalTimeUnderWater() {
        return divesStatisticsService.getTotalTimeUnderwater();
    }
}
