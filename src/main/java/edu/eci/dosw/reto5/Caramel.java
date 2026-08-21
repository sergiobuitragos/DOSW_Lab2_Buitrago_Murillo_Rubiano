package edu.eci.dosw.reto5;
/**
 * es la clase caramelo como ingrediente
 */
public final class Caramel extends Topping {

    public Caramel(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "+ Caramel";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 1200;
    }
}
