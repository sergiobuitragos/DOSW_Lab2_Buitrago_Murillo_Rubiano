package edu.eci.dosw.reto3;

import java.util.List;

/**
 * Calcula el subtotal de una lista de vehículos seleccionados usando Java
 * Streams como lo pide el laboratorio.
 * 
 */
public final class PurchaseSummary {

    private final List<Vehicle> vehicles;

    public PurchaseSummary(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double calculateSubtotal() {
        return vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .sum();
    }
}