package service;

import customer.DietPlan;
import meal.Order;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Customer {
    private String name;
    private String address;
    private String county;
    private DietPlan dietPlan;

    public Customer(String name,
                    String address,
                    String county,
                    DietPlan dietPlan) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.dietPlan = dietPlan;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCounty() {
        return county;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }

    public Order createOrder(Restaurant restaurant, LocalDateTime orderCreationTime) throws DateTimeException {
        return restaurant.createOrder(this, orderCreationTime);
    }
}
