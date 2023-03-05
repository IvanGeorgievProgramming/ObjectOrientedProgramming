package main;

import main.vehicles.*;
import main.vehicledealer.*;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            //Create a new vehicle dealer
            VehicleDealar vehicleDealar = new VehicleDealar();

            //Create 2 new cars
            Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
            Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.BASIC);

            //Create 2 new SUVs
            SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.PREMIUM, true, 0.5);
            SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);

            //Create 2 new trucks
            Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
            Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
