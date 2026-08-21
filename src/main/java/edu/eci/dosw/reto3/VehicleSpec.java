package edu.eci.dosw.reto3;

/**
 * immutable records of a vehicle specification, containing the maximum speed, price, and special equipment of the vehicle.
 */
public record VehicleSpec(double maxSpeed, double price, String equipment) {
    
}
