package order;

import meal.FoodItem;
import service.CPPFoodDelivery;
import service.Customer;
import service.Driver;
import service.Restaurant;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PickupOrderState implements StateOfOrder
{
    @Override
    public void createOrder(Order order, Customer customer, Restaurant restaurant, LocalDateTime orderCreationTime) {
        // do nothing
    }

    @Override
    public void addKetchupToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addMayoToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addMustardToCurrentItem(Order order, int currentItemIndex) {

    }

    @Override
    public void addAnotherItem(Order order) {

    }

    @Override
    public void completeOrder(Order order) {
        // do nothing
    }

    @Override
    public void pickUpOrder(Order order, Driver driver, LocalDateTime pickupTime) {
        CPPFoodDelivery cppFoodDelivery = CPPFoodDelivery.getInstance();
        LocalTime pickupTimeOnly = pickupTime.toLocalTime();
        Restaurant restaurant = order.getRestaurant();

        if (driver == null || !cppFoodDelivery.isRegisteredDriver(driver)) {
            throw new IllegalArgumentException("Driver is not registered.");
        }

        if (!driver.getOperatingCounty().equals(restaurant.getCounty())) {
            throw new IllegalArgumentException("Driver and restaurant are not in the same county.");
        }

        if (pickupTime.isBefore(order.getCreationTime()) || pickupTimeOnly.isAfter(restaurant.getClosingHour())) {
            throw new DateTimeException(String.format("""
                    Invalid time to pick up order for Driver "%s"!
                    The order \
                    must be picked up between %s and %s.
                    """, driver.getName(), order.getCreationTime(), restaurant.getClosingHour()));
        }

        driver.setOrderToDeliver(order);
        order.setState(new DriverDeliverState());
    }

    @Override
    public void deliverOrder(Order order, LocalDateTime deliveryTime) {
        // do nothing
    }
}
