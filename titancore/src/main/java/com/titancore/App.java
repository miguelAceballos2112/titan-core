package com.titancore;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Variables where data is entered
        int optionCalculator = ingresarEntero(
                "Ingrese que calculo quiere hace el dia de hoy 1 (Ritmo), 2 (Interes compuesto), 3 (Conversion de libras a kilogramos): ");
        String mostrarMensaje = "";
        switch (optionCalculator) {
            case 1:
                double distance = ingresarReal("Ingrese la distacia en km: ");
                int time = ingresarEntero("Ingrese el tiempo en minutos: ");
                double pace = calculatePace(distance, time);
                mostrarMensaje = "El ritmo es: " + pace;
                break;
            case 2:
                double initialCapital = ingresarReal("Ingrese el capital inicial: ");
                double annualInterestRate = ingresarReal("Ingrese la tasa de interes anual: ");
                int capitalizationFrequency = ingresarEntero("Ingrese la frecuencia de capitalizacion: ");
                int years = ingresarEntero("Ingrese el numero de años: ");
                double compoundInterest = calculateCompoundInterest(initialCapital, annualInterestRate,
                        capitalizationFrequency, years);
                mostrarMensaje = "El interes compuesto es: " + compoundInterest;
                break;
            case 3:
                double pounds = ingresarReal("Ingrese el numero de libras: ");
                double kilograms = convertPoundsToKilograms(pounds);
                mostrarMensaje = "El peso en kilogramos es: " + kilograms;
                break;
            default:
                mostrarMensaje = "Opcion no valida";
                break;
        }
        System.out.println(mostrarMensaje);

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

}
