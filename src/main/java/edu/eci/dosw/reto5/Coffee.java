package edu.eci.dosw.reto5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * es la clase cafe con la perzonalisacion que se quiere
 */
public class Coffee {

    private final String base;
    private final double basePrice;
    private final List<Ingredient> ingredients;

    /**
     * crea un cafe con base y precio inicial
     *
     * @param base 
     * @param basePrice
     */
    public Coffee(String base, double basePrice) {

        if (base == null || base.isBlank()) {
            throw new IllegalArgumentException(
                    "La base no puede estar vacia");
        }

        if (basePrice < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo");
        }

        this.base = base;
        this.basePrice = basePrice;
        this.ingredients = new ArrayList<>();
    }

    /**
     * Agrega un ingrediente
     *
     * @param ingredient
     */
    public void addIngredient(Ingredient ingredient) {

        if (ingredient == null) {
            throw new IllegalArgumentException(
                    "El ingrediente no puede ser null");
        }

        ingredients.add(ingredient);
    }

    public String getBase() {
        return base;
    }

    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Obtiene los ingredientes
     *
     * @return
     */
    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }
}
