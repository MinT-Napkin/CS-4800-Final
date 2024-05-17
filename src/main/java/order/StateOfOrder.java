package order;

import customer.DietPlan;
import service.Customer;
import service.Driver;

import java.time.LocalDateTime;

public interface StateOfOrder {
    void createOrder(Order order, Customer customer);

    void addKetchup(Order order);

    void addMayo(Order order);

    void addMustard(Order order);

    void completeOrder(Order order);

    void pickUpOrder(Order order, Driver driver, LocalDateTime deliveryTime);

    void deliverOrder(Order order, LocalDateTime deliveryTime);
}
