package meal;

public class Driver {
    public static void main(String[] args) {
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

        LoyaltyStatus loyaltyStatus = new LoyaltyStatus(0.1); // 10% discount
        // 10 + 4 + 5 + 0.4 (ketchup) + 0.7 (mustard) + 1.1 (ketch and mustard)
        // apply discount 10% => $19.08
        totalCost = loyaltyStatus.applyDiscount(totalCost);

        System.out.println("Total cost of Order: $" + totalCost);
    }
}