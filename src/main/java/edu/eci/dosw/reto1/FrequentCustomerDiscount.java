package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Descuento para clientes frecuentes
 */
public class FrequentCustomerDiscount extends AbstractDiscountStrategy {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.10");

    @Override
    protected BigDecimal applyDiscount(BigDecimal subtotal) {
        return subtotal.multiply(DISCOUNT_RATE);
    }
}
