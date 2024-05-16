package meal;

import customer.*;
import service.Customer;

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
}