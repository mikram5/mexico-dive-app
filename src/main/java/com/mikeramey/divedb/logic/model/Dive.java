package com.mikeramey.divedb.logic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Dive {

    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String location;
    private Double durationInMinutes;
    private Double depthInMeters;
    private String waterCondition;
    private Boolean safetyStop;

    public Dive() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Double getDepthInMeters() {
        return depthInMeters;
    }

    public void setDepthInMeters(Double depthInMeters) {
        this.depthInMeters = depthInMeters;
    }

    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public Boolean getSafetyStop() {
        return safetyStop;
    }

    public void setSafetyStop(Boolean safetyStop) {
        this.safetyStop = safetyStop;
    }
}
