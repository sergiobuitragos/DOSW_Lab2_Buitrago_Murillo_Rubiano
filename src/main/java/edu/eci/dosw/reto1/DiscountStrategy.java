package edu.eci.dosw.reto1;
import java.math.BigDecimal;

/**
 * estrategia para el descuento
 */
public interface DiscountStrategy {

    /**
     * calcula el descuento
     * @param subtotal
     * @return
     */
    BigDecimal calculateDiscount(BigDecimal subtotal);
}
