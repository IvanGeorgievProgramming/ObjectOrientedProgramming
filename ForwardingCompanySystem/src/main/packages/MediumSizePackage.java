package main.packages;

public class MediumSizePackage extends Package {

    // * Variables

    private double size;

    // * Constructors

    public MediumSizePackage(int id, double size){
        super(id);
        this.size = size;
        if(size < 4 || size > 6){
            throw new IllegalArgumentException("Size must be between 4 and 6");
        }
    }

    public MediumSizePackage(MediumSizePackage mediumSizePackage) {
        super(mediumSizePackage);
        this.size = mediumSizePackage.size;
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
        return size * 4;
    }
    
}
