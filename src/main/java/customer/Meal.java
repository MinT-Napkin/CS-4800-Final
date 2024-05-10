package customer;

public class Meal
{
    private Macronutrient carb;
    private Macronutrient protein;
    private Macronutrient fat;

    public Meal(Customer customer)
    {
        MacronutrientFactory carbsFactory = CarbsFactory.getInstance();
        MacronutrientFactory proteinsFactory = ProteinFactory.getInstance();
        MacronutrientFactory fatsFactory = FatsFactory.getInstance();

        carb = carbsFactory.returnValidMacronutrient(customer);
        protein = proteinsFactory.returnValidMacronutrient(customer);
        fat = fatsFactory.returnValidMacronutrient(customer);
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
}
