package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Protein extends Macronutrient {

    private String name;
    private List<String> proteinOptions;

    public Protein()
    {
        proteinOptions = new ArrayList<String>();
        proteinOptions.add("Fish");
        proteinOptions.add("Chicken");
        proteinOptions.add("Beef");
        proteinOptions.add("Tofu");
    }

    public Protein removeFish() {
        proteinOptions.remove("Fish");
        return this;
    }

    public Protein removeChicken() {
        proteinOptions.remove("Chicken");
        return this;
    }

    public Protein removeBeef() {
        proteinOptions.remove("Beef");
        return this;
    }

    public Protein removeTofu() {
        proteinOptions.remove("Tofu");
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Macronutrient returnRandomMacronutrient() {
        Random random = new Random();
        int index = random.nextInt(proteinOptions.size());
        name = proteinOptions.get(index);
        return this;
    }
}