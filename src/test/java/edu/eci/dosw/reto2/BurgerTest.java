package edu.eci.dosw.reto2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {
    /**
     * El test verifica que si hay un precio negativo se lance una excepción de tipo
     * IllegalArgumentException al crear un ingrediente.
     */
    @Test
    void ingredienteConPrecioNegativoDebeLanzarExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> new Ingredient("Queso", -1.0));
    }

    /**
     * El test verifica que el Builder acumule
     * correctamente los ingredientes seleccionados y que build() genere la
     * hamburguesa esperada.
     */
    @Test
    void builderDebeConstruirHamburguesaConIngredientesSeleccionados() {
        Burger burger = new BurgerBuilder()
                .withBread("Brioche", 2.5)
                .withMeat("Res", 5.0)
                .addIngredient("Cheddar", 1.0)
                .build();

        List<Ingredient> ingredients = burger.getIngredients();

        assertEquals(3, ingredients.size());
        assertTrue(ingredients.contains(new Ingredient("Brioche", 2.5)));
        assertTrue(ingredients.contains(new Ingredient("Res", 5.0)));
        assertTrue(ingredients.contains(new Ingredient("Cheddar", 1.0)));
    }

    /**
     * El test valida que calculatePrice() sume correctamente.
     */
    @Test
    void calculatePriceDebeSumarCorrectamenteConStreams() {
        Burger burger = new BurgerBuilder()
                .withBread("Brioche", 2.5)
                .withMeat("Res", 5.0)
                .addIngredient("Cheddar", 1.0)
                .build();

        assertEquals(8.5, burger.calculatePrice(), 0.001);
    }
}