package com.titancore.Fitness;

import java.util.ArrayList;
import java.util.List;

public class RunningCalculator {
    public List<Double> paceHistory = new ArrayList<>();

    public double calculatePace(double distance, int time) {
        double pace = Math.round(time / distance * 100.0) / 100.0;
        return pace;
    }

    public void addPaceToHistory(double pace) {
        paceHistory.add(pace);
    }

    public List<Double> getPaceHistory() {
        return paceHistory;
    }

}
