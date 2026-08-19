package edu.eci.dosw.reto5;

/**
 * Base coffe, witohut any topping added
 * NormalCoffee
 */
public class NormalCoffee implements Coffee{
    private final String base;
    private final double price;

    public NormalCoffee(String base, double price){
        if(base == null || base.isBlank()){
            throw new IllegalArgumentException("Base cannot be null or empty");
        }
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.base = base;
        this.price = price;
    }

    @Override
    public String getDescription(){
        return base;
    }

    @Override
    public double getPrice(){
        return price;
    }
}
