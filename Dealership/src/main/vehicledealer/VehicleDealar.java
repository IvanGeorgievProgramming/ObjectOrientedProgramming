package main.vehicledealer;

import java.util.*;
import main.vehicles.*;

public class VehicleDealar {

    //* Parameters

    Set<Car> cars;
    Set<SUV> suvs;
    Set<Truck> trucks;
    double turnover;

    //* Constructor

    public VehicleDealar() {
        this.cars = new HashSet<Car>();
        this.suvs = new HashSet<SUV>();
        this.trucks = new HashSet<Truck>();
        this.turnover = 0;
    }

    //* Getters

    public Set<Car> getCars() {
        return cars;
    }

    public Set<SUV> getSuvs() {
        return suvs;
    }

    public Set<Truck> getTrucks() {
        return trucks;
    }

    public double getTurnover() {
        return turnover;
    }

    //* Setters

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public void setSuvs(Set<SUV> suvs) {
        this.suvs = suvs;
    }

    public void setTrucks(Set<Truck> trucks) {
        this.trucks = trucks;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    //* Methods

    public void addVehicle(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            this.cars.add((Car) vehicle);
        }
        else if (vehicle instanceof SUV) {
            this.suvs.add((SUV) vehicle);
        }
        else if (vehicle instanceof Truck) {
            this.trucks.add((Truck) vehicle);
        }
    }

    public Map<String, Map<Integer, Vehicle>> getAllVehiclesGroupedByMaker() {
        Map<String, Map<Integer, Vehicle>> vehiclesGroupedByMaker = new HashMap<String, Map<Integer, Vehicle>>();
        for (Car car : this.cars) {
            String maker = car.getMaker();
            int id = car.getId();

            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                vehiclesWithIds.put(id, car);
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            else {
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                vehiclesWithIds.put(id, car);
            }
        }
        for (SUV suv : this.suvs) {
            String maker = suv.getMaker();
            int id = suv.getId();
            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                vehiclesWithIds.put(id, suv);
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            else {
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                vehiclesWithIds.put(id, suv);
            }
        }
        for (Truck truck : this.trucks) {
            String maker = truck.getMaker();
            int id = truck.getId();
            if (!vehiclesGroupedByMaker.containsKey(maker)) {
                Map<Integer, Vehicle> vehiclesWithIds = new HashMap<Integer, Vehicle>();
                vehiclesWithIds.put(id, truck);
                vehiclesGroupedByMaker.put(maker, vehiclesWithIds);
            }
            else {
                Map<Integer, Vehicle> vehiclesWithIds = vehiclesGroupedByMaker.get(maker);
                vehiclesWithIds.put(id, truck);
            }
        }
        return vehiclesGroupedByMaker;
    }

    public Set<SUV> getAllSUVWith4By4() {
        Set<SUV> suvsWith4By4 = new HashSet<SUV>();
        for (SUV suv : this.suvs) {
            if (suv.isHas4by4()) {
                suvsWith4By4.add(suv);
            }
        }
        return suvsWith4By4;
    }

    public Set<Car> getAllCarsWithEquipmentLevel(EquipmentLevel equipmentLevel) {
        Set<Car> carsWithEquipmentLevel = new HashSet<Car>();
        for (Car car : this.cars) {
            if (car.getEquipmentLevel() == equipmentLevel) {
                carsWithEquipmentLevel.add(car);
            }
        }
        return carsWithEquipmentLevel;
    }

    public Vehicle getCheapestVehicle(List<Vehicle> vehicles) {
        Vehicle cheapestVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (cheapestVehicle == null || vehicle.getPrice() < cheapestVehicle.getPrice()) {
                cheapestVehicle = vehicle;
            }
        }
        return cheapestVehicle;
    }

    public int getTotalNumberOfModels(String maker) {
        Set<String> models = new HashSet<String>();
        for (Car car : this.cars) {
            if (car.getMaker().equals(maker)) {
                models.add(car.getModel());
            }
        }
        for (SUV suv : this.suvs) {
            if (suv.getMaker().equals(maker)) {
                models.add(suv.getModel());
            }
        }
        for (Truck truck : this.trucks) {
            if (truck.getMaker().equals(maker)) {
                models.add(truck.getModel());
            }
        }
        return models.size();
    }

    public void sellVehicle(int vehicleId) {
        for (Car car : this.cars) {
            if (car.getId() == vehicleId) {
                this.cars.remove(car);
                this.turnover += car.getPrice();
                return;
            }
        }
        for (SUV suv : this.suvs) {
            if (suv.getId() == vehicleId) {
                this.suvs.remove(suv);
                this.turnover += suv.getPrice();
                return;
            }
        }
        for (Truck truck : this.trucks) {
            if (truck.getId() == vehicleId) {
                this.trucks.remove(truck);
                this.turnover += truck.getPrice();
                return;
            }
        }
    }

    public void printVehicles() {
        for (Car car : this.cars) {
            car.printInfo();
        }
        for (SUV suv : this.suvs) {
            suv.printInfo();
        }
        for (Truck truck : this.trucks) {
            truck.printInfo();
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        vehicles.addAll(this.cars);
        vehicles.addAll(this.suvs);
        vehicles.addAll(this.trucks);

        return vehicles;
    }
}