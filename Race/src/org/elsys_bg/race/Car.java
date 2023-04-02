package org.elsys_bg.race;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

public class Car implements Runnable {
    private final int id;
    private final Race race;
    private final String teamName;
    private final String driverName;

    private AtomicBoolean onTrack = new AtomicBoolean(true);

    public Car(int id, Race race, String teamName, String driverName) {
        this.id = id;
        this.race = race;
        this.teamName = teamName;
        this.driverName = driverName;
    }

    @Override
    public void run() {
        while (race.raceNotFinished()) {
            if (onTrack.get()) {
                try {
                    runOnTrack();
                } catch (InterruptedException e) {
                    System.out.println("Race finished for: " + this);
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }

    public synchronized void leavePitStop() {
        onTrack.set(true);
        notifyAll();
    }

    private void runOnTrack() throws InterruptedException {
        System.out.println(this + " is running");
        sleep(getTimeForNextPitStop());
        enterPitLane();
        waitToBeServiced();
    }

    private int getTimeForNextPitStop() {
        return ThreadLocalRandom.current().nextInt(4000, 8000);
    }

    private void enterPitLane() {
        onTrack.set(false);
        race.getTrack().getPitLane().addCar(this);
    }

    private synchronized void waitToBeServiced() throws InterruptedException {
        wait();
    }
}
