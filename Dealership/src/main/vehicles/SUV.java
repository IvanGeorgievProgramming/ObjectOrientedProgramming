package main.vehicles;

public class SUV extends Car {
    
    // * Parameters

    private boolean has4by4;
    private double clearance;

    // * Constructors

    public SUV(String maker, String model, int year, String color, double price, int seatNumber, int doorsNumber, EquipmentLevel equipmentLevel, boolean has4by4, double clearance) {
        super(maker, model, year, color, price, seatNumber, doorsNumber, equipmentLevel);
        this.has4by4 = has4by4;
        this.clearance = clearance;
    }

    // * Getters

    public boolean isHas4by4() {
        return has4by4;
    }

    public double getClearance() {
        return clearance;
    }

    // * Setters

    public void setHas4by4(boolean has4by4) {
        this.has4by4 = has4by4;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    // * Methods

    public void printInfo(){
        System.out.println("Id: "+ this.getId() + " - " + this.getMaker() + ", " + this.getModel() + ", " + this.getYear() + ", " + this.getColor() + ", " + this.getPrice() + ", " + this.getSeatNumber() + ", " + this.getDoorsNumber() + ", " + this.getEquipmentLevel() + ", " + this.isHas4by4() + ", " + this.getClearance());
    }
}