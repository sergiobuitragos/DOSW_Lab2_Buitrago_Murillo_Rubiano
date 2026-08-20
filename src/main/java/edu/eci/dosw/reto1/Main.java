package edu.eci.dosw.reto1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product tshirt = new Product("T-shirt", new BigDecimal("20000"));
        Product cookies = new Product("Cookies", new BigDecimal("500"));
        Product juice = new Product("Natural Juice", new BigDecimal("3000"));
        // Product gummyCandies = new Product("gummy", new BigDecimal("300"));

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(tshirt, 2);
        cart.addItem(cookies, 3);
        cart.addItem(juice, 5);

        Customer customer = new Customer("Frequent Test Customer", new FrequentCustomerDiscount());

        Receipt receipt = new Receipt(customer, cart);
        receipt.print();

    }
}