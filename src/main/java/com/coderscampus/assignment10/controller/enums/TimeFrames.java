package com.coderscampus.assignment10.controller.enums;

public enum TimeFrames {
    DAY("day"),
    WEEK("week");

    private final String displayName;

    TimeFrames(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


