package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Base class for discount strategies.
 * Centralizes subtotal validation shared by all concrete strategies.
 */
public abstract class AbstractDiscountStrategy implements DiscountStrategy {

    @Override
    public final BigDecimal calculateDiscount(BigDecimal subtotal) {
        validateSubtotal(subtotal);
        return applyDiscount(subtotal);
    }

    private void validateSubtotal(BigDecimal subtotal) {
        if (subtotal == null || subtotal.signum() < 0) {
            throw new InvalidAmountException("Subtotal cannot be null or negative.");
        }
    }

    /**
     * Applies the specific discount rate. Subclasses only define the rate logic.
     */
    protected abstract BigDecimal applyDiscount(BigDecimal subtotal);
}