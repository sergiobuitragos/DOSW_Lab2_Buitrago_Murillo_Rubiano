package edu.eci.dosw.reto3;

/**
 * tiene la informacion de los vehiculos
 * familia, precio, etc
 */
public class Vehicle {

    private final String family;
    private final String category;
    private final String model;
    private final double maxSpeed;
    private final double price;
    private final String specialEquipment;

    /**
     * construye un vehiculo con la informacion dada
     *
     * @param family
     * @param category
     * @param model
     * @param maxSpeed
     * @param price
     * @param specialEquipment
     */
    public Vehicle(
            String family,
            String category,
            String model,
            double maxSpeed,
            double price,
            String specialEquipment) {

        this.family = family;
        this.category = category;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.specialEquipment = specialEquipment;
    }

    /**
     * Nos da la familia del vehiculo
     * @return
     */
    public String getFamily() {
        return family;
    }

    /**
     * nos da la categoria
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * nos da el modelo
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * nos da la velocidad
     *
     * @return
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * nos da el precio
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * nos da el equipo especial
     *
     * @return
     */
    public String getSpecialEquipment() {
        return specialEquipment;
    }

    /**
     * muestra la info
     */
    public void showInfo() {
        System.out.println("Tipo: " + family);
        System.out.println("Categoría: " + category);
        System.out.println("Modelo: " + model);
        System.out.println("Velocidad máxima: " + maxSpeed + " km/h");
        System.out.println("Precio: $" + price);
        System.out.println("Equipo especial: " + specialEquipment);
    }
}
