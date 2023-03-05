package main.vehicledealer;

import java.util.*;
import main.vehicles.*;

public class VehicleDealar {

    //* Parameters
    // Make a set of cars
    Set<Car> cars;
    // Make a set of suvs
    Set<SUV> suvs;
    // Make a set of trucks
    Set<Truck> trucks;
    // Make a turnover
    double turnover;

    //* Constructor
    public VehicleDealar() {
        // Initialize the parameters
        this.cars = new HashSet<Car>();
        this.suvs = new HashSet<SUV>();
        this.trucks = new HashSet<Truck>();
        this.turnover = 0;
    }

    //* Methods
    // Add a vehicle to the dealer
    public void addVehicle(Vehicle vehicle) {
        // Check if the vehicle is a car
        if (vehicle instanceof Car) {
            // Add the car to the set of cars
            this.cars.add((Car) vehicle);
        }
        // Check if the vehicle is a suv
        else if (vehicle instanceof SUV) {
            // Add the suv to the set of suvs
            this.suvs.add((SUV) vehicle);
        }
        // Check if the vehicle is a truck
        else if (vehicle instanceof Truck) {
            // Add the truck to the set of trucks
            this.trucks.add((Truck) vehicle);
        }
    }

    // Get all vehicles with their ids grouped by maker
    public Map<String, Map<Integer, Vehicle>> getAllVehiclesGroupedByMaker() {
        // Make a map of vehicles grouped by maker
        Map<String, Map<Integer, Vehicle>> vehiclesGroupedByMaker = new HashMap<String, Map<Integer, Vehicle>>();
        // Loop through the set of cars
        for (Car car : this.cars) {
            // Get the maker of the car
            String maker = car.getMaker();
            // Get the id of the car
            int id = car.getId();
            // Check if the maker is in the map of vehicles grouped by maker
            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                // Make a map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                // Add the car to the map of vehicles with their ids
                vehiclesWithIds.put(id, car);
                // Add the map of vehicles with their ids to the map of vehicles grouped by maker
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            // Check if the maker is in the map of vehicles grouped by maker
            else {
                // Get the map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                // Add the car to the map of vehicles with their ids
                vehiclesWithIds.put(id, car);
            }
        }
        // Loop through the set of suvs
        for (SUV suv : this.suvs) {
            // Get the maker of the suv
            String maker = suv.getMaker();
            // Get the id of the suv
            int id = suv.getId();
            // Check if the maker is in the map of vehicles grouped by maker
            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                // Make a map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                // Add the suv to the map of vehicles with their ids
                vehiclesWithIds.put(id, suv);
                // Add the map of vehicles with their ids to the map of vehicles grouped by maker
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            // Check if the maker is in the map of vehicles grouped by maker
            else {
                // Get the map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                // Add the suv to the map of vehicles with their ids
                vehiclesWithIds.put(id, suv);
            }
        }
        // Loop through the set of trucks
        for (Truck truck : this.trucks) {
            // Get the maker of the truck
            String maker = truck.getMaker();
            // Get the id of the truck
            int id = truck.getId();
            // Check if the maker is in the map of vehicles grouped by maker
            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                // Make a map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                // Add the truck to the map of vehicles with their ids
                vehiclesWithIds.put(id, truck);
                // Add the map of vehicles with their ids to the map of vehicles grouped by maker
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            // Check if the maker is in the map of vehicles grouped by maker
            else {
                // Get the map of vehicles with their ids
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                // Add the truck to the map of vehicles with their ids
                vehiclesWithIds.put(id, truck);
            }
        }
        // Return the map of vehicles grouped by maker
        return vehiclesGroupedByMaker;
    }

    // Get all suvs with a 4by4 system
    public Set<SUV> getAllSUVWith4By4() {
        // Make a set of suvs with a 4by4 system
        Set<SUV> suvsWith4By4 = new HashSet<SUV>();
        // Loop through the set of suvs
        for (SUV suv : this.suvs) {
            // Check if the suv has a 4by4 system
            if (suv.isHas4by4()) {
                // Add the suv to the set of suvs with a 4by4 system
                suvsWith4By4.add(suv);
            }
        }
        // Return the set of suvs with a 4by4 system
        return suvsWith4By4;
    }

    // Get all cars with the specified equipment level
    public Set<Car> getAllCarsWithEquipmentLevel(EquipmentLevel equipmentLevel) {
        // Make a set of cars with the specified equipment level
        Set<Car> carsWithEquipmentLevel = new HashSet<Car>();
        // Loop through the set of cars
        for (Car car : this.cars) {
            // Check if the car has the specified equipment level
            if (car.getEquipmentLevel() == equipmentLevel) {
                // Add the car to the set of cars with the specified equipment level
                carsWithEquipmentLevel.add(car);
            }
        }
        // Return the set of cars with the specified equipment level
        return carsWithEquipmentLevel;
    }

    // Get the cheapest vehicle from the given collection
    public Vehicle getCheapestVehicle(List<Vehicle> vehicles) {
        // Make a vehicle
        Vehicle cheapestVehicle = null;
        // Loop through the collection of vehicles
        for (Vehicle vehicle : vehicles) {
            // Check if the vehicle is the cheapest vehicle
            if (cheapestVehicle == null || vehicle.getPrice() < cheapestVehicle.getPrice()) {
                // Set the vehicle as the cheapest vehicle
                cheapestVehicle = vehicle;
            }
        }
        // Return the cheapest vehicle
        return cheapestVehicle;
    }

    // Get the number of models that are sold by the given brand in the dealer
    public int getTotalNumberOfModels(String maker) {
        // Make a set of models
        Set<String> models = new HashSet<String>();
        // Loop through the set of cars
        for (Car car : this.cars) {
            // Check if the car is made by the given brand
            if (car.getMaker().equals(maker)) {
                // Add the model of the car to the set of models
                models.add(car.getModel());
            }
        }
        // Loop through the set of suvs
        for (SUV suv : this.suvs) {
            // Check if the suv is made by the given brand
            if (suv.getMaker().equals(maker)) {
                // Add the model of the suv to the set of models
                models.add(suv.getModel());
            }
        }
        // Loop through the set of trucks
        for (Truck truck : this.trucks) {
            // Check if the truck is made by the given brand
            if (truck.getMaker().equals(maker)) {
                // Add the model of the truck to the set of models
                models.add(truck.getModel());
            }
        }
        // Return the number of models
        return models.size();
    }

    // Sell a vehicle
    public void sellVehicle(int vehicleId) {
        // Loop through the set of cars
        for (Car car : this.cars) {
            // Check if the car has the given id
            if (car.getId() == vehicleId) {
                // Remove the car from the set of cars
                this.cars.remove(car);
                // Add the price of the car to the turnover of the dealer
                this.turnover += car.getPrice();
                // Return
                return;
            }
        }
        // Loop through the set of suvs
        for (SUV suv : this.suvs) {
            // Check if the suv has the given id
            if (suv.getId() == vehicleId) {
                // Remove the suv from the set of suvs
                this.suvs.remove(suv);
                // Add the price of the suv to the turnover of the dealer
                this.turnover += suv.getPrice();
                // Return
                return;
            }
        }
        // Loop through the set of trucks
        for (Truck truck : this.trucks) {
            // Check if the truck has the given id
            if (truck.getId() == vehicleId) {
                // Remove the truck from the set of trucks
                this.trucks.remove(truck);
                // Add the price of the truck to the turnover of the dealer
                this.turnover += truck.getPrice();
                // Return
                return;
            }
        }
    }
}
/*
VehicleDealar
cars - container with all cars offered by the dealer.
suvs - container with all suv offered by the dealer.
trucks - container with all trucks offered by the trader.
turnover - turnover of the trader
addVehicle(Vehicle vehicle) - adds a vehicle to the merchant's containers. If a vehicle with this id already exists, throw an error.
Map<String, Map<Integer, Vehicle>> getAllVehiclesByIdByMaker() - returns all vehicles with their ids grouped by brand. 
getAllSUVWith4By4() - returns all SUVs that have a 4by4 system.
getAllCarsWithEquipmentLevel(EquipmentLevel equipmentLeve) - returns all cars with the specified equipment level
getCheapestVehicle(List vehicles) - returns the cheapest vehicle from the given collection. Should work with any kind of vehicle collections.
getTotalNumberOfModels(String maker) - returns the number of models that are sold by the given brand in the dealer
sellVehicle(int vehicleId) - sell a vehicle. If there is no vehicle with this id, throw an error. After the sale, the merchant's turnover is increased by the price of the vehicle.
*/