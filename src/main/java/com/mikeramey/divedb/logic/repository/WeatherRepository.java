package com.mikeramey.divedb.logic.repository;

import com.mikeramey.divedb.data.apiWeatherResponse.ApiWeatherResponse;
import com.mikeramey.divedb.logic.model.Weather;

public interface WeatherRepository {

    Weather getWeather(String location);
}
