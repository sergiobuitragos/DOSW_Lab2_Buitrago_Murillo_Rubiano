package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * clase cliente y la estrategia de descuento
 */
public final class Customer {

    private final String name;
    private DiscountStrategy discountStrategy;

    /**
     * crea clientes
     * @param name
     * @param discountStrategy
     */
    public Customer(
            String name,
            DiscountStrategy discountStrategy) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "el nombre no puede ser null");
        }

        if (discountStrategy == null) {
            throw new IllegalArgumentException(
                    "la estrategia de descuento no puede ser null");
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
     * cambia la estrategia de los descuentos
     * @param discountStrategy
     */
    public void setDiscountStrategy(
            DiscountStrategy discountStrategy) {

        if (discountStrategy == null) {
            throw new IllegalArgumentException(
                    "la estrategia de descuento no puede ser null");
        }

        this.discountStrategy = discountStrategy;
    }

    /**
     * calcula el descuento usando la estrategia de descuento
     * @param subtotal
     * @return
     */
    public BigDecimal calculateDiscount(BigDecimal subtotal) {
        return discountStrategy.calculateDiscount(subtotal);
    }
}
