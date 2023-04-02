package org.elsys_bg.race;

public class Track {
    private final String name;
    private final PitLane pitLane;

    private final int timeToFinish;

    public Track(String name, PitLane pitLane, int timeToFinish) {
        this.name = name;
        this.pitLane = pitLane;
        this.timeToFinish = timeToFinish;
    }

    public String getName() {
        return name;
    }

    public PitLane getPitLane() {
        return pitLane;
    }

    public int getTimeToFinish() {
        return timeToFinish;
    }
}
