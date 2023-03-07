package main.item;

public abstract class Item {

    // * Parameters

    private double price;

    // * Constructors

    public Item(double price) {
        if(price <= 0)
            throw new IllegalArgumentException("Price must be greater than 0");
        this.price = price;
    }

    // * Getters

    public double getPrice() {
        return price;
    }

    // * Setters

    public void setPrice(double price) {
        this.price = price;
    }
}
