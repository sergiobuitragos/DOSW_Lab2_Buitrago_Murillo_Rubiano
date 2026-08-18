package edu.eci.dosw.reto5;
/**
 * es la clase caramelo como ingrediente
 */
public class Caramel implements Ingredient {

    @Override
    public String getName() {
        return "Caramelo";
    }

    @Override
    public double getPrice() {
        return 1200;
    }
}
