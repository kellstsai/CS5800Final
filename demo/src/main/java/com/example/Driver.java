package com.example;

import java.util.ArrayList;
import java.util.List;

public class Driver implements User, Observer {
    private String name;
    private String address;
    private County county;
    private Shift shift;
    private List<Order> orders = new ArrayList<>();

    public Driver(String name, String address, County county, Shift shift) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.shift = shift;
        registerWithPlatform();
    }

    private void registerWithPlatform() {
        CPPFoodDelivery.getInstance().registerUser(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public County getCounty() {
        return county;
    }

    public Shift getShift() {
        return shift;
    }

    @Override
    public void update(FoodOrder order, Restaurant restaurant) {
        if (!restaurant.getCounty().equals(county)) {
            System.out.println("Driver " + name + " cannot accept the order because the restaurant is not in County " + county);
        } else if (!order.getOrderCreationTime().toLocalTime().isAfter(shift.getStart()) ||
                !order.getOrderCreationTime().toLocalTime().isBefore(shift.getEnd())) {
            System.out.println("Driver " + name + " cannot accept the order because it falls outside the shift hours.");
        } else {
            orders.add(order);
            System.out.println("Driver " + name + " in County " + county + " received a new order: " + order);
        }
    }


    @Override
    public String toString() {
        return "Driver{name='" + name + "', county='" + county + "', shift='" + shift + "'}";
    }
}

