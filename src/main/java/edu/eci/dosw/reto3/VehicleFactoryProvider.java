package edu.eci.dosw.reto3;

import java.util.Map;

/**
 * Selecciona la factory correspondiente según la familia solicitada.
 * Punto único de entrada para crear cualquier vehículo del catálogo.
 */
public final class VehicleFactoryProvider {

    private static final Map<String, VehicleFactory> FACTORIES = Map.of(
            "land", new LandVehicleFactory(),
            "water", new WaterVehicleFactory(),
            "air", new AirVehicleFactory()
    );

    private VehicleFactoryProvider() {
    }

    public static Vehicle createVehicle(String family, String category, String model) {
        VehicleFactory factory = FACTORIES.get(family.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("Vehicle family not available: " + family);
        }
        return factory.createVehicle(category, model);
    }
}