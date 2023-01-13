package main.packages;

public abstract class Package {

    // * Variables

    private final int id;

    private static int idCounter = 0;

    // * Constructors

    public Package(int id) {
        this.id = idCounter++;
    }

    public Package(Package aPackage) {
        this.id = aPackage.id;
    }

    // * Getters

    public int getId() {
        return id;
    }

    // * Methods

    public double getDeliveryPrice(){
        return 0;
    }

}