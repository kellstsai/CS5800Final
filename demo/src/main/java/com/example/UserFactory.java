package com.example;

public class UserFactory {
    public static User createUser(String type, String name, String address, County county, String additionalInfo, Shift shift) {
        switch (type.toLowerCase()) {
            case "customer":
                return new Customer(name, address, county);
            case "restaurant":
                return new Restaurant(name, address, county, additionalInfo);
            case "driver":
                return new Driver(name, address, county, shift);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}