package com.example;

public class Customer implements User {
    private String name;
    private String address;
    private County county;

    public Customer(String name, String address, County county) {
        this.name = name;
        this.address = address;
        this.county = county;
        registerWithPlatform();
    }

    public void registerWithPlatform() {
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

    public void placeOrder(Order order) {
        System.out.println( "Customer " + name + " is placing an order: " + order );
        order.createOrder();
    }
}

