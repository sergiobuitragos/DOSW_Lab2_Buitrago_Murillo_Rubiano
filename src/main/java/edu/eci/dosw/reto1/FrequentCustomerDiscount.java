package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Descuento para clientes frecuentes
 */
public class FrequentCustomerDiscount implements DiscountStrategy {

    private static final BigDecimal DISCOUNT_RATE =
            new BigDecimal("0.10");

    @Override
    public BigDecimal calculateDiscount(BigDecimal subtotal) {

        if (subtotal == null || subtotal.signum() < 0) {
            throw new IllegalArgumentException(
                    "el subtotal no puede ser negativo o null");
        }

        return subtotal.multiply(DISCOUNT_RATE);
    }
}
