package com.example;

public interface Order {
    void createOrder();
    void assignDriver(Driver driver);
    void completeOrder();
}