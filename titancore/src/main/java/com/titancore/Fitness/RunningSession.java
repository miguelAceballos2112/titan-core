package com.titancore.Fitness;

public class RunningSession {

    private double distance;
    private int time;
    private double pace;

    public RunningSession(double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.pace = pace;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public double getPace() {
        return pace;
    }

}
