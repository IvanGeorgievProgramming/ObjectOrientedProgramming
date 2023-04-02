package org.elsys_bg.race;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PitLane pitLane = new PitLane(5);
        Track track = new Track("test", pitLane, 1*60*1000);
        Race race = new Race(new Date(), track);
        race.registerCar("Ferrari", "Ivancho");
        race.registerCar("Ferrari", "Pesho");
        race.registerCar("Ferrari", "Tosho");
        race.registerCar("Mercedes", "Goshko");
        race.registerCar("Mercedes", "Boshko");
        race.registerTeam("Ferrari");
        race.registerTeam("Mercedes");

        race.start();
        race.join();
    }
}