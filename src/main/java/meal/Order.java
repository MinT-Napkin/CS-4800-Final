package meal;

import service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurantOfOrigin;
    private Customer receivingCustomer; // incl. customer name & diet restriction
    private Driver driver;

    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickupTime;
    private LocalDateTime orderDeliveredTime;

    public Order(Restaurant fromRestaurant, Customer fromCustomer, LocalDateTime orderCreationTime)
    {
        this.restaurantOfOrigin = fromRestaurant;
        this.receivingCustomer = fromCustomer;
        this.orderCreationTime = orderCreationTime;
    }

    private List<FoodItem> items = new ArrayList<>();

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

    public void pickUpOrder(Driver driver, LocalDateTime pickupTime)
    {
        this.driver = driver;
        this.orderPickupTime = pickupTime;
    }

    public void deliverOrder(LocalDateTime deliveryTime)
    {
        this.orderDeliveredTime = deliveryTime;
    }
}