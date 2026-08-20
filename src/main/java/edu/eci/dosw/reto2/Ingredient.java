package edu.eci.dosw.reto2;

import java.util.Objects;

/**
 * Represents an ingredient that can be added to a burger, such as bread,
 * meat, cheese, lettuce, or any other component of the final product.
 * This class is immutable: once an instance is created, its name and price
 * cannot be changed.
 */
public final class Ingredient {
    /**
     * The ingredient name.
     */
    private final String name;

    /**
     * The ingredient price in the configured currency.
     */
    private final double price;

    /**
     * Creates a new ingredient with a valid name and non-negative price.
     *
     * @param name  the ingredient name; it must not be null or blank
     * @param price the ingredient price; it must be greater than or equal to zero
     * @throws IllegalArgumentException if the name is invalid or the price is
     *                                  negative
     */
    public Ingredient(String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ingredient name cannot be null or blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Ingredient price cannot be negative");
        }

        this.name = name;
        this.price = price;
    }

    /**
     * Returns the ingredient name.
     *
     * @return the ingredient name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ingredient price.
     *
     * @return the ingredient price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Compares this ingredient with another object for equality.
     * Two ingredients are considered equal when they have the same name and price.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ingredient))
            return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(price, that.price) == 0 && name.equals(that.name);
    }

    /**
     * Generates a hash code based on the ingredient name and price.
     *
     * @return the hash code for this ingredient
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    /**
     * Returns a readable representation of the ingredient.
     *
     * @return a string in the format "name ($price)"
     */
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
