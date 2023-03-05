package main;

import main.vehicles.*;
import main.vehicledealer.*;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            //Create a new vehicle dealer
            VehicleDealar vehicleDealar = new VehicleDealar();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
