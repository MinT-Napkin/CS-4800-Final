package meal;

public class FoodItemWithMustard extends FoodItemDecorator {
    public FoodItemWithMustard(FoodItem foodItem) {
        super(foodItem, "Mustard");
        this.toppingPrice = 0.7;
    }
}