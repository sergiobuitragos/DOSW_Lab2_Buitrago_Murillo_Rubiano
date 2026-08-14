package edu.eci.dosw.reto1;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a product in the system.
 * Once created, the name and price cannot be changed
 */
public final class Product {
    private final String name;
    private final BigDecimal unitPrice;

    public Product(String name, BigDecimal unitPrice) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or blank");
        }
        if (unitPrice == null || unitPrice.signum() < 0) {
            throw new IllegalArgumentException("Product units cannot be null or negative");
        }
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return name.equals(product.name) && unitPrice.equals(product.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }

    @Override
    public String toString() {
        return name + " (COP " + unitPrice + ")";
    }
}
