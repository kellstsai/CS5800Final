package com.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CPPFoodDelivery {
    private static CPPFoodDelivery instance;
    private List<User> customers = new ArrayList<>();
    private List<User> restaurants = new ArrayList<>();
    private List<User> drivers = new ArrayList<>();

    private CPPFoodDelivery() {}

    public static synchronized CPPFoodDelivery getInstance() {
        if (instance == null) {
            instance = new CPPFoodDelivery();
        }
        return instance;
    }

    public void registerUser(User user) {
        if (user instanceof Customer && !customers.contains(user)) {
            customers.add(user);
        } else if (user instanceof Restaurant && !restaurants.contains(user)) {
            restaurants.add(user);
        } else if (user instanceof Driver && !drivers.contains(user)) {
            drivers.add(user);
        }
    }

    public List<User> getDrivers() {
        return drivers;
    }

    public void placeOrder(FoodOrder order) {
        Restaurant restaurant = order.getRestaurant();
        LocalDateTime orderCreationTime = order.getOrderCreationTime();

        drivers = this.getDrivers();

        Driver availableDriverValidOrder = null;

        // Check if the restaurant is open and the order is placed within the driver's shift and chosen county
        if (restaurant.isOpen(orderCreationTime)) {
            for (User user : drivers) {
                Driver driver = (Driver) user;
                System.out.println("Driver: " + driver.getName() + ", Shift Start: " + driver.getShift().getStart() +
                        ", Order Creation Time: " + order.getOrderCreationTime().toLocalTime());
                // Check if the shift spans midnight
                if (driver.getShift().getStart().isAfter(driver.getShift().getEnd())) {
                    // Shift spans midnight, check if the order creation time falls within the shift
                    if (order.getOrderCreationTime().toLocalTime().isAfter(driver.getShift().getStart()) ||
                            order.getOrderCreationTime().toLocalTime().isBefore(driver.getShift().getEnd())) {
                        availableDriverValidOrder = driver;
                        break;
                    }
                } else {
                    // Shift does not span midnight, perform normal comparison
                    if (order.getOrderCreationTime().toLocalTime().compareTo(driver.getShift().getStart()) >= 0 &&
                            order.getOrderCreationTime().toLocalTime().compareTo(driver.getShift().getEnd()) <= 0) {
                        availableDriverValidOrder = driver;
                        break;
                    }
                }
            }

            // Assign available driver for the valid order or print "No driver available"
            if (availableDriverValidOrder != null) {
                order.assignDriver(availableDriverValidOrder);
                availableDriverValidOrder.update(order, restaurant);
            } else {
                System.out.println("No driver available for the valid order.");
            }
            System.out.println(); // Add a blank line for readability

        } else {
            System.out.println("Restaurant Closed: " + restaurant.getName() +
                    " is currently closed. " +
                    "Customer " + order.getCustomer().getName() +
                    " attempted to place an order for " + order.getFoodItems() + ".");
        }
        System.out.println(); // Add a blank line for readability
    }



    public void printRegisteredUsers() {
        System.out.println("Registered Restaurants:");
        for (User restaurant : restaurants) {
            Restaurant r = (Restaurant) restaurant;
            System.out.println("Name: " + r.getName() + ", Opening Time: " + r.getOpeningTime() + ", Closing Time: " + r.getClosingTime());
        }

        System.out.println("\nRegistered Drivers:");
        for (User driver : drivers) {
            System.out.println(((Driver) driver).getName());
        }

        System.out.println("\nRegistered Customers:");
        for (User customer : customers) {
            System.out.println(((Customer) customer).getName());
        }
    }
}

