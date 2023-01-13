package main.packages;

public class SmallSizePackage extends Package {

    // * Variables

    private double size;

    // * Constructors

    public SmallSizePackage(int id, double size){
        super(id);
        this.size = size;
        if(size < 1 || size > 3){
            throw new IllegalArgumentException("Size must be between 1 and 3");
        }
    }

    public SmallSizePackage(SmallSizePackage smallSizePackage) {
        super(smallSizePackage);
        this.size = smallSizePackage.size;
    }

    // * Getters

    public double getSize() {
        return size;
    }

    // * Setters

    public void setSize(double size) {
        this.size = size;
    }

    // * Methods

    @Override
    public double getDeliveryPrice() {
        return size * 3;
    }
    
}
