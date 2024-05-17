package order;

import customer.DietPlan;
import meal.FoodItem;
import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.LocalDateTime;

public interface StateOfOrder {
    void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime);

    void addKetchupToCurrentItem(Order order, int currentItemIndex);

    void addMayoToCurrentItem(Order order, int currentItemIndex);

    void addMustardToCurrentItem(Order order, int currentItemIndex);

    void addAnotherItem(Order order);

    void completeOrder(Order order);

    void pickUpOrder(Order order, Driver driver, LocalDateTime pickupTime);

    void deliverOrder(Order order, LocalDateTime deliveryTime);
}
