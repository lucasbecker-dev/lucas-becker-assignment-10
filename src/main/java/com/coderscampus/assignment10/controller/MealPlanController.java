package com.coderscampus.assignment10.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlanController {

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String mealPlanUrl;


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
