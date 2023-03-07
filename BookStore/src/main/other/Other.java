package main.other;

public class Other {
    
    // * Parameters

    private String barcode;
    private String name;
    private double weight;
    private double price;

    // * Constructors

    public Other(String barcode, String name, double weight, double price) {
        if(barcode.length() != 13)
            throw new IllegalArgumentException("Barcode must be 13 digits long");
        if(price <= 0)
            throw new IllegalArgumentException("Price must be greater than 0");
        this.barcode = barcode;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    // * Getters

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    // * Setters

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // * Methods

    public void print() {
        System.out.println("Other:");
        System.out.println("Barcode: " + barcode);
        System.out.println("Name: " + name);
        System.out.println("Weight: " + weight);
        System.out.println("Price: " + price);
        System.out.println();
    }

    // * Builder

    public static class OtherBuilder {
        private String barcode;
        private String name;
        private double weight;
        private double price;

        public OtherBuilder(String barcode, double price) {
            this.barcode = barcode;
            this.price = price;
        }

        public OtherBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public OtherBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Other build() {
            return new Other(barcode, name, weight, price);
        }
    }
}

/*
Other
Sting barcode - contains 13 numbers, mandatory field, can start with 0. Unique identifier. Cannot be changed.
String name - item name, optional
double weight - weight of the item in kilograms, optional.
double price - price of the item, mandatory, greater than 0.
 */