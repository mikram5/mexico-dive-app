package com.mikeramey.divedb.presentation;

import com.mikeramey.divedb.logic.model.Weather;
import com.mikeramey.divedb.logic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public Weather getWeather(@Param("location") String location){
        return weatherService.getWeather(location);

    }


}

