package com.titancore.Fitness;

public class RunningCalculator {
    public static double calculatePace(double distance, int time) {
        double pace = Math.round(time / distance * 100.0) / 100.0;
        return pace;
    }

}
