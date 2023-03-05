package test.vehicledealer;

import org.junit.Test;
import static org.junit.Assert.*;

import	main.vehicles.*;
import	main.vehicledealer.*;


public class VehicleDealerTest {
    @Test
    public void addVehicleTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        vehicleDealar.addVehicle(car);

        assertEquals(1, vehicleDealar.getCars().size());
    }

    @Test
    public void addVehicleTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);

        assertNotEquals(1, vehicleDealar.getCars().size());
    }
    
    @Test
    public void getAllVehiclesGroupedByMakerTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertEquals(4, vehicleDealar.getAllVehiclesGroupedByMaker().size());
    }

    @Test
    public void getAllVehiclesGroupedByMakerTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertNotEquals(1, vehicleDealar.getAllVehiclesGroupedByMaker().size());
    }

    @Test
    public void getAllSUVWith4By4TestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertEquals(0, vehicleDealar.getAllSUVWith4By4().size());
    }

    @Test
    public void getAllSUVWith4By4TestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertNotEquals(2, vehicleDealar.getAllSUVWith4By4().size());
    }

    @Test
    public void getAllCarsWithEquipmentLevelTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertEquals(1, vehicleDealar.getAllCarsWithEquipmentLevel(EquipmentLevel.PREMIUM).size());
    }

    @Test
    public void getAllCarsWithEquipmentLevelTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertNotEquals(2, vehicleDealar.getAllCarsWithEquipmentLevel(EquipmentLevel.PREMIUM).size());
    }

    @Test
    public void getCheapestVehicleTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertEquals(suv2, vehicleDealar.getCheapestVehicle(vehicleDealar.getAllVehicles()));
    }

    @Test
    public void getCheapestVehicleTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertNotEquals(suv1, vehicleDealar.getCheapestVehicle(vehicleDealar.getAllVehicles()));
    }

    @Test
    public void getTotalNumberOfModelsTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertEquals(2, vehicleDealar.getTotalNumberOfModels("Toyota"));
    }

    @Test
    public void getTotalNumberOfModelsTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        assertNotEquals(3, vehicleDealar.getTotalNumberOfModels("Toyota"));
    }

    @Test
    public void sellVehicleTestCorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        vehicleDealar.sellVehicle(1);
        assertEquals(5, vehicleDealar.getAllVehicles().size());
    }

    @Test
    public void sellVehicleTestIncorrect() {
        VehicleDealar vehicleDealar = new VehicleDealar();
        Car car1 = new Car("Ferrari", "550", 1996, "Red", 200000, 4, 4, EquipmentLevel.SPORT);
        Car car2 = new Car("Toyota", "Avalon", 2005, "Gray", 16000, 5, 4, EquipmentLevel.PREMIUM);
        SUV suv1 = new SUV("Toyota", "Highlander Hybrid", 2012, "Black", 30000, 5, 4, EquipmentLevel.BASIC, true, 0.5);
        SUV suv2 = new SUV("Chevrolet", "S-10 Blazer", 1987, "Red", 9000, 5, 2, EquipmentLevel.BASIC, false, 0.8);
        Truck truck1 = new Truck("Freightliner", "FL86", 1984, "Blue and Red", 40000, 1000, 10);
        Truck truck2 = new Truck("Chevrolet", "Silverado 1500", 2017, "White", 60000, 1000, 12);
        vehicleDealar.addVehicle(car1);
        vehicleDealar.addVehicle(car2);
        vehicleDealar.addVehicle(suv1);
        vehicleDealar.addVehicle(suv2);
        vehicleDealar.addVehicle(truck1);
        vehicleDealar.addVehicle(truck2);

        vehicleDealar.sellVehicle(1);
        assertNotEquals(6, vehicleDealar.getAllVehicles().size());
    }
}
