package edu.eci.dosw.reto2;

import java.util.List;

/**
 * Representa una hamburguesa personalizada.
 *
 * Contiene los ingredientes seleccionados y permite
 * calcular el precio total y mostrar un resumen.
 */
public class Burger {

    private final List<Ingredient> ingredients;

    /**
     *crea una hamburguesa con los ingredientes
     * @param ingredients
     */
    public Burger(List<Ingredient> ingredients) {
        this.ingredients = List.copyOf(ingredients); //immutable
    }

    /**
     * @return
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Calcula el precio usando Java Streams
     * @return
     */
    public double calculatePrice() {
        return ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    /**
     * Muestra los ingredientes y el precio
     */
    public void showSummary() {
        System.out.println("hamburguesa");
        System.out.println();
        System.out.println("Ingredientes:");

        ingredients.forEach(ingredient ->
                System.out.println("- " + ingredient));

        System.out.println();
        System.out.println("Precio final: $" + calculatePrice());
    }
}
