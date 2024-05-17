import customer.*;
import order.Order;
import service.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CPPFoodDeliveryDemo {
    public static void main(String[] args) {

        //
        CPPFoodDelivery cpp = CPPFoodDelivery.getInstance();

        //4 restaurants
        //TODO: create 4 separate food menus for restaurants
        Restaurant restaurant1 = new Restaurant("Phoholic", "00001 Poppy Dr", "Orange County", LocalTime.of(8,0), LocalTime.of(16,0), "Vietnamese");
        Restaurant restaurant2 = new Restaurant("Yummy Yummy", "00002 Yummy Dr", "San Bernardino County", LocalTime.of(8,0), LocalTime.of(16,0), "American");
        Restaurant restaurant3 = new Restaurant("My Thai Kitchen", "00003 Topper Dr", "LA County", LocalTime.of(16,0), LocalTime.of(0,0), "Thai");
        Restaurant restaurant4 = new Restaurant("Twin Panda Bowl", "00004 Bowl Dr", "Orange County", LocalTime.of(12,0), LocalTime.of(20,0), "Chinese");

        Driver driver1 = new Driver("Adam", "10001 Orange St", "Orange County");
        Driver driver2 = new Driver("Bob", "10002 Orange St", "Orange County");
        Driver driver3 = new Driver("Carmen", "10003 Orange St", "Orange County");
        Driver driver4 = new Driver("Don", "10004 Orange St", "Orange County");
        Driver driver5 = new Driver("Ela", "10005 Lama Blvd", "LA County");
        Driver driver6 = new Driver("Faye", "10006 Lama Blvd", "LA County");
        Driver driver7 = new Driver("Gary", "10007 Sun St", "San Bernardino County");
        Driver driver8 = new Driver("Hams", "10008 Sun St", "San Bernardino County");

        Customer customer1 = new Customer("Ab", "20001 Orange St", "Orange County", DietPlan.NO_RESTRICTION);
        Customer customer2 = new Customer("Bo", "20002 Lama Blvd", "LA County", DietPlan.NO_RESTRICTION);
        Customer customer3 = new Customer("Cy", "20003 Orange St", "Orange County", DietPlan.PALEO);
        Customer customer4 = new Customer("Di", "20004 Lama Blvd", "LA County", DietPlan.PALEO);
        Customer customer5 = new Customer("El", "20005 Sun St", "San Bernardino County", DietPlan.PALEO);
        Customer customer6 = new Customer("Fo", "20006 Orange St", "Orange County", DietPlan.VEGAN);
        Customer customer7 = new Customer("Ga", "20007 Lama Blvd", "LA County", DietPlan.VEGAN);
        Customer customer8 = new Customer("Hu", "20008 Sun St", "San Bernardino County", DietPlan.VEGAN);
        Customer customer9 = new Customer("Ip", "20009 Lama Blvd", "LA County", DietPlan.NUT_ALLERGY);
        Customer customer10 = new Customer("Jp", "20010 Sun St", "San Bernardino County", DietPlan.NUT_ALLERGY);

        cpp.registerRestaurant(restaurant1);
        cpp.registerRestaurant(restaurant2);

        cpp.registerDriver(driver1);
        cpp.registerDriver(driver2);

        cpp.registerCustomer(customer1);
        cpp.registerCustomer(customer2);

        // in range operating hours
        restaurant1.viewMenu();
        Order order = customer1.createOrder(restaurant1, LocalDateTime.of(2024, 10, 10, 9, 30));
        driver1.pickupOrder(order, LocalDateTime.of(2024, 10, 10, 10, 0));
        driver1.deliverOrder(LocalDateTime.of(2024, 10, 10, 10, 10));
        System.out.println(order);

        // out of range of operating hours
        customer1.createOrder(restaurant1, LocalDateTime.of(2024, 10, 10, 7, 30));

        // ordering out of county

        // ordering while not registered
    }
}
