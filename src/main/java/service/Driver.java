package service;

import order.Order;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Driver
{
    private String name;
    private String address;
    private String operatingCounty;
    private Order orderToDeliver;

    public Driver(String name,
                  String address,
                  String operatingCounty)
    {
        this.name = name;
        this.address = address;
        this.operatingCounty = operatingCounty;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOperatingCounty() {
        return operatingCounty;
    }

    public Order getOrderToDeliver() {
        return orderToDeliver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOperatingCounty(String operatingCounty) {
        this.operatingCounty = operatingCounty;
    }

    public void setOrderToDeliver(Order orderToDeliver) {
        this.orderToDeliver = orderToDeliver;
    }

    public void pickupOrder(Order order, LocalDateTime pickupTime) throws DateTimeException {
        order.pickUpOrder(this, pickupTime);
    }

    public void deliverOrder(LocalDateTime deliveryTime) throws DateTimeException {
       orderToDeliver.deliverOrder(deliveryTime);
    }
}
