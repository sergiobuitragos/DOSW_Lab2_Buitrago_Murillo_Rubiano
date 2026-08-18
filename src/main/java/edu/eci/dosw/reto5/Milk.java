package edu.eci.dosw.reto5;

/**
 * es la clase leche como ingrediente
 */
public class Milk implements Ingredient {

    @Override
    public String getName() {
        return "Leche";
    }

    @Override
    public double getPrice() {
        return 1000;
    }
}
