package main.order;

import java.util.Collection;

import main.ppackages.PPackage;

public class Order {

    // * Variables

    private final int id;
    private Collection<PPackage> PPackages;
    private int addressId;
    private Status status;

    private static int idCounter = 0;

    // * Constructors

    public Order(int addressId) {
        this.id = idCounter++;
        this.PPackages = null;
        this.addressId = addressId;
        this.status = null;
    }

    public Order(Collection<PPackage> PPackages, int addressId, Status status) {
        this.id = idCounter++;
        this.PPackages = PPackages;
        this.addressId = addressId;
        this.status = status;
    }

    public Order(Order order) {
        this.id = order.id;
        this.PPackages = order.PPackages;
        this.addressId = order.addressId;
        this.status = order.status;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public Collection<PPackage> getPPackages() {
        return PPackages;
    }

    public int getAddressId() {
        return addressId;
    }

    public Status getStatus() {
        return status;
    }

    // * Setters

    public void setPPackages(Collection<PPackage> PPackages) {
        this.PPackages = PPackages;
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
        for (PPackage aPackage : PPackages) {
            totalPrice += aPackage.getDeliveryPrice();
        }
        return totalPrice;
    }

    public void addPackage(PPackage aPackage){
        PPackages.add(aPackage);
    }
}
