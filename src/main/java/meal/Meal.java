package meal;

import customer.*;
import service.Customer;

import java.util.Random;

public class Meal implements FoodItem {

    private double basePrice;
    private Macronutrient carb;
    private Macronutrient protein;
    private Macronutrient fat;

    private DietPlan diet;

    public Meal(Customer customer)
    {
        MacronutrientFactory carbsFactory = CarbsFactory.getInstance();
        MacronutrientFactory proteinsFactory = ProteinFactory.getInstance();
        MacronutrientFactory fatsFactory = FatsFactory.getInstance();

        carb = carbsFactory.returnValidMacronutrient(customer);
        protein = proteinsFactory.returnValidMacronutrient(customer);
        fat = fatsFactory.returnValidMacronutrient(customer);

        this.diet = customer.getDietPlan();
        this.basePrice = generateRandomPrice();
    }

    private double generateRandomPrice() {
        Random random = new Random();
        int minPrice = 3;
        int maxPrice = 20;
        return minPrice + random.nextInt(maxPrice - minPrice + 1);
    }

    public Meal(double basePrice) {
        this.basePrice = basePrice;
    }

    public Macronutrient getCarb() {
        return carb;
    }

    public Macronutrient getProtein() {
        return protein;
    }

    public Macronutrient getFat() {
        return fat;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    public DietPlan getDiet() {
        return diet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal Details:\n");
        sb.append(String.format("\tBase Price: $%.2f\n", basePrice));
        sb.append("\tCarbohydrates: ").append(carb.getName()).append("\n");
        sb.append("\tProtein: ").append(protein.getName()).append("\n");
        sb.append("\tFat: ").append(fat.getName()).append("\n");
        sb.append("\tDiet Plan: ").append(diet).append("\n");
        return sb.toString();
    }
}