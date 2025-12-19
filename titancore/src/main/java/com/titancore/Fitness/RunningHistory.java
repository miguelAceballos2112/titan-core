package com.titancore.Fitness;

import java.util.ArrayList;
import java.util.List;

public class RunningHistory {

    public List<RunningSession> sessionsHistory;

    public RunningHistory() {
        this.sessionsHistory = new ArrayList<>();
    }

    public List<RunningSession> getSessionsHistory() {
        return sessionsHistory;
    }

    public void addSessionToHistory(RunningSession session) {
        sessionsHistory.add(session);
    }

    public double calculateAveragePace(List<Double> paceHistory) {
        double totalPace = 0;
        for (double pace : paceHistory) {
            totalPace += pace;
        }
        return Math.round((totalPace / paceHistory.size()) * 100.0) / 100.0;
    }

    public double getTotalDistance() {
        double totalDistance = 0;
        for (RunningSession session : sessionsHistory) {
            totalDistance += session.getDistance();
        }
        return totalDistance;
    }

    public double getTotalTime() {
        double totalTime = 0;
        for (RunningSession session : sessionsHistory) {
            totalTime += session.getTime();
        }
        return totalTime;
    }

}
