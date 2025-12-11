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
                    "Que quiere hace el dia de hoy?\n1 - Ir a opciones de running\n2 - Interes compuesto\n3 - Conversion de libras a kilogramos\n4 - Salir\nOpcion:");
            String mostrarMensaje = "";
            switch (optionCalculator) {
                case 1:
                    String mostrarMensajeRunning = "";
                    boolean ejecutinRunningMenu = true;
                    do {
                        int runningOption = scanner.ingresarEntero(
                                "Que quiere hacer en opciones de running?\n1 - Calcular ritmo\n2 - Agregar sesion de running al historial"
                                        +
                                        "\n3 - Calcular paso promedio de todas las sesiones del historial\n4 - Mirar historial de sesiones\n5 - Salir del menu de running\nOpcion:");
                        switch (runningOption) {
                            case 1:
                                double distance = scanner.ingresarReal("Ingrese la distacia en km: ");
                                int time = scanner.ingresarEntero("Ingrese el tiempo en minutos: ");
                                double pace = myRunningCalculator.calculatePace(distance, time);
                                mostrarMensajeRunning = "El ritmo es: " + pace + " minutos/km";
                                break;
                            case 2:
                                double paceToAdd = scanner
                                        .ingresarReal("Ingrese el ritmo (minutos/km) a agregar al historial: ");
                                myRunningCalculator.addPaceToHistory(paceToAdd);
                                mostrarMensajeRunning = "Ritmo agregado al historial.";
                                break;
                            case 3:
                                for (int i = 0; i < myRunningCalculator.getPaceHistory().size(); i++) {
                                    mostrarMensajeRunning += "Sesion " + (i + 1) + ": "
                                            + myRunningCalculator.getPaceHistory().get(i) + " minutos/km\n";
                                }
                                break;

                            case 4:
                                if (myRunningCalculator.getPaceHistory().isEmpty()) {
                                    mostrarMensajeRunning = "--- Historial de Ritmos ---\nNo hay sesiones en el historial.";
                                } else {
                                    mostrarMensajeRunning = "--- Historial de Ritmos ---\n";
                                    for (int i = 0; i < myRunningCalculator.getPaceHistory().size(); i++) {
                                        mostrarMensajeRunning += "Sesion " + (i + 1) + ": "
                                                + myRunningCalculator.getPaceHistory().get(i) + " minutos/km\n";
                                    }
                                }
                                break;

                            case 5:
                                mostrarMensajeRunning = "Saliendo del menu de running.";
                                ejecutinRunningMenu = false;
                                break;
                            default:
                                mostrarMensajeRunning = "Opcion no valida en menu de running.";
                                break;
                        }
                        System.out.println(mostrarMensajeRunning);
                    } while (ejecutinRunningMenu);

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
