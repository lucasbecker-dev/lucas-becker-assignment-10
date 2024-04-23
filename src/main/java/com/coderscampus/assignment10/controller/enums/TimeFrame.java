package com.coderscampus.assignment10.controller.enums;

public enum TimeFrame {
    DAY("day"),
    WEEK("week");

    private final String displayName;

    TimeFrame(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}


