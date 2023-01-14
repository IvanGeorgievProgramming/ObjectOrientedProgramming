package main.ppackages;

public class SalablePPackage extends PPackage {

    // * Variables

    private double price;
    private PPackage sizPackage;

    // * Constructors

    public SalablePPackage(double price, PPackage sizPackage){
        super();
        this.price = price;
        this.sizPackage = sizPackage;
        if(price < 0){
            throw new IllegalArgumentException("Price must be more than 0");
        }
    }

    public SalablePPackage(SalablePPackage salablePackage) {
        super(salablePackage);
        this.price = salablePackage.price;
        this.sizPackage = salablePackage.sizPackage;
    }

    // * Getters

    public double getPrice() {
        return price;
    }

    public PPackage getSizPackage() {
        return sizPackage;
    }

    // * Setters

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSizPackage(PPackage sizPackage) {
        this.sizPackage = sizPackage;
    }

    // * Methods

    @Override
    public double getDeliveryPrice() {
        return sizPackage.getDeliveryPrice() + (price * 0.1);
    }
    
}