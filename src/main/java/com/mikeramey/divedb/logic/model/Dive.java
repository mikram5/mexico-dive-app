package com.mikeramey.divedb.logic.model;

public class Dive {

    private String date;
    private String location;
    private double duration;
    private double depth;
    private String waterCondition;
    private boolean safetyStop;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public boolean isSafetyStop() {
        return safetyStop;
    }

    public void setSafetyStop(boolean safetyStop) {
        this.safetyStop = safetyStop;
    }

    @Override
    public String toString() {
        return "Dive{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", duration=" + duration +
                ", depth=" + depth +
                ", waterCondition='" + waterCondition + '\'' +
                ", safetyStop=" + safetyStop +
                '}';
    }
}
