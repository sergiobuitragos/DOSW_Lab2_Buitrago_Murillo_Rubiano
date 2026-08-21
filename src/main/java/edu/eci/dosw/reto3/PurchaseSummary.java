package edu.eci.dosw.reto3;

import java.util.List;

/**
 * Calcula el subtotal, el descuento aplicable y el total final
 * de una lista de vehículos seleccionados, usando Java Streams.
 *
 * Reglas de descuento (definidas por el equipo)
 * - Más de 6 vehículos: 10% de descuento.
 * - Subtotal >= $500,000,000: 5% de descuento adicional.
 * - Ambos descuentos pueden aplicarse juntos, de forma compuesta
 * (el segundo se calcula sobre el resultado del primero).
 */
public final class PurchaseSummary {

    private static final int QUANTITY_THRESHOLD = 6;
    private static final double QUANTITY_DISCOUNT_RATE = 0.10;

    private static final double AMOUNT_THRESHOLD = 500_000_000;
    private static final double AMOUNT_DISCOUNT_RATE = 0.05;

    private final List<Vehicle> vehicles;

    public PurchaseSummary(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public double calculateSubtotal() {
        return vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .sum();
    }

    /**
     * Retorna el monto total descontado (no el porcentaje), es decir,
     * cuánto dinero se le resta al subtotal por aplicar los descuentos.
     */
    public double calculateDiscountAmount() {
        double subtotal = calculateSubtotal();
        double total = subtotal;

        if (isQuantityDiscountApplicable()) {
            total *= (1 - QUANTITY_DISCOUNT_RATE);
        }
        if (isAmountDiscountApplicable(subtotal)) {
            total *= (1 - AMOUNT_DISCOUNT_RATE);
        }

        return subtotal - total;
    }

    public double calculateFinalTotal() {
        return calculateSubtotal() - calculateDiscountAmount();
    }

    public boolean isQuantityDiscountApplicable() {
        return vehicles.size() > QUANTITY_THRESHOLD;
    }

    public boolean isAmountDiscountApplicable(double subtotal) {
        return subtotal >= AMOUNT_THRESHOLD;
    }

    public void printSummary() {
        System.out.println("........Resumen de compra.........");
        for (Vehicle vehicle : vehicles) {
            vehicle.showInfo();
            System.out.println("---");
        }

        double subtotal = calculateSubtotal();
        double discount = calculateDiscountAmount();
        double total = calculateFinalTotal();

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: $" + discount);
        System.out.println("Total final: $" + total);
    }

}