package org.elsys_bg.race;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;

public class PitStopTeam implements Runnable {
    private final int id;
    private final String team;
    private final Race race;

    private int servicedCars = 0;

    public PitStopTeam(int id, String team, Race race) {
        this.id = id;
        this.team = team;
        this.race = race;
    }

    @Override
    public void run() {
        while (race.raceNotFinished()) {
            try {
                service(race.getTrack().getPitLane().getNextCar(team));
            } catch (InterruptedException e) {
                System.out.println("Race finished for: " + this);
            }
        }
    }

    private void service(Car nextCar) throws InterruptedException {
        System.out.println(this + " is servicing " + nextCar);
        sleep(getTimeForService());
        nextCar.leavePitStop();
        servicedCars++;
    }

    private int getTimeForService() {
        return ThreadLocalRandom.current().nextInt(400, 1000);
    }

    public int getServicedCars() {
        return servicedCars;
    }

    public int getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "PitStopTeam{" +
                "id=" + id +
                ", team='" + team + '\'' +
                '}';
    }
}
