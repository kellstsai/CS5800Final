package com.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderFactory {
    private static final Map<String, FoodOrder> orders;

    static {
        orders = new HashMap<>();
    }

    public static FoodOrder getOrder(Customer customer, Restaurant restaurant, List<String> foodItems) {
        String key = customer.getName() + restaurant.getName() + foodItems.toString();
        FoodOrder order = orders.get(key);

        if (order == null) {
            order = new FoodOrder(customer, restaurant, Collections.singletonList( Collections.singletonList( foodItems.toString() ) ) );
            orders.put(key, order);
        }

        return order;
    }
}
