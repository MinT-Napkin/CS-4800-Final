package meal;

import service.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Restaurant restaurantOfOrigin;
    private Customer recievingCustomer; // incl. customer name & diet restriction
    private Driver driver;

    private int orderCreationTimeInHrs; // something abt customer w/ this, not sure if implementaiton is correct
    private int orderPickedUpTimeInHrs;
    private int orderDeliveredTimeInHrs;

    public Order(Restaurant fromRestaurant, Customer fromCusomter)
    {
        this.restaurantOfOrigin = fromRestaurant;
        this.recievingCustomer = fromCusomter;
        this.orderCreationTimeInHrs = this.orderPickedUpTimeInHrs = Time.getInstance().getTimeInHrs();

        this.driver = CPPFoodDelivery.getInstance().findDriverByCounty(this.recievingCustomer.getCounty());
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

    public void pickUpOrder()
    {
        this.orderPickedUpTimeInHrs = Time.getInstance().getTimeInHrs();
    }

    public void deliverOrder()
    {
        this.orderPickedUpTimeInHrs = Time.getInstance().getTimeInHrs();
    }
}