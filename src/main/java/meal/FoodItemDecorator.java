package meal;

abstract class FoodItemDecorator implements FoodItem {
    private FoodItem decoratedFoodItem;

    public FoodItemDecorator(FoodItem foodItem) {
        this.decoratedFoodItem = foodItem;
    }

    @Override
    public double getPrice() {
        return decoratedFoodItem.getPrice();
    }
}