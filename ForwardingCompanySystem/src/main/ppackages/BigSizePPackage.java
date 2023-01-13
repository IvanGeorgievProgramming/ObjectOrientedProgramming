package main.ppackages;

public class BigSizePPackage extends PPackage {

    // * Variables

    private double size;

    // * Constructors

    public BigSizePPackage(int id, double size){
        super(id);
        this.size = size;
        if(size < 7 || size > 9){
            throw new IllegalArgumentException("Size must be between 7 and 9");
        }
    }

    public BigSizePPackage(BigSizePPackage bigSizePackage) {
        super(bigSizePackage);
        this.size = bigSizePackage.size;
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
        return size * 5;
    }
    
}