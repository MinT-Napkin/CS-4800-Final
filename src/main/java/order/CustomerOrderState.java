package order;

import service.Customer;
import service.Driver;

import java.time.LocalDateTime;

public class CustomerOrderState implements StateOfOrder {
    @Override
    public void createOrder(Order order, Customer customer) {
        // do nothing
    }

    @Override
    public void addKetchup(Order order) {

    }

    @Override
    public void addMayo(Order order) {

    }

    @Override
    public void addMustard(Order order) {

    }

    @Override
    public void completeOrder(Order order) {
        order.setState(new PickupOrderState());
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
