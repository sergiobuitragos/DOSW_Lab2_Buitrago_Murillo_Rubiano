package edu.eci.dosw.reto1;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Represents the receipt genrated after a purchase
 * Receipt
 */
public final class Receipt {

    private static final Locale COLOMBIA = Locale.of("es", "CO");

    private final Customer customer;
    private final ShoppingCart cart;
    private final BigDecimal discount;
    private final BigDecimal subtotal;
    private final BigDecimal total;

    public Receipt(Customer customer, ShoppingCart cart) {

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");

        }
        if (cart == null) {
            throw new IllegalArgumentException("Shopping cart cannot be null.");
        }
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot generate a receipt for an empty cart.");
        }

        this.customer = customer;
        this.cart = cart;
        this.subtotal = cart.calculateSubtotal();
        this.discount = customer.calculateDiscount(subtotal);
        this.total = subtotal.subtract(discount);

    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Prints a formatted receipt to the console.
     * Uses forEach to list each purchased item and filter to skip
     * any item with a zero subtotal (defensive, in case quantity
     * validation upstream ever changes).
     */

    public void print() {

        NumberFormat currencyFormat = NumberFormat.getInstance(COLOMBIA);

        System.out.println(" RECEIPT");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");

        cart.getItems().stream()
                .filter(item -> item.getSubtotal().signum() > 0)
                .forEach(item -> System.out.println(
                        "  - " + item.getProduct().getName()
                                + " x" + item.getQuantity()
                                + " = COP " + currencyFormat.format(item.getSubtotal())));

        System.out.println("Subtotal: COP " + currencyFormat.format(subtotal));
        System.out.println("Discount: COP " + currencyFormat.format(discount));
        System.out.println("Total: COP " + currencyFormat.format(total));
    }

}
