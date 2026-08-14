package edu.eci.dosw.reto2;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder hace la hamburguesa paso a paso
 * hace la hamburguesa con build()
 */
public class BurgerBuilder {

    private final List<Ingredient> ingredients = new ArrayList<>();

    /**
     * pone el pan a la hamburguesa
     * @param name
     * @param price 
     * @return
     */
    public BurgerBuilder withBread(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * pone la carne
     * @param name
     * @param price
     * @return
     */
    public BurgerBuilder withMeat(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * pone un ingrediente a la hamburguesa.
     * @param name
     * @param price
     * @return
     */
    public BurgerBuilder addIngredient(String name, double price) {
        ingredients.add(new Ingredient(name, price));
        return this;
    }

    /**
     * hace la amburguesa
     * @return
     */
    public Burger build() {
        return new Burger(new ArrayList<>(ingredients));
    }
}
