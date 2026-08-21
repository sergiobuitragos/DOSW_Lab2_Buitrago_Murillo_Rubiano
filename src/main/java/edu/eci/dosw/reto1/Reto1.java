package edu.eci.dosw.reto1;

import java.math.BigDecimal;

public final class Reto1 {

    private Reto1() {
    }

    public static void run() {
        System.out.println("Running Challenge 1 — Don Pepe's Store...");

        Product tshirt = new Product("T-shirt", new BigDecimal("20000"));
        Product cookies = new Product("Cookies", new BigDecimal("500"));
        Product juice = new Product("Natural Juice", new BigDecimal("3000"));

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(tshirt, 2);
        cart.addItem(cookies, 3);
        cart.addItem(juice, 5);

        Customer customer = new Customer("Frequent Test Customer", new FrequentCustomerDiscount());

        Receipt receipt = new Receipt(customer, cart);
        receipt.print();
    }
}