package meal;

public class FoodItemWithMustard extends FoodItemDecorator {

    public FoodItemWithMustard(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + Toppings.mustardPrice;
    }
}