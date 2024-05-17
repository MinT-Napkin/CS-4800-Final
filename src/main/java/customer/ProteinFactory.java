package customer;

import service.Customer;

public class ProteinFactory implements MacronutrientFactory {
    private static ProteinFactory instance;

    private ProteinFactory() {}

    public static ProteinFactory getInstance() {
        if (instance == null) {
            instance = new ProteinFactory();
        }
        return instance;
    }

    @Override
    public Macronutrient returnValidMacronutrient(Customer customer) {
        return switch (customer.getDietPlan()) {
            case NO_RESTRICTION, NUT_ALLERGY -> new Protein().returnRandomMacronutrient();
            case PALEO -> new Protein()
                    .removeTofu()
                    .returnRandomMacronutrient();
            case VEGAN -> new Protein()
                    .removeFish()
                    .removeChicken()
                    .returnRandomMacronutrient();
        };
    }
}

