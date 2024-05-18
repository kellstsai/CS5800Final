package com.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements User, Observable {
    private String name;
    private String address;
    private County county;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<Observer> observers = new ArrayList<>();

    public Restaurant(String name, String address, County county, String operatingHours) {
        this.name = name;
        this.address = address;
        this.county = county;
        String[] hours = operatingHours.split("-");
        this.openingTime = LocalTime.parse(hours[0]);
        this.closingTime = LocalTime.parse(hours[1]);
        registerWithPlatform();
    }

    public Restaurant(String string, LocalTime of, LocalTime of2) {
        //TODO Auto-generated constructor stub
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

    public boolean isOpen(LocalDateTime time) {
        LocalTime currentTime = time.toLocalTime();
        LocalDate currentDate = time.toLocalDate();
        return currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime) &&
                currentDate.getDayOfWeek() != DayOfWeek.SUNDAY; // Ensure restaurant is open on weekdays
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(null, null);
        }
    }

    public void createOrder(Order order) {
        System.out.println("Restaurant " + name + " is processing the order: " + order);
        notifyObservers();
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }
}
