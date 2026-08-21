package edu.eci.dosw.reto3;

import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dealership dealership = new Dealership(scanner);
        dealership.run();

        System.out.println("\nVehículos seleccionados: " + dealership.getSelectedVehicles().size());

    }
}