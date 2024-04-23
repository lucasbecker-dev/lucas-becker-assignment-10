package com.coderscampus.assignment10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeekResponse {
    @JsonProperty("week")
    private List<DayResponse> week;

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }

    public List<DayResponse> getWeek() {
        return week;
    }

    public void setWeek(List<DayResponse> week) {
        this.week = week;
    }
}
