package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.data.apiWeatherResponse.WeatherApiRepository;
import com.mikeramey.divedb.data.apiWeatherResponse.ApiWeatherResponse;
import com.mikeramey.divedb.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherApiRepository weatherApiRepository;

    @Autowired
    public WeatherService(WeatherApiRepository weatherApiRepository) {
        this.weatherApiRepository = weatherApiRepository;
    }

    public Weather getResult(String location) {
        return weatherApiRepository.getWeather(location);
    }
}
