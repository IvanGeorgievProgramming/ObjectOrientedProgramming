package main.packages;

public abstract class Package {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed

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