package com.mikeramey.divedb.presentation.api;

import com.mikeramey.divedb.data.apiWeatherResponse.ApiWeatherResponse;
import com.mikeramey.divedb.logic.model.Weather;
import com.mikeramey.divedb.logic.service.WeatherService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController (WeatherService weatherService) { this.weatherService = weatherService; }

    @GetMapping("/location/{location}")
    public Weather getResult(@PathVariable("location") String location) { return weatherService.getResult(location); }


    @GetMapping
    public Weather getResultWithParam(@Param("location") String location) { return weatherService.getResult(location); }
}




