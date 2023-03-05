package main;

import java.util.*;
import main.vehicles.Vehicle;
import main.vehicles.Car;
import main.vehicles.SUV;
import main.vehicles.Truck;
import main.vehicles.EquipmentLevel;
import main.vehicledealer.VehicleDealar;

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

            //Add the vehicles to the vehicle dealer
            vehicleDealar.addVehicle(car1);
            vehicleDealar.addVehicle(car2);
            vehicleDealar.addVehicle(suv1);
            vehicleDealar.addVehicle(suv2);
            vehicleDealar.addVehicle(truck1);
            vehicleDealar.addVehicle(truck2);

            //Print the vehicles
            vehicleDealar.printVehicles();

            System.out.println();
            System.out.println();

            //Print the vehicles by maker
            Map <String, Map<Integer, Vehicle>> map = vehicleDealar.getAllVehiclesGroupedByMaker();
            for (Map.Entry<String, Map<Integer, Vehicle>> entry : map.entrySet()) {
                //System.out.println(entry.getKey());
                for (Map.Entry<Integer, Vehicle> entry2 : entry.getValue().entrySet()) {
                    System.out.println(entry2.getValue());
                }
            }

            System.out.println();
            System.out.println();

            // Get all SUVs with 4by4
            Set<SUV> suvs = vehicleDealar.getAllSUVWith4By4();
            for (SUV suv : suvs) {
                suv.printInfo();
            }

            System.out.println();
            System.out.println();

            // Get all cars with premium equipment
            Set<Car> cars = vehicleDealar.getAllCarsWithEquipmentLevel(EquipmentLevel.PREMIUM);
            for (Car car : cars) {
                car.printInfo();
            }

            System.out.println();
            System.out.println();

            // Get cheapest vehicle
            Vehicle cheapestVehicle = vehicleDealar.getCheapestVehicle(vehicleDealar.getAllVehicles());
            // Find if the vehicle is a car
            if(cheapestVehicle instanceof Car){
                Car cheapestCar = (Car) cheapestVehicle;
                cheapestCar.printInfo();
            }
            // Find if the vehicle is a SUV
            else if(cheapestVehicle instanceof SUV){
                SUV cheapestSUV = (SUV) cheapestVehicle;
                cheapestSUV.printInfo();
            }
            // Find if the vehicle is a truck
            else if(cheapestVehicle instanceof Truck){
                Truck cheapestTruck = (Truck) cheapestVehicle;
                cheapestTruck.printInfo();
            }

            System.out.println();
            System.out.println();

            // Get total number of models
            int totalNumberOfModels = vehicleDealar.getTotalNumberOfModels("Toyota");
            System.out.println(totalNumberOfModels);

            System.out.println();
            System.out.println();

            // Sell a vehicle
            vehicleDealar.sellVehicle(1);
            vehicleDealar.printVehicles();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
