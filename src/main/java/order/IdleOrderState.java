package order;

import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class IdleOrderState implements StateOfOrder{
    @Override
    public void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime) {
        //TODO verify if customer/restuarant are registered
        //TODO verify if customer/restaurant are in same county
        order.setReceivingCustomer(customer);
        order.setRestaurantOfOrigin(restaurant);
        order.setOrderCreationTime(orderCreationTime);
        restaurant.addValidMealToOrder(order, customer);

        System.out.println(customer.getName() + " orders from " + restaurant.getName());
        order.setState(new CustomerOrderState());
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
        // do nothing
    }
}
