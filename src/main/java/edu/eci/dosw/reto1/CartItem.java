package edu.eci.dosw.reto1;

import java.math.BigDecimal;

/**
 * Represents a product added to the shopping cart along with its quantity.
 */
public final class CartItem {

    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal() {
        return product.getUnitPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
