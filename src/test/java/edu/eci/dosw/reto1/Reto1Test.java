package edu.eci.dosw.reto1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReceiptTest {

    /**
     * This test simulates the scenario described in the problem (2 T-shirts, 3
     * cookies, 5 juices, frequent customer)
     * and verifies the subtotal of 56,500, the discount of 5,650, and the total of
     * 50,850.
     */
    @Test
    void shouldCalculateFrequentCustomerReceiptAccordingToExampleScenario() {

        Product tshirt = new Product("T-shirt", new BigDecimal("20000"));
        Product cookies = new Product("Cookies", new BigDecimal("500"));
        Product juice = new Product("Natural Juice", new BigDecimal("3000"));

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(tshirt, 2);
        cart.addItem(cookies, 3);
        cart.addItem(juice, 5);

        Customer customer = new Customer("Test Customer", new FrequentCustomerDiscount());

        // Act
        Receipt receipt = new Receipt(customer, cart);

        // Assert: values expected by the challenge statement
        assertEquals(0, receipt.getSubtotal().compareTo(new BigDecimal("56500")));
        assertEquals(0, receipt.getDiscount().compareTo(new BigDecimal("5650")));
        assertEquals(0, receipt.getTotal().compareTo(new BigDecimal("50850")));
    }

    /**
     * This test verifies the other case of the Strategy pattern (5% for new
     * customers).
     */
    @Test
    void shouldApplyCorrectDiscountRateForNewCustomer() {
        Product product = new Product("Pants", new BigDecimal("50000"));
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(product, 1);

        Customer newCustomer = new Customer("New Customer", new NewCustomerDiscount());

        Receipt receipt = new Receipt(newCustomer, cart);

        // 5% of 50000 = 2500
        assertEquals(0, receipt.getDiscount().compareTo(new BigDecimal("2500")));
        assertEquals(0, receipt.getTotal().compareTo(new BigDecimal("47500")));
    }

    /**
     * This test validates exception handling by verifying that
     * an invalid receipt is not generated when the cart is empty.
     */
    @Test
    void shouldThrowExceptionWhenGeneratingReceiptForEmptyCart() {
        ShoppingCart emptyCart = new ShoppingCart();
        Customer customer = new Customer("Test Customer", new NewCustomerDiscount());

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> new Receipt(customer, emptyCart));

        assertTrue(exception.getMessage().contains("empty"));
    }
}