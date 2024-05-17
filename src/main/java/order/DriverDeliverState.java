package order;

import service.Customer;
import service.Driver;

import java.time.LocalDateTime;

public class DriverDeliverState implements StateOfOrder{

    @Override
    public void createOrder(Order order, Customer customer) {
        // do nothing
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
        System.out.println("Order delivered!");

        order.setOrderDeliveredTime(deliveryTime);

        order.setState(new IdleOrderState());
    }
}
