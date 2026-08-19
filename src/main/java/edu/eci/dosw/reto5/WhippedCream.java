package edu.eci.dosw.reto5;

/**
 * es la clase crema batida como ingrediente
 */
public final class WhippedCream extends Topping {

    public WhippedCream(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + "+ Whipped Cream";
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + 2000;
    }
}
