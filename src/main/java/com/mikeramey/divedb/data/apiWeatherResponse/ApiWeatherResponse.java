package com.mikeramey.divedb.data.apiWeatherResponse;

public class ApiWeatherResponse {
    private String name;
    private Integer visibility;
    private Main main;
    private Wind wind;
    private Weather[] weather;

    public Sys getSys() {
        return sys;
    }

    private Sys sys;

    public String getName() {
        return name;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Weather[] getWeather() {
        return weather;
    }
}
