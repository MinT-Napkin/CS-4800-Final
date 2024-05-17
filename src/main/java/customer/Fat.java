package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fat extends Macronutrient {

    private String name;
    private List<String> fatOptions;

    public Fat()
    {
        fatOptions = new ArrayList<String>();
        fatOptions.add("Avocado");
        fatOptions.add("Sour cream");
        fatOptions.add("Tuna");
        fatOptions.add("Peanuts");
    }

    public Fat removeAvocado() {
        fatOptions.remove("Avocado");
        return this;
    }

    public Fat removeSourCream() {
        fatOptions.remove("Sour cream");
        return this;
    }

    public Fat removeTuna() {
        fatOptions.remove("Tuna");
        return this;
    }

    public Fat removePeanuts() {
        fatOptions.remove("Peanuts");
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Macronutrient returnRandomMacronutrient() {
        Random random = new Random();
        int index = random.nextInt(fatOptions.size());
        name = fatOptions.get(index);
        return this;
    }
}
