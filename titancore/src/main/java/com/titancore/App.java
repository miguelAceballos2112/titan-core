package com.titancore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Variables where data is entered
        boolean ejecuting = true;
        do {
            int optionCalculator = ingresarEntero(
                    "Ingrese que calculo quiere hace el dia de hoy\n1 - Ritmo\n2 - Interes compuesto\n3 - Conversion de libras a kilogramos\n4 - Salir\nOpcion:");
            String mostrarMensaje = "";
            switch (optionCalculator) {
                case 1:
                    double distance = ingresarReal("Ingrese la distacia en km: ");
                    int time = ingresarEntero("Ingrese el tiempo en minutos: ");
                    double pace = calculatePace(distance, time);
                    mostrarMensaje = "El ritmo es: " + pace + " minutos/km";
                    break;
                case 2:
                    double initialCapital = ingresarReal("Ingrese el capital inicial (en pesos colombianos): ");
                    double annualInterestRate = ingresarReal("Ingrese la tasa de interes anual (en porcentaje): ");
                    int years = ingresarEntero("Ingrese el numero de años: ");
                    double compoundInterest = calculateCompoundInterest(initialCapital, annualInterestRate, years);
                    mostrarMensaje = "El interes compuesto (en pesos colombianos) es: $" + Math.round(compoundInterest);
                    break;
                case 3:
                    double pounds = ingresarReal("Ingrese el numero de libras: ");
                    double kilograms = convertPoundsToKilograms(pounds);
                    mostrarMensaje = "El peso en kilogramos es: " + kilograms;
                    break;
                case 4:
                    mostrarMensaje = "Gracias por usar el programa";
                    ejecuting = false;
                    break;
                default:
                    mostrarMensaje = "Opcion no valida";
                    break;
            }
            System.out.println(mostrarMensaje);
        } while (ejecuting);
    }

    // Converter variables and calculators
    public static double calculatePace(double distance, int time) {
        double pace = time / distance;
        return pace;
    }

    public static double calculateCompoundInterest(double initialCapital, double annualInterestRate, int years) {
        double rateDecimal = annualInterestRate / 100.0;
        double finalAmountFactor = Math.pow(1 + rateDecimal, years);
        double interestOnly = initialCapital * (finalAmountFactor - 1);
        return Math.round(interestOnly);
    }

    public static double convertPoundsToKilograms(double pounds) {
        double kilograms = 0;
        kilograms = Math.round(pounds * 0.45);
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
