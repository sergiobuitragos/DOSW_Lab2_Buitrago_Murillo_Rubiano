package edu.eci.dosw.reto2;

public final class Reto2 {

    private Reto2() {
    }

    public static void run() {
        System.out.println("Running Challenge 2 — The Five-Star Chef...");

        Burger burger = new BurgerBuilder()
                .withBread("Pan brioche", 1500)
                .withMeat("Carne de res", 8000)
                .addIngredient("Queso cheddar", 2000)
                .addIngredient("Tocineta", 2500)
                .build();

        burger.showSummary();
    }
}
