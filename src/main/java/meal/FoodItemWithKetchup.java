package meal;

public class FoodItemWithKetchup extends FoodItemDecorator {
    public FoodItemWithKetchup(FoodItem foodItem) {
        super(foodItem, "Ketchup");
        this.toppingPrice = 0.4;
    }
}