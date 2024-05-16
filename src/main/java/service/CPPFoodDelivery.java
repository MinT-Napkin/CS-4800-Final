package service;

import java.util.ArrayList;
import java.util.List;

public class CPPFoodDelivery
{
    //singleton
    private static CPPFoodDelivery instance;

    public static CPPFoodDelivery getInstance() {
        if (instance == null) {
            instance = new CPPFoodDelivery();
        }
        return instance;
    }

    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<Driver> drivers;

    private CPPFoodDelivery() {
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        drivers = new ArrayList<>();
    }

    public void registerRestaurant(Restaurant restaurant)
    {
        restaurants.add(restaurant);
    }

    public void registerCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public void registerDriver(Driver driver)
    {
        drivers.add(driver);
    }

    public Driver findDriverByCounty(String county)
    {
        Driver toReturn = null;

        for(Driver driver: this.drivers)
        {
            if(driver.getOperatingCounty().equals(county))
            {
                toReturn = driver;
                break;
            }
        }

        return toReturn;
    }

    public void printRegistered() {
        System.out.println("Restaurants: ");
        restaurants.forEach(restaurant -> System.out.print(restaurant.getName() + ", "));
        System.out.println();

        System.out.println("Customers: ");
        customers.forEach(customer -> System.out.print(customer.getName() + ", "));
        System.out.println();

        System.out.println("Drivers: ");
        drivers.forEach(driver -> System.out.print(driver.getName() + ", "));
        System.out.println();
    }
}
