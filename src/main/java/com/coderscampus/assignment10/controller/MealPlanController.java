package com.coderscampus.assignment10.controller;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class MealPlanController {
    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;

    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    private final String API_KEY = "apiKey";
    private final String TIME_FRAME = "timeFrame";
    private final String TARGET_CALORIES = "targetCalories";
    private final String DIET = "diet";
    private final String EXCLUDE = "exclude";
    private final String MEAL_PLAN_GENERATOR_URL = spoonacularBaseUrl + spoonacularMealPlanUrl;

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        final String TIME_FRAME_WEEK = "week";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(MEAL_PLAN_GENERATOR_URL)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TIME_FRAME_WEEK);
        if (numCalories != null) {
            uriComponentsBuilder.queryParam(TARGET_CALORIES, numCalories);
        }
        if (diet != null) {
            uriComponentsBuilder.queryParam(DIET, diet);
        }
        if (exclusions != null) {
            uriComponentsBuilder.queryParam(EXCLUDE, exclusions);
        }
        URI uri = uriComponentsBuilder.build().toUri();
        return restTemplate.getForEntity(uri, WeekResponse.class);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        RestTemplate restTemplate = new RestTemplate();
        final String TIME_FRAME_DAY = "day";
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(MEAL_PLAN_GENERATOR_URL)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TIME_FRAME_DAY);
        if (numCalories != null) {
            uriComponentsBuilder.queryParam(TARGET_CALORIES, numCalories);
        }
        if (diet != null) {
            uriComponentsBuilder.queryParam(DIET, diet);
        }
        if (exclusions != null) {
            uriComponentsBuilder.queryParam(EXCLUDE, exclusions);
        }
        URI uri = uriComponentsBuilder.build().toUri();
        return restTemplate.getForEntity(uri, DayResponse.class);
    }
}
