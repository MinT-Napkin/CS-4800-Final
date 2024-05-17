package order;

import meal.FoodItem;
import meal.FoodItemWithKetchup;
import meal.FoodItemWithMayo;
import meal.FoodItemWithMustard;
import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerOrderState implements StateOfOrder {
    @Override
    public void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime) {
        // do nothing
    }

    @Override
    public void addKetchupToCurrentItem(Order order, int currentItemIndex) {
        System.out.println("Ketchup added to current food item!");
        FoodItem currentFood = order.getItems().get(currentItemIndex);
        order.getItems().set(currentItemIndex, new FoodItemWithKetchup(currentFood));
    }

    @Override
    public void addMayoToCurrentItem(Order order, int currentItemIndex) {
        System.out.println("Mayo added to current food item!");
        FoodItem currentFood = order.getItems().get(currentItemIndex);
        order.getItems().set(currentItemIndex, new FoodItemWithMayo(currentFood));
    }

    @Override
    public void addMustardToCurrentItem(Order order, int currentItemIndex) {
        System.out.println("Ketchup added to current food item!");
        FoodItem currentFood = order.getItems().get(currentItemIndex);
        order.getItems().set(currentItemIndex, new FoodItemWithMustard(currentFood));
    }

    @Override
    public void addAnotherItem(Order order) {
        order.getRestaurant().addValidMealToOrder(order, order.getCustomer());
    }

    @Override
    public void completeOrder(Order order) {
        System.out.println(order.getCustomer().getName() + " sent in their order to "
                            + order.getRestaurant().getName());
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
