package com.coderscampus.assignment10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {
    @JsonProperty("week")
    private Week week;

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }
}
