package meal;

import service.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurantOfOrigin;
    private Customer receivingCustomer; // incl. customer name & diet restriction
    private Driver driver;

    private LocalTime orderCreationTime;
    private LocalTime orderPickupTime;
    private LocalTime orderDeliveredTime;

    public Order(Restaurant fromRestaurant, Customer fromCustomer, LocalTime orderCreationTime)
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

    public void pickUpOrder(Driver driver, LocalTime pickupTime)
    {
        this.driver = driver;
        this.orderPickupTime = pickupTime;
    }

    public void deliverOrder(LocalTime deliveryTime)
    {
        this.orderDeliveredTime = deliveryTime;
    }
}