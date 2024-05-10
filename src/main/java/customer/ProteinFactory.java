package customer;

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
        switch(customer.getDietPlan())
        {
            case NO_RESTRICTION, NUT_ALLERGY:
                return new Protein().returnRandomMacronutrient();
            case PALEO:
                return new Protein()
                        .removeTofu()
                        .returnRandomMacronutrient();
            case VEGAN:
                return new Protein()
                        .removeFish()
                        .removeChicken()
                        .returnRandomMacronutrient();
        }
        return new Protein().returnRandomMacronutrient();
    }
}

