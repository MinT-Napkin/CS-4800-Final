package service;

import customer.DietPlan;
import order.Order;

import java.time.DateTimeException;
import java.time.LocalDateTime;

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
        Order order = new Order();
        order.createOrder(this, restaurant, orderCreationTime);
        return order;
    }

    public void addKetchupToCurrentItem(Order order)
    {
        order.addKetchupToCurrentItem();
    }

    public void addMayoToCurrentItem(Order order)
    {
        order.addMayoToCurrentItem();
    }

    public void addMustardToCurrentItem(Order order)
    {
        order.addMustardToCurrentItem();
    }

    public void addItem(Order order) { order.addAnotherItem(); }

    public void completeOrder(Order order)
    {
        order.completeOrder();
    }
}
