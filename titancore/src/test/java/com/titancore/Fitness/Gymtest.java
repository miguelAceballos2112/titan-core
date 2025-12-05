package com.titancore.Fitness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Gymtest {

    @Test
    public void convertPoundsToKilogramsTest() {
        // Arrange
        Gym gym = new Gym();
        double pounds = 100;
        double expectedKilograms = 45.0;

        // Act
        double kilograms = gym.convertPoundsToKilograms(pounds);

        // Assert
        assertEquals(kilograms, expectedKilograms, 0);
    }

}
