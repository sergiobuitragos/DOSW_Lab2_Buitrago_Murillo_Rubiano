package edu.eci.dosw.reto1;
import java.math.BigDecimal;

/**
 * Estrategia descuento nuevo cliente
 */
public class NewCustomerDiscount implements DiscountStrategy {

    private static final BigDecimal DISCOUNT_RATE =
            new BigDecimal("0.05");

    @Override
    public BigDecimal calculateDiscount(BigDecimal subtotal) {

        if (subtotal == null || subtotal.signum() < 0) {
            throw new IllegalArgumentException(
                    "Subtotal no puede ser negativo o null");
        }

        return subtotal.multiply(DISCOUNT_RATE);
    }
}
