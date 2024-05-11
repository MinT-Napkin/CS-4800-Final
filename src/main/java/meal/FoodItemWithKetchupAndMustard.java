package meal;

public class FoodItemWithKetchupAndMustard extends FoodItemDecorator
{
    public FoodItemWithKetchupAndMustard(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + Toppings.ketchupPrice + Toppings.mustardPrice;
    }
}
