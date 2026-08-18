package edu.eci.dosw.reto5;
/**
 * es la clase chocolate como ingrediente
 */
public class Chocolate implements Ingredient {

    @Override
    public String getName() {
        return "Chocolate";
    }

    @Override
    public double getPrice() {
        return 1500;
    }
}
