package meal;

public class FoodItemWithKetchup extends FoodItemDecorator {

    public FoodItemWithKetchup(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + Toppings.ketchupPrice;
    }
}