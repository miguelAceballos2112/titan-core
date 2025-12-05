package com.titancore.Fitness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RunningCalculatorTest {

    @Test
    public void calculatePaceTest() {
        // Arrange
        RunningCalculator runningCalculator = new RunningCalculator();
        double distance = 5;
        int time = 40;
        double expectedPace = 8; // seconds per kilometer

        // Act
        double pace = runningCalculator.calculatePace(distance, time);

        // Assert
        assertEquals(pace, expectedPace, 0);
    }

}
