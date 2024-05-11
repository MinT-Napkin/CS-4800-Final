package service;

public class Driver
{
    private String name;
    private String address;
    private String operatingCounty;

    public Driver(String name,
                  String address,
                  String operatingCounty)
    {
        this.name = name;
        this.address = address;
        this.operatingCounty = operatingCounty;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOperatingCounty() {
        return operatingCounty;
    }
}
