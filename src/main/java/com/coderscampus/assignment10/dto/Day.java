package com.coderscampus.assignment10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Day {
    @JsonProperty("meals")
    private List<Meal> meals;
    @JsonProperty("nutrients")
    private Nutrients nutrients;

    @Override
    public String toString() {
        return "MealPlan{" +
                "mealList=" + meals +
                ", nutrients=" + nutrients +
                '}';
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }
}