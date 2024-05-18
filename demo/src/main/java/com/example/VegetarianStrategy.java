package com.example;

import java.util.List;

public class VegetarianStrategy implements DietaryRestrictionStrategy {
    @Override
    public boolean isAllowed(FoodOrder order) {
        // Check if any of the food items contain meat
        for (List<String> foodItem : order.getFoodItems()) {
            for (String item : foodItem) {
                if (item.toLowerCase().contains("meat")) {
                    return false;
                }
            }
        }
        return true;
    }
}
