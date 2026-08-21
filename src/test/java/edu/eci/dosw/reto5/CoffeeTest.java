package edu.eci.dosw.reto5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Valid cases (2): verify that the composition of toppings calculates the
 * description and total price correctly.
 *
 * Validation cases (2): verify that the classes throw IllegalArgumentException
 * when invalid data is provided. These tests pass when the exception is
 * actually
 * thrown (assertThrows).
 */
class CoffeeTest {

    // Valid cases

    @Test
    void shouldCalculatePriceAndDescriptionWithMultipleToppings() {
        // Espresso (2500) + Milk (1000) + Chocolate (1500) = 5000
        Coffee coffee = new NormalCoffee("Espresso", 2500);
        coffee = new Milk(coffee);
        coffee = new Chocolate(coffee);

        assertEquals(5000, coffee.getPrice());
        assertEquals("Espresso+ Milk+ Chocolate", coffee.getDescription());
    }

    @Test
    void shouldCalculatePriceAndDescriptionWithCustomTopping() {
        // Latte (4000) + CustomTopping "Honey" (800) = 4800
        Coffee coffee = new NormalCoffee("Latte", 4000);
        coffee = new CustomTopping(coffee, "Honey", 800);

        assertEquals(4800, coffee.getPrice());
        assertEquals("Latte + Honey", coffee.getDescription());
    }

    // Validation cases (expect exception)

    @Test
    void shouldThrowExceptionWhenCoffeeBasePriceIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new NormalCoffee("Espresso", -1000));
    }

    @Test
    void shouldThrowExceptionWhenCustomToppingPriceIsNegative() {
        Coffee coffee = new NormalCoffee("Americano", 3000);

        assertThrows(IllegalArgumentException.class,
                () -> new CustomTopping(coffee, "Honey", -500));
    }
}