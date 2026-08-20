package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Discount strtaegy for new customers.
 */
public class NewCustomerDiscount extends AbstractDiscountStrategy {

    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.05");

    @Override
    protected BigDecimal applyDiscount(BigDecimal subtotal) {
        return subtotal.multiply(DISCOUNT_RATE);
    }
}
