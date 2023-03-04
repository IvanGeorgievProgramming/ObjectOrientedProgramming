package main.vehicles;

public abstract class Vehicle {

    // * Parameters

    private int id;
    private String maker;
    private String model;
    private int year;
    private String color;
    private double price;

    // * Constructors

    public Vehicle(int id, String maker, String model, int year, String color, double price) {
        if(year < 1885 || year > 2023){
            throw new IllegalArgumentException("Year must be between 1885 and 2023");
        }
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    // * Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if(year < 1885 || year > 2023){
            throw new IllegalArgumentException("Year must be between 1885 and 2023");
        }
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}