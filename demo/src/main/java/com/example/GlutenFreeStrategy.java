package com.example;

import java.util.List;

public class GlutenFreeStrategy implements DietaryRestrictionStrategy {
    @Override
    public boolean isAllowed(FoodOrder order) {
        // Check if any of the food items contain gluten
        for (List<String> foodItem : order.getFoodItems()) {
            for (String item : foodItem) {
                if (item.toLowerCase().contains("gluten")) {
                    return false;
                }
            }
        }
        return true;
    }
}
