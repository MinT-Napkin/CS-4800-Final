package customer;

import service.Customer;

public interface MacronutrientFactory {
    Macronutrient returnValidMacronutrient(Customer customer);
}
