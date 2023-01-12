package main.packages;

public abstract class Package {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed

    // * Constructors

    public Package(int id) {
        this.id = id;
    }

    public Package(Package aPackage) {
        this.id = aPackage.id;
    }

    // * Getters

    public int getId() {
        return id;
    }

    // * Methods

    double getDeliveryPrice(){
        return 0;
    }

}