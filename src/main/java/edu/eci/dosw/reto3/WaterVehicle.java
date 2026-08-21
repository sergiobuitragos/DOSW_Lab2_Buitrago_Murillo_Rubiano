package edu.eci.dosw.reto3;

public final class WaterVehicle extends Vehicle {
    public WaterVehicle(String category, String model, double maxSpeed, double price, String equipment) {
        super(category, model, maxSpeed, price, equipment);
    }
    
    @Override
    public String getFamily(){
        return "Water Vehicle";
    }
    
}
