import org.junit.jupiter.api.Test;
import service.Customer;

import java.util.List;
import customer.*;
import service.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void fatsFactoryInstanceTest() {
        FatsFactory instance1 = FatsFactory.getInstance();
        FatsFactory instance2 = FatsFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void proteinFactoryInstanceTest() {
        ProteinFactory instance1 = ProteinFactory.getInstance();
        ProteinFactory instance2 = ProteinFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void carbsFactoryInstanceTest() {
        CarbsFactory instance1 = CarbsFactory.getInstance();
        CarbsFactory instance2 = CarbsFactory.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void fatsFactoryReturnValidMacronutrientTest() {
        Customer customer = new Customer("Test", "Addr", "Orange County", DietPlan.NO_RESTRICTION);
        FatsFactory fatsFactory = FatsFactory.getInstance();
        Macronutrient fat = fatsFactory.returnValidMacronutrient(customer);
        assertNotNull(fat);
        assertTrue(fat instanceof Fat);
    }

    @Test
    void proteinFactoryReturnValidMacronutrientTest() {
        Customer customer = new Customer("Test", "Addr", "Orange County", DietPlan.NO_RESTRICTION);
        ProteinFactory proteinFactory = ProteinFactory.getInstance();
        Macronutrient protein = proteinFactory.returnValidMacronutrient(customer);
        assertNotNull(protein);
        assertTrue(protein instanceof Protein);
    }

    @Test
    void carbsFactoryReturnValidMacronutrientTest() {
        Customer customer = new Customer("Test", "Addr", "Orange County", DietPlan.NO_RESTRICTION);
        CarbsFactory carbsFactory = CarbsFactory.getInstance();
        Macronutrient carb = carbsFactory.returnValidMacronutrient(customer);
        assertNotNull(carb);
        assertTrue(carb instanceof Carb);
    }

    @Test
    void fatReturnRandomMacronutrientTest() {
        Fat fat = new Fat();
        Macronutrient randomFat = fat.returnRandomMacronutrient();
        assertNotNull(randomFat);
        assertTrue(fatOptionsContains(fat.getName()));
    }

    @Test
    void proteinReturnRandomMacronutrientTest() {
        Protein protein = new Protein();
        Macronutrient randomProtein = protein.returnRandomMacronutrient();
        assertNotNull(randomProtein);
        assertTrue(proteinOptionsContains(protein.getName()));
    }

    @Test
    void carbReturnRandomMacronutrientTest() {
        Carb carb = new Carb();
        Macronutrient randomCarb = carb.returnRandomMacronutrient();
        assertNotNull(randomCarb);
        assertTrue(carbOptionsContains(carb.getName()));
    }

    private boolean fatOptionsContains(String name) {
        List<String> options = List.of("Avocado", "Sour cream", "Tuna", "Peanuts");
        return options.contains(name);
    }

    private boolean proteinOptionsContains(String name) {
        List<String> options = List.of("Fish", "Chicken", "Beef", "Tofu");
        return options.contains(name);
    }

    private boolean carbOptionsContains(String name) {
        List<String> options = List.of("Cheese", "Bread", "Lentils", "Pistachio");
        return options.contains(name);
    }
}
