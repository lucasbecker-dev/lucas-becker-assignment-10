package com.coderscampus.assignment10.service;

import com.coderscampus.assignment10.controller.enums.TimeFrame;
import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Service
public class MealPlanService {
    private final String API_KEY = "apiKey";
    private final String TIME_FRAME = "timeFrame";
    private final String TARGET_CALORIES = "targetCalories";
    private final String DIET = "diet";
    private final String EXCLUDE = "exclude";
    private final RestTemplate restTemplate;
    private final String spoonacularApiKey;
    private final String spoonacularBaseUrl;
    private final String spoonacularMealPlanUrl;

    @Autowired
    public MealPlanService(RestTemplate restTemplate, String spoonacularApiKey, String spoonacularBaseUrl, String spoonacularMealPlanUrl) {
        this.restTemplate = restTemplate;
        this.spoonacularApiKey = spoonacularApiKey;
        this.spoonacularBaseUrl = spoonacularBaseUrl;
        this.spoonacularMealPlanUrl = spoonacularMealPlanUrl;
    }

    @PostConstruct
    private void init() {
        Objects.requireNonNull(spoonacularApiKey, "spoonacularApiKey cannot be null");
        Objects.requireNonNull(spoonacularBaseUrl, "spoonacularBaseUrl cannot be null");
        Objects.requireNonNull(spoonacularMealPlanUrl, "spoonacularMealPlanUrl cannot be null");
    }

    public ResponseEntity<WeekResponse> getWeekMeals(Integer numCalories, String diet, String exclusions) {
        return getMealPlan(TimeFrame.WEEK, numCalories, diet, exclusions, WeekResponse.class);
    }

    public ResponseEntity<DayResponse> getDayMeals(Integer numCalories, String diet, String exclusions) {
        return getMealPlan(TimeFrame.DAY, numCalories, diet, exclusions, DayResponse.class);
    }

    private <T> ResponseEntity<T> getMealPlan(
            TimeFrame timeFrame,
            Integer numCalories,
            String diet,
            String exclusions,
            Class<T> responseType
    ) {
        ResponseEntity<T> response = null;
        try {
            URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularBaseUrl + spoonacularMealPlanUrl)
                    .queryParam(API_KEY, spoonacularApiKey)
                    .queryParam(TIME_FRAME, timeFrame.toString())
                    .queryParamIfPresent(TARGET_CALORIES, Optional.ofNullable(numCalories))
                    .queryParamIfPresent(DIET, Optional.ofNullable(diet))
                    .queryParamIfPresent(EXCLUDE, Optional.ofNullable(exclusions))
                    .build()
                    .toUri();
            System.out.println(uri.toString());
            response = restTemplate.getForEntity(uri, responseType);
        } catch (RestClientException e) {
            System.err.println("Error getting generated meal plan from Spoonacular:\n" + e);
        }
        return response;
    }
}
