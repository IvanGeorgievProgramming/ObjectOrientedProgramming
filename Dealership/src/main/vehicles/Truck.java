package main.vehicles;

public class Truck extends Vehicle {

    // * Parameters        

    private int maxLoadWeight;
    private double maxLoadVolume;
    
    // * Constructors

    public Truck(int id, String maker, String model, int year, String color, double price, int maxLoadWeight, double maxLoadVolume) {
        super(id, maker, model, year, color, price);
        this.maxLoadWeight = maxLoadWeight;
        this.maxLoadVolume = maxLoadVolume;
    }

    // * Getters
    

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public double getMaxLoadVolume() {
        return maxLoadVolume;
    }

    // * Setters
    

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public void setMaxLoadVolume(double maxLoadVolume) {
        this.maxLoadVolume = maxLoadVolume;
    }
}