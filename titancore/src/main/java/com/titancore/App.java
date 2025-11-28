package com.titancore;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Variables where data is entered
        double distance = ingresarReal("Enter the distance in km: ");
        int time = ingresarEntero("Enter the time in minutes: ");
        double initialCapital = ingresarReal("Enter the initial capital: ");
        double annualInterestRate = ingresarReal("Enter the annual interest rate: ");
        int capitalizationFrequency = ingresarEntero("Enter the capitalization frequency: ");
        int years = ingresarEntero("Enter the number of years: ");
        double pounds = ingresarReal("Enter the number of pounds: ");
        double pace = calculatePace(distance, time);
        double compoundInterest = calculateCompoundInterest(initialCapital, annualInterestRate, capitalizationFrequency,
                years);
        double kilograms = convertPoundsToKilograms(pounds);
        mostrarMensaje(pace, compoundInterest, kilograms);
    }

    // Converter variables and calculators
    public static double calculatePace(double distance, int time) {
        double pace = time / distance;
        return pace;
    }

    public static double calculateCompoundInterest(double initialCapital, double annualInterestRate,
            int capitalizationFrequency, int years) {
        double compoundInterest = initialCapital
                * Math.pow(1 + annualInterestRate / capitalizationFrequency, capitalizationFrequency * years);
        return compoundInterest;
    }

    public static double convertPoundsToKilograms(double pounds) {
        double kilograms = 0;
        kilograms = pounds * 0.45359;
        return kilograms;
    }

    // scanner input reading variables
    public static double ingresarReal(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        double valorReal = scanner.nextDouble();
        return valorReal;
    }

    public static int ingresarEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        int valorEntero = scanner.nextInt();
        return valorEntero;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);

    }

    public static void mostrarMensaje(double pace, double compoundInterest, double kilograms) {
        System.out.println("The average pace according to the data entered is: " + pace +
                "\nThe interest you would be receiving, according to the data entered, is: " +
                compoundInterest + "\nThe weight in kilograms is: " + kilograms);
    }
}
