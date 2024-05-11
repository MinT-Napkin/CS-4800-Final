import customer.*;
import meal.*;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class CPPFoodDeliveryDemo {
    public static void main(String[] args) {

        //
        CPPFoodDelivery cpp = CPPFoodDelivery.getInstance();

        //4 restaurants
        //TODO: create 4 separate food menus for restaurants
        Restaurant restaurant1 = new Restaurant("1", "addr", "count", 1, 2, "cuisine", null);
        Restaurant restaurant2 = new Restaurant("2", "addr", "count", 1, 2, "cuisine", null);
        Restaurant restaurant3 = new Restaurant("3", "addr", "count", 1, 2, "cuisine", null);
        Restaurant restaurant4 = new Restaurant("4", "addr", "count", 1, 2, "cuisine", null);

        Driver driver1 = new Driver("1", "addr", "county");
        Driver driver2 = new Driver("2", "addr", "county");
        Driver driver3 = new Driver("3", "addr", "county");
        Driver driver4 = new Driver("4", "addr", "county");
        Driver driver5 = new Driver("5", "addr", "county");
        Driver driver6 = new Driver("6", "addr", "county");
        Driver driver7 = new Driver("7", "addr", "county");
        Driver driver8 = new Driver("8", "addr", "county");

        Customer customer1 = new Customer("1", "addr", "count", DietPlan.NO_RESTRICTION);
        Customer customer2 = new Customer("2", "addr", "count", DietPlan.NO_RESTRICTION);
        Customer customer3 = new Customer("3", "addr", "count", DietPlan.PALEO);
        Customer customer4 = new Customer("4", "addr", "count", DietPlan.PALEO);
        Customer customer5 = new Customer("5", "addr", "count", DietPlan.PALEO);
        Customer customer6 = new Customer("6", "addr", "count", DietPlan.VEGAN);
        Customer customer7 = new Customer("7", "addr", "count", DietPlan.VEGAN);
        Customer customer8 = new Customer("8", "addr", "count", DietPlan.VEGAN);
        Customer customer9 = new Customer("9", "addr", "count", DietPlan.NUT_ALLERGY);
        Customer customer10 = new Customer("10", "addr", "count", DietPlan.NUT_ALLERGY);

        cpp.registerRestaurant(restaurant1);
        cpp.registerRestaurant(restaurant2);

        cpp.registerDriver(driver1);
        cpp.registerDriver(driver2);
        
        cpp.registerCustomer(customer1);
        cpp.registerCustomer(customer2);

        cpp.printRegistered();

//        // taken straight from hw 4
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer("Customer1", DietPlan.NO_RESTRICTION));
//        customers.add(new Customer("Customer2", DietPlan.PALEO));
//        customers.add(new Customer("Customer3", DietPlan.VEGAN));
//        customers.add(new Customer("Customer4", DietPlan.NUT_ALLERGY));
//        customers.add(new Customer("Customer5", DietPlan.VEGAN));
//        customers.add(new Customer("Customer6", DietPlan.PALEO));
//
//        for (Customer customer : customers) {
//            Meal meal = new Meal(customer);
//
//            System.out.println("Meal for " + customer.getName() + " (Diet Plan: " + customer.getDietPlan() + "):");
//            System.out.println("Carbs: " + meal.getCarb().getName());
//            System.out.println("Protein: " + meal.getProtein().getName());
//            System.out.println("Fats: " + meal.getFat().getName());
//            System.out.println();
//        }
//
//        // taken straight from hw 5
//        FoodItem burger = new Meal(10.0);
//        FoodItem fries = new Meal(4.0);
//        FoodItem hotdog = new Meal(5.0);
//
//        burger = new FoodItemWithMustard(burger);
//        fries = new FoodItemWithKetchup(fries);
//        hotdog = new FoodItemWithKetchupAndMustard(hotdog);
//
//        Order order = new Order();
//        order.addItem(burger);
//        order.addItem(fries);
//        order.addItem(hotdog);
//
//        double totalCost = order.getTotalCost();
//
//        System.out.println("Total cost of Order: $" + totalCost);
    }
}
