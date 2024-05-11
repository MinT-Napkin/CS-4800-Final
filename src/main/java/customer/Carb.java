package customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carb extends Macronutrient {

    private String name;
    private List<String> carbOptions;

    public Carb()
    {
        carbOptions = new ArrayList<String>();
        carbOptions.add("Cheese");
        carbOptions.add("Bread");
        carbOptions.add("Lentils");
        carbOptions.add("Pistachio");
    }

    public Carb removeCheese() {
        carbOptions.remove("Cheese");
        return this;
    }

    public Carb removeBread() {
        carbOptions.remove("Bread");
        return this;
    }

    public Carb removeLentils() {
        carbOptions.remove("Lentils");
        return this;
    }

    public Carb removePistachio() {
        carbOptions.remove("Pistachio");
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Macronutrient returnRandomMacronutrient() {
        Random random = new Random();
        int index = random.nextInt(carbOptions.size());
        name = carbOptions.get(index);
        return this;
    }
}