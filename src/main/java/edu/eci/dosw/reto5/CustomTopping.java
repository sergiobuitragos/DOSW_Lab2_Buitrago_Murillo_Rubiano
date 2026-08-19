package edu.eci.dosw.reto5;

/**
 * clase que representa el ingrediente escogido
 */
public class CustomTopping extends Topping {

    private final String name;
    private final double price;

    /**
     * crea un ingrediente
     * @param name
     * @param price
     */
    public CustomTopping(Coffee coffee, String name, double price) {
        super(coffee);
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be null, please choose a name");
        }

        if (price < 0) {
            throw new IllegalArgumentException(
                    "Price cannot be negative");
        }

        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " + " + name;
    }

    @Override
    public double getPrice() {
        return coffee.getPrice() + price;
    }
}
