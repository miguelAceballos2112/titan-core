package com.titancore.Fitness;

public class Gym {

    public static double convertPoundsToKilograms(double pounds) {
        double kilograms = 0;
        kilograms = Math.round(pounds * 0.45 * 100.0) / 100.0;
        return kilograms;
    }

}
