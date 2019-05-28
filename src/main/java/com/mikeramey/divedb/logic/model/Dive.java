package com.mikeramey.divedb.logic.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Dive {

    private Integer id;
    private Integer userId;
    private String location;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double durationInMinutes;
    private Double depthInMeters;
    private String waterCondition;

    public Dive() {
    }

    public Dive(Integer id, Integer userId, String location, LocalDate date, Double durationInMinutes, Double depthInMeters, String waterCondition) {
        this.id = id;
        this.userId = userId;
        this.location = location;
        this.date = date;
        this.durationInMinutes = durationInMinutes;
        this.depthInMeters = depthInMeters;
        this.waterCondition = waterCondition;
    }

    @Override
    public String toString() {
        return "Dive{" +
                "id=" + id +
                ", userId=" + userId +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", durationInMinutes=" + durationInMinutes +
                ", depthInMeters=" + depthInMeters +
                ", waterCondition='" + waterCondition + '\'' +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

}
