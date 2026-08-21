package edu.eci.dosw.reto2;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds a burger step by step by accumulating its ingredients before creating
 * the final burger instance with {@link #build()}.
 */
public class BurgerBuilder {

    /**
     * The list of ingredients that will form the burger.
     */
    private final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * Adds the bread to the burger being constructed.
     *
     * @param name  the bread name
     * @param price the bread price
     * @return this builder instance to allow method chaining
     */
    public BurgerBuilder withBread(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * Adds the meat to the burger being constructed.
     *
     * @param name  the meat name
     * @param price the meat price
     * @return this builder instance to allow method chaining
     */
    public BurgerBuilder withMeat(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * Adds a generic ingredient to the burger.
     *
     * @param name  the ingredient name
     * @param price the ingredient price
     * @return this builder instance to allow method chaining
     */
    public BurgerBuilder addIngredient(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * Creates and returns the finished burger with all added ingredients.
     *
     * @return a new burger instance containing a copy of the accumulated
     *         ingredients
     */
    public Burger build() {
        return new Burger(new ArrayList<>(ingredients));
    }
}
