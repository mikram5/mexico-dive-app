package com.mikeramey.divedb.data.apiWeatherResponse;

import com.mikeramey.divedb.logic.model.Weather;

public class ApiWeatherMapper {

    public Weather apiWeatherMapper(ApiWeatherResponse apiWeatherResponse){
        Weather weather = new Weather();
        weather.setTemp(apiWeatherResponse.getMain().getTemp());
        weather.setCity(apiWeatherResponse.getName());
        weather.setCountry(apiWeatherResponse.getSys().getCountry());
        weather.setHumidity(apiWeatherResponse.getMain().getHumidity());
        weather.setPressure(apiWeatherResponse.getMain().getPressure());
        weather.setWindSpeed(apiWeatherResponse.getWind().getSpeed());
        weather.setVisibility(apiWeatherResponse.getVisibility());
        return weather;
    }




}
