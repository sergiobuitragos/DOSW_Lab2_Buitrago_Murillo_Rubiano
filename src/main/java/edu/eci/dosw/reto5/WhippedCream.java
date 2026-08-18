package edu.eci.dosw.reto5;

/**
 * es la clase crema batida como ingrediente
 */
public class WhippedCream implements Ingredient {

    @Override
    public String getName() {
        return "Crema batida";
    }

    @Override
    public double getPrice() {
        return 2000;
    }
}
