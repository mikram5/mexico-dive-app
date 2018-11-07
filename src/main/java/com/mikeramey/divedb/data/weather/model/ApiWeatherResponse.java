package com.mikeramey.divedb.data.weather.model;

public class ApiWeatherResponse {
    private String name;
    private Integer visibility;
    private Main main;
    private Wind wind;
    private Weather[] weather;
    private Sys sys;


    public Sys getSys() {
        return sys;
    }

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
