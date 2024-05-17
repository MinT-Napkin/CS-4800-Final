package meal;

public class FoodItemWithMayo extends FoodItemDecorator
{
    public FoodItemWithMayo(FoodItem foodItem) {
        super(foodItem, "Mayo");
        this.toppingPrice = 0.5;
    }
}
