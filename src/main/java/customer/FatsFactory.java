package customer;

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
        switch(customer.getDietPlan())
        {
            case NO_RESTRICTION:
                return new Fat().returnRandomMacronutrient();
            case PALEO:
                return new Fat()
                        .removeSourCream()
                        .returnRandomMacronutrient();
            case VEGAN:
                return new Fat()
                        .removeSourCream()
                        .removeTuna()
                        .returnRandomMacronutrient();
            case NUT_ALLERGY:
                return new Fat()
                        .removePeanuts()
                        .returnRandomMacronutrient();
        }
        return new Fat().returnRandomMacronutrient();
    }
}
