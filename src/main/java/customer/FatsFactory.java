package customer;

import service.Customer;

public class FatsFactory implements MacronutrientFactory {

    private static FatsFactory instance;

    private FatsFactory() {
    }

    public static FatsFactory getInstance() {
        if (instance == null) {
            instance = new FatsFactory();
        }
        return instance;
    }

    @Override
    public Macronutrient returnValidMacronutrient(Customer customer) {
        return switch (customer.getDietPlan()) {
            case NO_RESTRICTION -> new Fat().returnRandomMacronutrient();
            case PALEO -> new Fat()
                    .removeSourCream()
                    .returnRandomMacronutrient();
            case VEGAN -> new Fat()
                    .removeSourCream()
                    .removeTuna()
                    .returnRandomMacronutrient();
            case NUT_ALLERGY -> new Fat()
                    .removePeanuts()
                    .returnRandomMacronutrient();
        };
    }
}
