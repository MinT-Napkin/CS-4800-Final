package customer;

import service.Customer;

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
        return switch (customer.getDietPlan()) {
            case NO_RESTRICTION -> new Carb().returnRandomMacronutrient();
            case PALEO -> new Carb()
                    .removeCheese()
                    .removeBread()
                    .removeLentils()
                    .returnRandomMacronutrient();
            case VEGAN -> new Carb()
                    .removeCheese()
                    .returnRandomMacronutrient();
            case NUT_ALLERGY -> new Carb()
                    .removePistachio()
                    .returnRandomMacronutrient();
        };
    }
}
