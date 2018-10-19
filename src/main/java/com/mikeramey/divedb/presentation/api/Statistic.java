package com.mikeramey.divedb.presentation.api;

public class Statistic {

    private Integer numberOfDives;
    private String description;
    private Double timeUnder;
    private String descriptionTimeUnder;

    public Double getTimeUnder() {
        return timeUnder;
    }

    public void setTimeUnder(Double timeUnder) {
        this.timeUnder = timeUnder;
    }

    public String getDescriptionTimeUnder() {
        return descriptionTimeUnder;
    }

    public void setDescriptionTimeUnder(String descriptionTimeUnder) {
        this.descriptionTimeUnder = descriptionTimeUnder;
    }

    public Integer getNumberOfDives() {
        return numberOfDives;
    }

    public void setNumberOfDives(Integer numberOfDives) {
        this.numberOfDives = numberOfDives;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}


