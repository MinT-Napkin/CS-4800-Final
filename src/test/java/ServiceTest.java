import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.*;
import order.*;
import customer.*;
import meal.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private CPPFoodDelivery cppFoodDelivery;
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;

    @BeforeEach
    public void setUp() {
        cppFoodDelivery = CPPFoodDelivery.getInstance();
        restaurant = new Restaurant("Test Restaurant", "123 Main St", "Test County",
                LocalTime.of(9, 0), LocalTime.of(21, 0), "Italian");
        customer = new Customer("John Doe", "456 Elm St", "Test County", DietPlan.VEGAN);
        driver = new Driver("Jane Doe", "789 Oak St", "Test County");

        cppFoodDelivery.registerRestaurant(restaurant);
        cppFoodDelivery.registerCustomer(customer);
        cppFoodDelivery.registerDriver(driver);
    }

    @Test
    public void testRegisterRestaurant() {
        cppFoodDelivery.registerRestaurant(restaurant);
        assertTrue(cppFoodDelivery.isRegisteredRestaurant(restaurant));
    }

    @Test
    public void testRegisterCustomer() {
        cppFoodDelivery.registerCustomer(customer);
        assertTrue(cppFoodDelivery.isRegisteredCustomer(customer));
    }

    @Test
    public void testRegisterDriver() {
        cppFoodDelivery.registerDriver(driver);
        assertTrue(cppFoodDelivery.isRegisteredDriver(driver));
    }

    @Test
    public void testFindDriverByCounty() {
        cppFoodDelivery.registerDriver(driver);
        Driver foundDriver = cppFoodDelivery.findDriverByCounty("Test County");
        assertNotNull(foundDriver);
    }

    @Test
    public void testCreateOrder() {
        LocalDateTime now = LocalDateTime.now();
        Order order = customer.createOrder(restaurant, now);
        assertNotNull(order);
        assertEquals(customer, order.getCustomer());
        assertEquals(restaurant, order.getRestaurant());
        assertEquals(now, order.getCreationTime());
    }

    @Test
    public void testAddValidMealToOrder() {
        LocalDateTime now = LocalDateTime.of(2024, 5, 17, 12, 0); // Within restaurant hours
        Order order = new Order();
        order.createOrder(customer, restaurant, now);

        restaurant.addValidMealToOrder(order, customer);

        assertFalse(order.getItems().isEmpty());
    }

    @Test
    public void testAddKetchupToCurrentItem() {
        Order order = new Order();

        order.createOrder(customer, restaurant, LocalDateTime.now());
        customer.addKetchupToCurrentItem(order);

        assertTrue(order.getState() instanceof CustomerOrderState);
    }

    @Test
    public void testAddMayoToCurrentItem() {
        Order order = new Order();

        order.createOrder(customer, restaurant, LocalDateTime.now());
        customer.addMayoToCurrentItem(order);

        assertTrue(order.getState() instanceof CustomerOrderState);
    }

    @Test
    public void testAddMustardToCurrentItem() {
        Order order = new Order();

        order.createOrder(customer, restaurant, LocalDateTime.now());
        customer.addMustardToCurrentItem(order);

        assertTrue(order.getState() instanceof CustomerOrderState);
    }

    @Test
    public void testAddItem() {
        Order order = new Order();

        order.createOrder(customer, restaurant, LocalDateTime.now());
        int initialItemCount = order.getItems().size();
        customer.addItem(order);

        // Assert that the number of items in the order has increased by one
        assertEquals(initialItemCount + 1, order.getItems().size());
    }

    @Test
    public void testCompleteOrder() {
        Order order = new Order();

        order.createOrder(customer, restaurant, LocalDateTime.now());
        customer.completeOrder(order);

        assertTrue(order.getState() instanceof PickupOrderState);
    }
}