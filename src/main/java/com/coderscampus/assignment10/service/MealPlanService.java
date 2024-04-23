package com.coderscampus.assignment10.service;

import com.coderscampus.assignment10.controller.enums.TimeFrames;
import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Service
public class MealPlanService {
    private final String API_KEY = "apiKey";
    private final String TIME_FRAME = "timeFrame";
    private final String TARGET_CALORIES = "targetCalories";
    private final String DIET = "diet";
    private final String EXCLUDE = "exclude";
    private final RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;
    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;
    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    @Autowired
    public MealPlanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void init() {
        Objects.requireNonNull(spoonacularApiKey, "spoonacularApiKey cannot be null");
        Objects.requireNonNull(spoonacularBaseUrl, "spoonacularBaseUrl cannot be null");
        Objects.requireNonNull(spoonacularMealPlanUrl, "spoonacularMealPlanUrl cannot be null");
    }

    public ResponseEntity<WeekResponse> getWeekMeals(Integer numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl + spoonacularMealPlanUrl)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TimeFrames.WEEK.toString())
                .queryParam(TARGET_CALORIES, numCalories)
                .queryParam(DIET, diet)
                .queryParam(EXCLUDE, exclusions)
                .build()
                .toUri();
        return restTemplate.getForEntity(uri, WeekResponse.class);
    }

    public ResponseEntity<DayResponse> getDayMeals(Integer numCalories, String diet, String exclusions) {
        URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl + spoonacularMealPlanUrl)
                .queryParam(API_KEY, spoonacularApiKey)
                .queryParam(TIME_FRAME, TimeFrames.DAY.toString())
                .queryParam(TARGET_CALORIES, numCalories)
                .queryParam(DIET, diet)
                .queryParam(EXCLUDE, exclusions)
                .build()
                .toUri();
        return restTemplate.getForEntity(uri, DayResponse.class);
    }
}
