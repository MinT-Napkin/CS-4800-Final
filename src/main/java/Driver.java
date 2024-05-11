import customer.*;
import meal.*;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
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
    }
}
