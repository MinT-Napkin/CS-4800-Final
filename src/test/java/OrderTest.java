import customer.*;
import meal.*;
import order.*;
import service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Driver;
import service.Restaurant;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Customer customer;
    private Restaurant restaurant;
    private Driver driver;
    private FoodItem foodItem;

    @BeforeEach
    public void setUp() {
        CPPFoodDelivery cpp = CPPFoodDelivery.getInstance();

        customer = new Customer("Test", "Addr", "County1", DietPlan.NO_RESTRICTION);
        restaurant = new Restaurant("Best Restaurant", "Addr", "County1", LocalTime.of(8,0), LocalTime.of(16,0), "American");
        driver = new Driver("Test2", "Addr", "County1");
        foodItem = new Meal(10.0);

        cpp.registerCustomer(customer);
        cpp.registerRestaurant(restaurant);
        cpp.registerDriver(driver);
    }

    @Test
    public void testIdleOrderState() {
        Order order = new Order();
        assertTrue(order.getState() instanceof IdleOrderState);
    }

    @Test
    public void testCustomerOrderState() {
        Order order1 = customer.createOrder(restaurant, LocalDateTime.of(2024, 10, 10, 9, 30));
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.addKetchupToCurrentItem(order1);
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.addItem(order1);
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.addMayoToCurrentItem(order1);
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.addItem(order1);
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.addMustardToCurrentItem(order1);
        assertTrue(order1.getState() instanceof CustomerOrderState);
        customer.completeOrder(order1);
        assertFalse(order1.getState() instanceof CustomerOrderState);
    }

    @Test
    public void testPickOrderState() {
        Order order1 = customer.createOrder(restaurant, LocalDateTime.of(2024, 10, 10, 9, 30));
        customer.addKetchupToCurrentItem(order1);
        customer.addItem(order1);
        customer.addMayoToCurrentItem(order1);
        customer.addItem(order1);
        customer.addMustardToCurrentItem(order1);
        assertFalse(order1.getState() instanceof PickupOrderState);
        customer.completeOrder(order1);
        assertTrue(order1.getState() instanceof PickupOrderState);
        driver.pickupOrder(order1, LocalDateTime.of(2024, 10, 10, 10, 0));
        assertFalse(order1.getState() instanceof PickupOrderState);
    }

    @Test
    public void testDriverDeliverState() {
        Order order1 = customer.createOrder(restaurant, LocalDateTime.of(2024, 10, 10, 9, 30));
        customer.addKetchupToCurrentItem(order1);
        customer.addItem(order1);
        customer.addMayoToCurrentItem(order1);
        customer.addItem(order1);
        customer.addMustardToCurrentItem(order1);
        customer.completeOrder(order1);
        assertFalse(order1.getState() instanceof DriverDeliverState);
        driver.pickupOrder(order1, LocalDateTime.of(2024, 10, 10, 10, 0));
        assertTrue(order1.getState() instanceof DriverDeliverState);
        driver.deliverOrder(LocalDateTime.of(2024, 10, 10, 10, 10));
        assertFalse(order1.getState() instanceof DriverDeliverState);
    }
}
