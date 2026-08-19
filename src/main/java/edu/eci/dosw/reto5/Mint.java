package edu.eci.dosw.reto5;

/**
 * es la clase menta como ingrediente
 */
public final class Mint extends Topping {

    public Mint(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "+ Mint";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 1300;
    }
}
