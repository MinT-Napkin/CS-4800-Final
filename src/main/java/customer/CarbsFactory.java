package customer;

public class CarbsFactory implements MacronutrientFactory {
    private static CarbsFactory instance;

    private CarbsFactory() {
    }

    public static CarbsFactory getInstance() {
        if (instance == null) {
            instance = new CarbsFactory();
        }
        return instance;
    }

    public Macronutrient returnValidMacronutrient(Customer customer) {
        switch(customer.getDietPlan())
        {
            case NO_RESTRICTION:
                return new Carb().returnRandomMacronutrient();
            case PALEO:
                return new Carb()
                        .removeCheese()
                        .removeBread()
                        .removeLentils()
                        .returnRandomMacronutrient();
            case VEGAN:
                return new Carb()
                        .removeCheese()
                        .returnRandomMacronutrient();
            case NUT_ALLERGY:
                return new Carb()
                        .removePistachio()
                        .returnRandomMacronutrient();
        }
        return new Carb().returnRandomMacronutrient();
    }
}
