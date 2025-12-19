package com.titancore;

import com.titancore.Utilities.ScannerReadAndWrite;
import com.titancore.Fitness.RunningHistory;
import com.titancore.Fitness.RunningSession;
import com.titancore.Finance.InterestCalculator;
import com.titancore.Fitness.Gym;

public class App {
    public static void main(String[] args) {
        // Variables where data is entered
        ScannerReadAndWrite scanner = new ScannerReadAndWrite();
        RunningSession myRunningSession;
        RunningHistory myRunningHistory = new RunningHistory();
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
                                "Que quiere hacer en opciones de running?\n1 -  Registrar Sesion\n2 - Consultar historial de sesiones"
                                        +
                                        "\n3 - Consultar distancia recorrida total\n4 - Consultar total de minutos en sesiones\n5 - Salir del manu de running\nOpcion:");
                        switch (runningOption) {
                            case 1:
                                double distance = scanner.ingresarReal("Ingrese la distacia en km: ");
                                double time = scanner.ingresarReal("Ingrese el tiempo en minutos: ");
                                myRunningSession = new RunningSession(distance, time);
                                myRunningHistory.addSessionToHistory(myRunningSession);
                                break;
                            case 2:
                                int numSession = 1;
                                for (RunningSession session : myRunningHistory.getSessionsHistory()) {
                                    mostrarMensajeRunning = "Sesion " + numSession + ": "
                                            + session.getPace() + " minutos/km     Distancia: "
                                            + session.getDistance() + " km     Tiempo: " + session.getTime()
                                            + " minutos";
                                    System.out.println(mostrarMensajeRunning);
                                    numSession++;
                                }
                                break;
                            case 3:
                                mostrarMensajeRunning = "La distancia total recorrida es: "
                                        + myRunningHistory.getTotalDistance()
                                        + "km";
                                System.out.println(mostrarMensajeRunning);
                                break;

                            case 4:
                                mostrarMensajeRunning = "El tiempo total en sesiones es: " +
                                        myRunningHistory.getTotalTime()
                                        + " minutos";
                                System.out.println(mostrarMensajeRunning);
                                break;
                            case 5:
                                mostrarMensajeRunning = "Saliendo del menu de running.";
                                ejecutinRunningMenu = false;
                                System.out.println(mostrarMensajeRunning);
                                break;
                            default:
                                mostrarMensajeRunning = "Opcion no valida en menu de running.";
                                System.out.println(mostrarMensajeRunning);
                                break;
                        }
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
