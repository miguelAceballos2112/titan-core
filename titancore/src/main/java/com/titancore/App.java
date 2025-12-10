package com.titancore;

import com.titancore.Finance.InterestCalculator;
import com.titancore.Fitness.Gym;
import com.titancore.Fitness.RunningCalculator;
import com.titancore.Utilities.ScannerReadAndWrite;

import java.util.List;

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
                    "Ingrese que quiere hace el dia de hoy\n1 - Mirar opciones de running\n" +
                            "2 - Calcular un interés compuesto\n3 - Conversion de libras a kilogramos\n4 - Salir\nOpcion:");
            String mostrarMensaje = "";
            switch (optionCalculator) {
                case 1:
                    boolean runningCOntinue = true;
                    do {
                        int optionRunning = scanner.ingresarEntero(
                                "Que quieres hacer el dia de hoy en running?:\n1 - Calcular ritmo\n2 - Ingresar ritmos al historial\n" +
                                        "3 - Mirar historial de ritmos registrados\n4- Salir de running\nOpcion:");
                        switch (optionRunning) {
                            case 1:
                                double distance = scanner.ingresarReal("Ingrese la distacia en km: ");
                                int time = scanner.ingresarEntero("Ingrese el tiempo en minutos: ");
                                double pace = myRunningCalculator.calculatePace(distance, time);
                                mostrarMensaje = "El ritmo es: " + pace + " minutos/km";
                                break;
                            case 2:
                                double ritmoRegistrado = scanner.ingresarReal("Ingrese el ritmo ya calculado :");
                                myRunningCalculator.addPaceToHistory(ritmoRegistrado);
                                mostrarMensaje = "Ritmo guardado correctamente";
                                break;
                            case 3:
                                System.out.println("--- Historial de Ritmos ---");
                                List<Double> historial = myRunningCalculator.getPaceHistory();
                                if (historial.isEmpty()) {
                                    System.out.println("No hay ritmos registrados aún.");
                                } else {
                                    for (int i = 0; i < historial.size(); i++) {
                                        System.out.println("Registro " + (i + 1) + ": " + historial.get(i) + " min/km");
                                    }
                                }
                                break;
                            case 4:
                                mostrarMensaje = "Saliste de el menu de running";
                                runningCOntinue = false;
                            default: System.out.println("Opcion incorrecta");
                        }
                        System.out.println(mostrarMensaje);
                    } while (runningCOntinue);

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
                default:mostrarMensaje = "Opcion no valida";

                    break;
            }
            System.out.println(mostrarMensaje);
        } while (ejecuting);
    }

}
