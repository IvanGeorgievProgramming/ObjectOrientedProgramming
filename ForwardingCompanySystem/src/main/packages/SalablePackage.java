package main.packages;

public class SalablePackage extends Package {

    // * Variables

    private double price;      // TODO: Must be more than 0
    private Package sizPackage;

    // * Constructors

    public SalablePackage(int id, double price, Package sizPackage){
        super(id);
        this.price = price;
        this.sizPackage = sizPackage;
    }

    public SalablePackage(SalablePackage salablePackage) {
        super(salablePackage);
        this.price = salablePackage.price;
        this.sizPackage = salablePackage.sizPackage;
    }

    // * Getters

    public double getPrice() {
        return price;
    }

    public Package getSizPackage() {
        return sizPackage;
    }

    // * Setters

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSizPackage(Package sizPackage) {
        this.sizPackage = sizPackage;
    }

    // * Methods

    @Override
    public double getDeliveryPrice() {
        return sizPackage.getDeliveryPrice() + (price * 0.1);
    }
    
}