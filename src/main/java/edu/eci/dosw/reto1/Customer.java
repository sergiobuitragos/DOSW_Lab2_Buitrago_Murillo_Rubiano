package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Represents a customer and their discount strategy.
 */
public final class Customer {

    private final String name;
    private DiscountStrategy discountStrategy;

    /**
     * crea clientes
     * 
     * @param name
     * @param discountStrategy
     */
    public Customer(
            String name,
            DiscountStrategy discountStrategy) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer name cannot be null or blank.");
        }

        if (discountStrategy == null) {
            throw new IllegalArgumentException(
                    "Discount strategy cannot be null.");
        }

        this.name = name;
        this.discountStrategy = discountStrategy;
    }

    public String getName() {
        return name;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    /**
     * Changes the customer's discount strategy at runtime.
     * 
     * @param discountStrategy
     */
    public void setDiscountStrategy(
            DiscountStrategy discountStrategy) {

        if (discountStrategy == null) {
            throw new IllegalArgumentException(
                    "Discount strategy cannot be null.");
        }

        this.discountStrategy = discountStrategy;
    }

    /**
     * calcula el descuento usando la estrategia de descuento
     * 
     * @param subtotal
     * @return
     */
    public BigDecimal calculateDiscount(BigDecimal subtotal) {
        return discountStrategy.calculateDiscount(subtotal);
    }
}
