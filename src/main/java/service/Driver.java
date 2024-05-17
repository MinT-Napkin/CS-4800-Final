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

    public void pickupOrder(Order order, LocalDateTime pickupTime) throws DateTimeException {
        LocalTime pickupTimeOnly = pickupTime.toLocalTime();
        Restaurant restaurant = order.getRestaurant();
        if (pickupTime.isBefore(order.getCreationTime()) || pickupTimeOnly.isAfter(restaurant.getClosingHour())) {
            throw new DateTimeException(String.format("""
                    Invalid time to pick up order for Driver "%s"!
                    The order \
                    must be picked up between %s and %s.
                    """, name, order.getCreationTime(), restaurant.getClosingHour()));
        }

        order.pickUpOrder(this, pickupTime);
        orderToDeliver = order;
    }

    public void deliverOrder(LocalDateTime deliveryTime) throws DateTimeException {
       if (deliveryTime.isBefore(orderToDeliver.getPickupTime())) {
           throw new DateTimeException(String.format("""
                   Invalid time to deliver order for Driver %s!, Delivery time must be after %s.
                   """, name, orderToDeliver.getPickupTime()));
       }

       orderToDeliver.deliverOrder(deliveryTime);
    }
}
