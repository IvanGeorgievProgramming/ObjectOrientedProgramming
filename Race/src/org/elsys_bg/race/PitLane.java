package org.elsys_bg.race;

import java.util.*;

public class PitLane {
    private final int maxNumberOfTeam;
    private List<Car> cars = new LinkedList<>();

    private Set<PitStopTeam> pitStopTeams = new HashSet<>();

    public PitLane(int maxNumberOfTeam) {
        this.maxNumberOfTeam = maxNumberOfTeam;
    }

    public void addPitStopTeam(PitStopTeam pitStopTeam) {
        if (pitStopTeams.size() < maxNumberOfTeam) {
            pitStopTeams.add(pitStopTeam);
        }
    }

    public synchronized void addCar(Car car) {
        System.out.println(car + " entered pit lane");
        cars.add(car);
        notifyWaitingTeams();
    }

    public synchronized Car getNextCar(String team) {
        Optional<Car> nextCar = Optional.empty();
        while (nextCar.isEmpty()) {
            nextCar = cars.stream()
                    .filter(car -> car.getTeamName().equalsIgnoreCase(team))
                    .findFirst();
            if (nextCar.isEmpty()) {
                waitForCarToEnterPitLane();
            }
        }

        cars.remove(nextCar.get());

        return nextCar.get();
    }

    public Set<PitStopTeam> getPitStopTeams() {
        return pitStopTeams;
    }

    public Set<Thread> startTeams() {
        Set<Thread> teams = new HashSet<>();
        pitStopTeams.forEach(pitStopTeam -> {
            Thread team = new Thread(pitStopTeam);
            team.setName("Team " + pitStopTeam.getId());
            team.start();
            teams.add(team);
        });

        return teams;
    }

    private void notifyWaitingTeams() {
        notifyAll();
    }

    private void waitForCarToEnterPitLane() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
