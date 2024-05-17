package order;

import service.Customer;
import service.Driver;

import java.time.LocalDateTime;

public class IdleOrderState implements StateOfOrder{
    @Override
    public void createOrder(Order order, Customer customer) {

        order.setState(new CustomerOrderState());
    }

    @Override
    public void addKetchup(Order order) {
        // do nothing
    }

    @Override
    public void addMayo(Order order) {
        // do nothing
    }

    @Override
    public void addMustard(Order order) {
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
