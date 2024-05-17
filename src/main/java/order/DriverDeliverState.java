package order;

import meal.FoodItem;
import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class DriverDeliverState implements StateOfOrder{

    @Override
    public void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime) {
        // do nothing
    }

    @Override
    public void addKetchupToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addMayoToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addMustardToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addAnotherItem(Order order) {

    }

    @Override
    public void completeOrder(Order order) {
        // do nothing
    }

    @Override
    public void pickUpOrder(Order order, Driver driver, LocalDateTime deliveryTime) {
        // do nothing
    }

    @Override
    public void deliverOrder(Order order, LocalDateTime deliveryTime) {
        System.out.println("Order delivered!");

        if (deliveryTime.isBefore(order.getPickupTime())) {
            throw new DateTimeException(String.format("""
                   Invalid time to deliver order for Driver %s!, Delivery time must be after %s.
                   """, order.getDriver(), order.getPickupTime()));
        }

        order.setOrderDeliveredTime(deliveryTime);

        order.setState(new IdleOrderState());
    }
}
