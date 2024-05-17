package meal;

abstract class FoodItemDecorator implements FoodItem {
    private FoodItem decoratedFoodItem;
    private String toppingName;
    protected double toppingPrice;

    public FoodItemDecorator(FoodItem foodItem, String toppingName) {
        this.decoratedFoodItem = foodItem;
        this.toppingName = toppingName;
    }

    @Override
    public double getPrice() {
        return decoratedFoodItem.getPrice() + toppingPrice;
    }

    public String toString() {
        return decoratedFoodItem.toString() + String.format("\tTopping Price: %s ($%.2f)\n", toppingName, toppingPrice);
    }
}