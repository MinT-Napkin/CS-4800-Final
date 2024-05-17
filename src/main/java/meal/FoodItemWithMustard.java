package meal;

public class FoodItemWithMustard extends FoodItemDecorator {
    public FoodItemWithMustard(FoodItem foodItem) {
        super(foodItem);
        this.toppingPrice = 0.7;
    }
}