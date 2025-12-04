package com.titancore;

import static com.titancore.Utilities.ScannerReadAndWrite.ingresarEntero;
import static com.titancore.Utilities.ScannerReadAndWrite.ingresarReal;
import static com.titancore.Fitness.RunningCalculator.calculatePace;
import static com.titancore.Fitness.Gym.convertPoundsToKilograms;
import static com.titancore.Finance.InterestCalculator.calculateCompoundInterest;

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

}
