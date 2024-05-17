package meal;

abstract class FoodItemDecorator implements FoodItem {
    private FoodItem decoratedFoodItem;
    protected double toppingPrice;

    public FoodItemDecorator(FoodItem foodItem) {
        this.decoratedFoodItem = foodItem;
    }

    @Override
    public double getPrice() {
        return decoratedFoodItem.getPrice() + toppingPrice;
    }
}