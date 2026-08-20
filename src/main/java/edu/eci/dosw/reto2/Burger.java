package edu.eci.dosw.reto2;

import java.util.List;

/**
 * Represents a customized burger.
 *
 * This class stores the selected ingredients and provides the ability to
 * calculate the total price and display a summary of the order.
 */
public class Burger {

    /**
     * The immutable list of ingredients included in the burger.
     */
    private final List<Ingredient> ingredients;

    /**
     * Creates a burger with the provided ingredients.
     *
     * @param ingredients the ingredients that make up the burger
     */
    public Burger(List<Ingredient> ingredients) {
        this.ingredients = List.copyOf(ingredients); // immutable copy to protect the internal state
    }

    /**
     * Returns the ingredients included in the burger.
     *
     * @return an immutable list of ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Calculates the total price of the burger using Java Streams.
     *
     * @return the sum of all ingredient prices
     */
    public double calculatePrice() {
        return ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    /**
     * Prints a summary of the burger, including its ingredients and final price.
     */
    public void showSummary() {
        System.out.println("Burger");
        System.out.println();
        System.out.println("Ingredients:");

        ingredients.forEach(ingredient -> System.out.println("- " + ingredient));

        System.out.println();
        System.out.println("Final price: $" + calculatePrice());
    }
}
