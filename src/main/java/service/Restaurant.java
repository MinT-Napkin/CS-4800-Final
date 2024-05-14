package service;

import meal.Order;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Restaurant
{
    private String name;
    private String address;
    private String county;
    private LocalTime openingHour;
    private LocalTime closingHour;
    private String cuisineType;
    private FoodMenu menu;

    public Restaurant(String name,
                      String address,
                      String county,
                      LocalTime openingHour,
                      LocalTime closingHour,
                      String cuisineType,
                      FoodMenu menu)
    {
        this.name = name;
        this.address = address;
        this.county = county;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.cuisineType = cuisineType;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return county;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public FoodMenu getMenu() {
        return menu;
    }

    public Order createOrder(Customer customer, LocalDateTime orderCreationTime) throws DateTimeException {
        LocalTime orderCreationTimeOnly = orderCreationTime.toLocalTime();
        if (orderCreationTimeOnly.isBefore(openingHour) || orderCreationTimeOnly.isAfter(closingHour)) {
            throw new DateTimeException(String.format("Customer \"%s\" tried to order from restaurant \"%s\" outside of operating hours. Try again later!", customer.getName(), this.getName()));
        }

        return new Order(this, customer, orderCreationTime);
    }
}
