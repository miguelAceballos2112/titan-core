package com.titancore.Utilities;

import java.util.Scanner;

public class ScannerReadAndWrite {

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