import customer.*;
import meal.*;
import service.Customer;

import java.util.ArrayList;
import java.util.List;

public class CPPFoodDeliveryDemo {
    public static void main(String[] args) {
        // taken straight from hw 4
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Customer1", DietPlan.NO_RESTRICTION));
        customers.add(new Customer("Customer2", DietPlan.PALEO));
        customers.add(new Customer("Customer3", DietPlan.VEGAN));
        customers.add(new Customer("Customer4", DietPlan.NUT_ALLERGY));
        customers.add(new Customer("Customer5", DietPlan.VEGAN));
        customers.add(new Customer("Customer6", DietPlan.PALEO));

        for (Customer customer : customers) {
            Meal meal = new Meal(customer);

            System.out.println("Meal for " + customer.getName() + " (Diet Plan: " + customer.getDietPlan() + "):");
            System.out.println("Carbs: " + meal.getCarb().getName());
            System.out.println("Protein: " + meal.getProtein().getName());
            System.out.println("Fats: " + meal.getFat().getName());
            System.out.println();
        }

        // taken straight from hw 5
        FoodItem burger = new Meal(10.0);
        FoodItem fries = new Meal(4.0);
        FoodItem hotdog = new Meal(5.0);

        burger = new FoodItemWithMustard(burger);
        fries = new FoodItemWithKetchup(fries);
        hotdog = new FoodItemWithKetchupAndMustard(hotdog);

        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotdog);

        double totalCost = order.getTotalCost();

        System.out.println("Total cost of Order: $" + totalCost);
    }
}
