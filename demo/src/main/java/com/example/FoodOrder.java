package com.example;

import java.time.LocalDateTime;
import java.util.List;

public class FoodOrder implements Order {
    private Customer customer;
    private Restaurant restaurant;
    private List<List<String>> foodItems; // Update to a list of lists of strings
    private Driver driver;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickupTime;
    private LocalDateTime orderDeliveryTime;

    public FoodOrder(Customer customer, Restaurant restaurant, List<List<String>> foodItems) { // Update the constructor
        this.customer = customer;
        this.restaurant = restaurant;
        this.foodItems = foodItems;
        this.orderCreationTime = LocalDateTime.now();
    }

    @Override
    public void createOrder() {
        System.out.println("Order created: " + this);
    }

    @Override
    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.orderPickupTime = LocalDateTime.now();
        System.out.println("Assigned order to " + driver.getName());
    }

    @Override
    public void completeOrder() {
        this.orderDeliveryTime = LocalDateTime.now();
        System.out.println("Order completed by driver " + driver.getName() + ": " + this);
    }

    // Setter method for orderCreationTime
    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    // Getter method for orderCreationTime
    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }

    // Getter method for customer
    public Customer getCustomer() {
        return customer;
    }

    // Getter method for foodItems
    // Getter method for foodItems
    public List<List<String>> getFoodItems() {
        return foodItems;
    }

    // Setter method for foodItems
    public void setFoodItems(List<List<String>> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "customer=" + customer.getName() +
                ", restaurant=" + restaurant.getName() +
                ", foodItems=" + foodItems +
                ", orderCreationTime=" + orderCreationTime +
                ", orderPickupTime=" + orderPickupTime +
                ", orderDeliveryTime=" + orderDeliveryTime +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getOrderPickupTime() {
        return orderPickupTime;
    }

    public LocalDateTime getOrderDeliveryTime() {
        return orderDeliveryTime;
    }
}