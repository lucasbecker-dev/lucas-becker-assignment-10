package com.coderscampus.assignment10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MealPlanController
{
    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        // TODO: implement getWeekMeals()
        throw new RuntimeException("getWeekMeals() has not been implemented.");
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        // TODO: implement getDayMeals()
        throw new RuntimeException("getDayMeals() has not been implemented.");
    }
}
