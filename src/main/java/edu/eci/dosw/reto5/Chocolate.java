package edu.eci.dosw.reto5;
/**
 * es la clase chocolate como ingrediente
 */
public final class Chocolate extends Topping {

    public Chocolate(Coffee coffee){
        super(coffee);
    }
    
    @Override
    public String getDescription() {
        return coffee.getDescription() + "+ Chocolate";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 1500;
    }
}
