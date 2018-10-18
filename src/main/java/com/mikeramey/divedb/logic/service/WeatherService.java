package com.mikeramey.divedb.logic.service;

import com.mikeramey.divedb.data.WeatherRepository;
import com.mikeramey.divedb.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    public Weather getWeather(String location) {
        return weatherRepository.getWeather(location);
    }
}
