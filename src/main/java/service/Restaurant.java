package service;

import customer.DietPlan;
import meal.Meal;
import meal.Order;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

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

        if (menu == null)
        {
            menu = new FoodMenu( new ArrayList<Meal>());
            menu.addMeal(new Meal(new Customer(null, null, null, DietPlan.NO_RESTRICTION)));
            menu.addMeal(new Meal(new Customer(null, null, null, DietPlan.PALEO)));
            menu.addMeal(new Meal(new Customer(null, null, null, DietPlan.VEGAN)));
            menu.addMeal(new Meal(new Customer(null, null, null, DietPlan.NUT_ALLERGY)));

        }else{
            this.menu = menu;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCounty() {
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

        Order toReturn = new Order(this, customer, orderCreationTime);

        toReturn.pickUpOrder(orderCreationTime.plusHours(1));

        for (Meal meal : this.menu.getMealList())
        {
            if (meal.getDiet().equals(customer.getDietPlan()))
            {
                toReturn.addItem(meal);
                break;
            }
        }

        return toReturn;
    }
}
