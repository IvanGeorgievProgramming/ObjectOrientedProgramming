package org.elsys_bg.race;

import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Race extends Thread {
    private final Date date;
    private final Track track;

    private Set<Car> cars = new HashSet<>();
    private Set<Thread> threads = new HashSet<>();
    private int carsCounter = 0;
    private int teamsCounter = 0;

    private boolean raceFinished = false;

    public Race(Date date, Track track) {
        this.date = date;
        this.track = track;
    }

    public void registerCar(String teamName, String driverName) {
        cars.add(new Car(carsCounter++, this, teamName, driverName));
    }

    public void registerTeam(String teamName) {
        track.getPitLane().addPitStopTeam(new PitStopTeam(teamsCounter++, teamName, this));
    }

    @Override
    public void run() {
        try {
            startCars();
            threads.addAll(track.getPitLane().startTeams());
            sleep(track.getTimeToFinish());
        } catch (InterruptedException e) {
            System.out.println("Race was interrupted!");
            throw new RuntimeException(e);
        }
        endRace();
    }

    public Track getTrack() {
        return track;
    }

    public void printRace() {
        StringBuilder builder = new StringBuilder();
        builder.append(date + " - " + track.getName() + "\n");
        builder.append("Pit stop teams: \n");
        track.getPitLane().getPitStopTeams()
                .stream()
                .sorted(Comparator.comparingInt(PitStopTeam::getServicedCars).reversed())
                .forEach(pitStopTeam -> {
                    builder.append(pitStopTeam.getId() + " - " + pitStopTeam.getTeam() + " - " + pitStopTeam.getServicedCars() + "\n");
                });
        System.out.println(builder);
    }

    public boolean raceNotFinished() {
        return !raceFinished;
    }

    private void endRace() {
        raceFinished = true;
        threads.forEach(Thread::interrupt);
        printRace();
    }

    private void startCars() {
        cars.forEach(car -> {
            Thread t = new Thread(car);
            t.setName("Car " + car.getId());
            t.start();
            threads.add(t);
        });
    }
}
