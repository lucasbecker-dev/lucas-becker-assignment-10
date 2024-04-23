package com.coderscampus.assignment10.controller;

import com.coderscampus.assignment10.controller.enums.TimeFrames;
import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class MealPlanController {
    private final String API_KEY = "apiKey";
    private final String TIME_FRAME = "timeFrame";
    private final String TARGET_CALORIES = "targetCalories";
    private final String DIET = "diet";
    private final String EXCLUDE = "exclude";

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;
    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;
    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam(required = false) Integer numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(required = false) String exclusions
    ) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl + spoonacularMealPlanUrl)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TimeFrames.WEEK.toString())
                .queryParam(TARGET_CALORIES, numCalories)
                .queryParam(DIET, diet)
                .queryParam(EXCLUDE, exclusions);
        URI uri = uriComponentsBuilder.build().toUri();
        return restTemplate.getForEntity(uri, WeekResponse.class);
    }

    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam(required = false) Integer numCalories,
            @RequestParam(required = false) String diet,
            @RequestParam(required = false) String exclusions
    ) {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl + spoonacularMealPlanUrl)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TimeFrames.DAY.toString())
                .queryParam(TARGET_CALORIES, numCalories)
                .queryParam(DIET, diet)
                .queryParam(EXCLUDE, exclusions);
        URI uri = uriComponentsBuilder.build().toUri();
        return restTemplate.getForEntity(uri, DayResponse.class);
    }
}
