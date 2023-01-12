package main.address;

public class Address {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed
    private String country;
    private String city;
    private String street;
    private int userId;         // TODO: Unique for the user Id

    // * Constructors

    public Address(int id, String country, String city, String street, int userId) {
        this.id = id;
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
