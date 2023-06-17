package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getVIN().equals(vin)) {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        if (vehicles.isEmpty()) {
            return null;
        }

        Vehicle lowestMileageVehicle = vehicles.get(0);
        for (int i = 1; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            if (vehicle.getMileage() < lowestMileageVehicle.getMileage()) {
                lowestMileageVehicle = vehicle;
            }
        }
        return lowestMileageVehicle;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:\n");
        for (Vehicle vehicle : vehicles) {
            sb.append(vehicle.toString()).append("\n");
        }
        return sb.toString();
    }
}

