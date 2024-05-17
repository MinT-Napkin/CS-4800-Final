package order;

import meal.FoodItem;
import service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurantOfOrigin;
    private Customer receivingCustomer; // incl. customer name & diet restriction
    private Driver driver;
    private List<FoodItem> items = new ArrayList<>();
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickupTime;
    private LocalDateTime orderDeliveredTime;
    private StateOfOrder state;

    public Order()
    {
        this.state = new IdleOrderState();
    }

    public Order(Restaurant fromRestaurant, Customer fromCustomer, LocalDateTime orderCreationTime)
    {
        this.restaurantOfOrigin = fromRestaurant;
        this.receivingCustomer = fromCustomer;
        this.orderCreationTime = orderCreationTime;
        this.state = new IdleOrderState();
    }

    public StateOfOrder getState() {
        return state;
    }

    public void setState(StateOfOrder state) {
        this.state = state;
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (FoodItem item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return receivingCustomer;
    }

    public Restaurant getRestaurant() {
        return restaurantOfOrigin;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getCreationTime() {
        return orderCreationTime;
    }

    public LocalDateTime getPickupTime() {
        return orderPickupTime;
    }

    public LocalDateTime getOrderDeliveryTime() {
        return orderDeliveredTime;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public void setReceivingCustomer(Customer receivingCustomer) {
        this.receivingCustomer = receivingCustomer;
    }

    public void setRestaurantOfOrigin(Restaurant restaurantOfOrigin) {
        this.restaurantOfOrigin = restaurantOfOrigin;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public void setOrderPickupTime(LocalDateTime orderPickupTime) {
        this.orderPickupTime = orderPickupTime;
    }

    public void setOrderDeliveredTime(LocalDateTime orderDeliveredTime) {
        this.orderDeliveredTime = orderDeliveredTime;
    }

    public void createOrder(Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime)
    {
        state.createOrder(this, customer, restaurant, orderCreationTime);
    }

    public void addKetchupToCurrentItem()
    {
        state.addKetchupToCurrentItem(this, items.size()-1);
    }

    public void addMayoToCurrentItem()
    {
        state.addMayoToCurrentItem(this, items.size()-1);
    }

    public void addMustardToCurrentItem()
    {
        state.addMustardToCurrentItem(this, items.size()-1);
    }

    public void addAnotherItem() { state.addAnotherItem(this);}

    public void completeOrder()
    {
        state.completeOrder(this);
    }

    public void pickUpOrder(Driver driver, LocalDateTime pickupTime)
    {
        state.pickUpOrder(this, driver, pickupTime);
        this.driver = driver;
        this.orderPickupTime = pickupTime;
    }

    public void deliverOrder(LocalDateTime deliveryTime)
    {
        state.deliverOrder(this, deliveryTime);
        this.orderDeliveredTime = deliveryTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Details:\n");
        sb.append("Restaurant: ").append(restaurantOfOrigin.getName()).append("\n");
        sb.append("Customer: ").append(receivingCustomer.getName()).append("\n");
        if (driver != null) {
            sb.append("Driver: ").append(driver.getName()).append("\n");
        } else {
            sb.append("Driver: Not assigned\n");
        }
        sb.append("Order Creation Time: ").append(orderCreationTime).append("\n");
        sb.append("Order Pickup Time: ").append(orderPickupTime != null ? orderPickupTime : "Not picked up yet").append("\n");
        sb.append("Order Delivery Time: ").append(orderDeliveredTime != null ? orderDeliveredTime : "Not delivered yet").append("\n");
        sb.append("Items:\n");
        for (FoodItem item : items) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append("Total Cost: $").append(String.format("%.2f", getTotalCost())).append("\n");
        return sb.toString();
    }
}