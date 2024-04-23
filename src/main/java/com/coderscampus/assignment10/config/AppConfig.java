package com.coderscampus.assignment10.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;
    @Value("${spoonacular.urls.base}")
    private String spoonacularBaseUrl;
    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealPlanUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String spoonacularApiKey() {
        return spoonacularApiKey;
    }

    @Bean
    public String spoonacularBaseUrl() {
        return spoonacularBaseUrl;
    }

    @Bean
    public String spoonacularMealPlanUrl() {
        return spoonacularMealPlanUrl;
    }
}
