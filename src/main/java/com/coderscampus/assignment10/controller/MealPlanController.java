package com.coderscampus.assignment10.controller;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import com.coderscampus.assignment10.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlanController {
    private final MealPlanService mealPlanService;

    @Autowired
    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam(required = false) Integer numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(required = false) String exclusions
    ) {
        return mealPlanService.getWeekMeals(numCalories, diet, exclusions);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam(required = false) Integer numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(required = false) String exclusions
    ) {
        return mealPlanService.getDayMeals(numCalories, diet, exclusions);
    }
}
