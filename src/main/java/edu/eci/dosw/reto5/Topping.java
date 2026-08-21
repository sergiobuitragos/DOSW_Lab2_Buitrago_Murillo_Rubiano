package edu.eci.dosw.reto5;

public abstract class Topping implements Coffee{
    protected final Coffee coffee;

    protected Topping(Coffee coffee){
        if(coffee == null){
            throw new IllegalArgumentException("Coffe to be decorated cannot be null");
        }

        this.coffee = coffee;
    }
    
}
