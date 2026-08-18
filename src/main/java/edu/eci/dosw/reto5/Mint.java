package edu.eci.dosw.reto5;

/**
 * es la clase menta como ingrediente
 */
public class Mint implements Ingredient {

    @Override
    public String getName() {
        return "Menta";
    }

    @Override
    public double getPrice() {
        return 1300;
    }
}
