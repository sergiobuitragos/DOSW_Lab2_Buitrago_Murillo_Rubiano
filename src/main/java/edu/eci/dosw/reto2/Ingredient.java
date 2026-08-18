package edu.eci.dosw.reto2;

import java.util.Objects;

/**
 * Represents an ingredient that can be added to a burger (bread, meat, cheese, etc)
 * Imutable, once created, its name and price don't change
 */
public final class Ingredient {
    private final String name;
    private final double price;

    public Ingredient(String name, double price){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Ingredient name cannot be null or blank");    
        }
        if(price < 0){
            throw new IllegalArgumentException("Ingredient price cannot be negative");
        }

        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(price, that.price) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
