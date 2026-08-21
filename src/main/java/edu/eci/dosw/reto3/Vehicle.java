package edu.eci.dosw.reto3;

/**
 * Represents a vehicle of the catalog. Abstract class: each family provides its own subclass.
 */
public abstract class Vehicle{
    private final String category;
    private final String model;
    private final double maxSpeed;
    private final double price;
    private final String equipment;

    protected Vehicle(String category, String model, double maxSpeed, double price, String equipment) {
        this.category = category;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.equipment = equipment;
    }

    public abstract String getFamily();

    public String getModel(){
        return model;
    }

    public String getCategory(){
        return category;
    }

    public double getMaxSpeed(){
        return maxSpeed;
    }

    public double getPrice(){
        return price;
    }

    public String getEquipment(){
        return equipment;
    }

    public void showInfo(){
        System.out.println("Type: " + getFamily());
        System.out.println("Category: " + category);
        System.out.println("Model: " + model);
        System.out.println("Maximum Speed: " + maxSpeed + " km/h");
        System.out.println("Price: $" + price);
        System.out.println("Special Equipment: " + equipment);
    }
}
