package com.titancore;

import com.titancore.Utilities.ScannerReadAndWrite;
import com.titancore.Fitness.RunningCalculator;
import com.titancore.Finance.InterestCalculator;
import com.titancore.Fitness.Gym;

public class App {
    public static void main(String[] args) {
        // Variables where data is entered
        ScannerReadAndWrite scanner = new ScannerReadAndWrite();
        RunningCalculator myRunningCalculator = new RunningCalculator();
        InterestCalculator myInterestCalculator = new InterestCalculator();
        Gym myGym = new Gym();
        boolean ejecuting = true;
        do {
            int optionCalculator = scanner.ingresarEntero(
                    "Ingrese que calculo quiere hace el dia de hoy\n1 - Ritmo\n2 - Interes compuesto\n3 - Conversion de libras a kilogramos\n4 - Salir\nOpcion:");
            String mostrarMensaje = "";
            switch (optionCalculator) {
                case 1:
                    double distance = scanner.ingresarReal("Ingrese la distacia en km: ");
                    int time = scanner.ingresarEntero("Ingrese el tiempo en minutos: ");
                    double pace = myRunningCalculator.calculatePace(distance, time);
                    mostrarMensaje = "El ritmo es: " + pace + " minutos/km";
                    break;
                case 2:
                    double initialCapital = scanner.ingresarReal("Ingrese el capital inicial (en pesos colombianos): ");
                    double annualInterestRate = scanner
                            .ingresarReal("Ingrese la tasa de interes anual (en porcentaje): ");
                    int years = scanner.ingresarEntero("Ingrese el numero de años: ");
                    double compoundInterest = myInterestCalculator.calculateCompoundInterest(initialCapital,
                            annualInterestRate, years);
                    mostrarMensaje = "El interes compuesto (en pesos colombianos) es: $" + Math.round(compoundInterest);
                    break;
                case 3:
                    double pounds = scanner.ingresarReal("Ingrese el numero de libras: ");
                    double kilograms = myGym.convertPoundsToKilograms(pounds);
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
