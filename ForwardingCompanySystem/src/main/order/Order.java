package main.order;

import main.packages.Package;

import java.util.Collection;

public class Order {

    // * Variables

    private int id;                         // TODO: Unique for every instance, Can`t be changed
    private Collection<Package> packages;
    private int addressId;                  // TODO: Unique for the adress Id
    private Status status;

    // * Constructors

    public Order(int id, Collection<Package> packages, int addressId, Status status) {
        this.id = id;
        this.packages = packages;
        this.addressId = addressId;
        this.status = status;
    }

    public Order(Order order) {
        this.id = order.id;
        this.packages = order.packages;
        this.addressId = order.addressId;
        this.status = order.status;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public Collection<Package> getPackages() {
        return packages;
    }

    public int getAddressId() {
        return addressId;
    }

    public Status getStatus() {
        return status;
    }

    // * Setters

    public void setPackages(Collection<Package> packages) {
        this.packages = packages;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // * Methods

    double getDeliveryPrice(){
        double totalPrice = 0;
        for (Package aPackage : packages) {
            totalPrice += aPackage.getDeliveryPrice();
        }
        return totalPrice;
    }
}