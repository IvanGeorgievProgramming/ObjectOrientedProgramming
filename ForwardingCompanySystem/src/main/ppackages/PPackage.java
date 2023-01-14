package main.ppackages;

public abstract class PPackage {

    // * Variables

    private final int id;

    private static int idCounter = 0;

    // * Constructors

    public PPackage() {
        this.id = idCounter++;
    }

    public PPackage(PPackage aPackage) {
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