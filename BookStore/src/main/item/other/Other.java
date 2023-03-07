package main.item.other;

public class Other extends main.item.Item {
    
    // * Parameters

    private String barcode;
    private String name;
    private double weight;

    // * Constructors

    public Other(String barcode, String name, double weight, double price) {
        super(price);
        if(barcode.length() != 13)
            throw new IllegalArgumentException("Barcode must be 13 digits long");
        this.barcode = barcode;
        this.name = name;
        this.weight = weight;
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

    // * Methods

    @Override
    public void print() {
        System.out.println("    Other:");
        System.out.println("    Barcode: " + barcode);
        System.out.println("    Name: " + name);
        System.out.println("    Weight: " + weight);
        System.out.println("    Price: " + this.getPrice());
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