package service;

public class Restaurant
{
    private String name;
    private String address;
    private String county;
    private int openingHour;
    private int closingHour;
    private String cuisineType;
    private FoodMenu menu;

    public Restaurant(String name,
                      String address,
                      String county,
                      int openingHour,
                      int closingHour,
                      String cuisineType,
                      FoodMenu menu)
    {
        this.name = name;
        this.address = address;
        this.county = county;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.cuisineType = cuisineType;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return county;
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
