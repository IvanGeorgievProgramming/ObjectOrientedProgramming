package main.address;

public class Address {

    // * Variables

    private final int id;
    private String country;
    private String city;
    private String street;
    private int userId;

    private static int idCounter = 0;

    // * Constructors

    public Address(String country, String city, String street, int userId) {
        this.id = idCounter++;
        this.country = country;
        this.city = city;
        this.street = street;
        this.userId = userId;
    }

    public Address(Address address) {
        this.id = address.id;
        this.country = address.country;
        this.city = address.city;
        this.street = address.street;
        this.userId = address.userId;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getUserId() {
        return userId;
    }

    // * Setters

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
