package main.vehicles;

public class Car extends Vehicle {
    
    // * Parameters
    
    private int seatNumber;
    private int doorsNumber;
    private EquipmentLevel equipmentLevel;

    // * Constructors

    public Car(int id, String maker, String model, int year, String color, double price, int seatNumber, int doorsNumber, EquipmentLevel equipmentLevel) {
        super(id, maker, model, year, color, price);
        if(seatNumber < 2 || seatNumber > 5){
            throw new IllegalArgumentException("Seat number must be between 2 and 5");
        }
        if(doorsNumber < 2 || doorsNumber > 5){
            throw new IllegalArgumentException("Doors number must be between 2 and 5");
        }
        this.seatNumber = seatNumber;
        this.doorsNumber = doorsNumber;
        this.equipmentLevel = equipmentLevel;
    }

    // * Getters

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }

    public EquipmentLevel getEquipmentLevel() {
        return equipmentLevel;
    }

    // * Setters

    public void setSeatNumber(int seatNumber) {
        if(seatNumber < 2 || seatNumber > 5){
            throw new IllegalArgumentException("Seat number must be between 2 and 5");
        }
        this.seatNumber = seatNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        if(doorsNumber < 2 || doorsNumber > 5){
            throw new IllegalArgumentException("Doors number must be between 2 and 5");
        }
        this.doorsNumber = doorsNumber;
    }

    public void setEquipmentLevel(EquipmentLevel equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }
}