package com.titancore.Fitness;

public class RunningSession {

    private double distance;
    private double time;
    private double pace;

    public RunningSession(double distance, double time) {
        this.distance = distance;
        this.time = time;
        this.pace = Math.round(time / distance * 100.0) / 100.0;
        ;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getPace() {
        return pace;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

}
