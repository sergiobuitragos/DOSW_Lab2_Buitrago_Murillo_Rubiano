package edu.eci.dosw.reto5;

/**
 * clase que representa el ingrediente escogido
 */
public class CustomIngredient implements Ingredient {

    private final String name;
    private final double price;

    /**
     * crea un ingrediente
     * @param name
     * @param price
     */
    public CustomIngredient(String name, double price) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacio,escoge uno");
        }

        if (price < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo");
        }

        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
