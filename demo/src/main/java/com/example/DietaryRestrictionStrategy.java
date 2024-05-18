package com.example;

public interface DietaryRestrictionStrategy {
    boolean isAllowed(FoodOrder order);
}
