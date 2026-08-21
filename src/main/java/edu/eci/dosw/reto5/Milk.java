package edu.eci.dosw.reto5;

/**
 * es la clase leche como ingrediente
 */
public final class Milk extends Topping {

    public Milk(Coffee coffee){
        super(coffee);
    }
    
    @Override
    public String getDescription(){
        return coffee.getDescription() + "+ Milk";
    } 

    @Override
    public double getPrice(){
        return coffee.getPrice() + 1000;
    }
}
