package order;

import service.CPPFoodDelivery;
import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.LocalDateTime;

public class IdleOrderState implements StateOfOrder{
    @Override
    public void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime) {
        CPPFoodDelivery cppFoodDelivery = CPPFoodDelivery.getInstance();

        if (!cppFoodDelivery.isRegisteredCustomer(customer)) {
            throw new IllegalArgumentException("Customer is not registered.");
        }
        if (!cppFoodDelivery.isRegisteredRestaurant(restaurant)) {
            throw new IllegalArgumentException("Restaurant is not registered.");
        }
        if (!customer.getCounty().equals(restaurant.getCounty())) {
            throw new IllegalArgumentException("Customer and restaurant are not in the same county.");
        }

        order.setReceivingCustomer(customer);
        order.setRestaurantOfOrigin(restaurant);
        order.setOrderCreationTime(orderCreationTime);
        restaurant.addValidMealToOrder(order, customer);

        System.out.println(customer.getName() + " orders from " + restaurant.getName());
        order.setState(new CustomerOrderState());
    }

    @Override
    public void addKetchupToCurrentItem(Order order, int currentItemIndex) {
        // do nothing
    }

    @Override
    public void addMayoToCurrentItem(Order order, int currentItemIndex) {
        // do nothing
    }

    @Override
    public void addMustardToCurrentItem(Order order, int currentItemIndex) {
        // do nothing
    }

    @Override
    public void addAnotherItem(Order order) {
        // do nothing
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
