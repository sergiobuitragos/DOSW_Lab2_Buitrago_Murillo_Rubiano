package edu.eci.dosw.reto3;

import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dealership dealership = new Dealership(scanner);
        dealership.run();

        PurchaseSummary summary = new PurchaseSummary(dealership.getSelectedVehicles());
        double subtotal = summary.calculateSubtotal();

        System.out.println("\nVehículos seleccionados: " + dealership.getSelectedVehicles().size());
        System.out.println("Subtotal: $" + subtotal);

    }
}