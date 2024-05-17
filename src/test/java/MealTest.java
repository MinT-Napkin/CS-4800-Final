import customer.*;
import meal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Customer;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Test", "Addr", "Orange County", DietPlan.NO_RESTRICTION);
    }

    @Test
    void mealConstructorTest() {
        Meal meal = new Meal(customer);
        assertNotNull(meal.getCarb());
        assertNotNull(meal.getProtein());
        assertNotNull(meal.getFat());
        assertEquals(DietPlan.NO_RESTRICTION, meal.getDiet());
        assertTrue(meal.getPrice() >= 3 && meal.getPrice() <= 20);
    }

    @Test
    void mealConstructorWithBasePriceTest() {
        double basePrice = 10.0;
        Meal meal = new Meal(basePrice);
        assertEquals(basePrice, meal.getPrice());
    }

    @Test
    void mealToStringTest() {
        Meal meal = new Meal(customer);
        String result = meal.toString();
        assertTrue(result.contains("Meal Details:"));
        assertTrue(result.contains("Base Price:"));
        assertTrue(result.contains("Carbohydrates:"));
        assertTrue(result.contains("Protein:"));
        assertTrue(result.contains("Fat:"));
        assertTrue(result.contains("Diet Plan:"));
    }

    @Test
    void foodItemDecoratorWithKetchupTest() {
        Meal meal = new Meal(5.0);
        FoodItemWithKetchup foodItemWithKetchup = new FoodItemWithKetchup(meal);
        assertEquals(5.0 + 0.4, foodItemWithKetchup.getPrice());
    }

    @Test
    void foodItemDecoratorWithMayoTest() {
        Meal meal = new Meal(5.0);
        FoodItemWithMayo foodItemWithMayo = new FoodItemWithMayo(meal);
        assertEquals(5.0 + 0.5, foodItemWithMayo.getPrice());
    }

    @Test
    void foodItemDecoratorWithMustardTest() {
        Meal meal = new Meal(5.0);
        FoodItemWithMustard foodItemWithMustard = new FoodItemWithMustard(meal);
        assertEquals(5.0 + 0.7, foodItemWithMustard.getPrice());
    }
}