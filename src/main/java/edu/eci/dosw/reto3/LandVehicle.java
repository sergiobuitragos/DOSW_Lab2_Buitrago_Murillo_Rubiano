package edu.eci.dosw.reto3;

public final class LandVehicle extends Vehicle {
    public LandVehicle(String category, String model, double maxSpeed, double price, String equipment) {
        super(category, model, maxSpeed, price, equipment);
    }
    
    @Override
    public String getFamily(){
        return "Land Vehicle";
    }
}
