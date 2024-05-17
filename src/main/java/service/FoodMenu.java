package service;

import meal.*;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu
{
    private List<Meal> mealList;

    public FoodMenu(List<Meal> mealList){
        this.mealList = mealList;
    }

    public void addMeal(Meal meal)
    {
        this.mealList.add(meal);
    }

    public Meal createCustomerMeal(){
        return null;
    }

    public void addTopping1(Meal meal){

    }

    public void addTopping2(Meal meal){

    }

    public void addTopping3(Meal meal){

    }

    public List<Meal> getMealList() {
        return mealList;
    }
}
