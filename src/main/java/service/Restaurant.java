package service;

public class Restaurant
{
    private String name;
    private String address;
    private String country;
    private int openingHour;
    private int closingHour;
    private String cuisineType;
    private FoodMenu menu;

    public Restaurant(String name,
                      String address,
                      int openingHour,
                      int closingHour,
                      String cuisineType,
                      FoodMenu menu)
    {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public FoodMenu getMenu() {
        return menu;
    }
}
