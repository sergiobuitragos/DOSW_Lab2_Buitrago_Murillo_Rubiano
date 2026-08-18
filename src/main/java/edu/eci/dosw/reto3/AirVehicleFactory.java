package edu.eci.dosw.reto3;

import java.util.Map;

/**
 * Crea vehículos aéreos (avión, avión ligero, helicóptero)
 * a partir de una tabla de especificaciones por categoría y modelo.
 */
public final class AirVehicleFactory implements VehicleFactory {

    private static final Map<String, Map<String, VehicleSpec>> SPECS = Map.of(
            "economy", Map.of(
                    "plane", new VehicleSpec(850, 500_000_000, "Navigation system"),
                    "light aircraft", new VehicleSpec(500, 250_000_000, "Aviation GPS"),
                    "helicopter", new VehicleSpec(280, 350_000_000, "Navigation system")
            ),
            "luxury", Map.of(
                    "plane", new VehicleSpec(950, 2_500_000_000.0, "Premium cabin and navigation system"),
                    "light aircraft", new VehicleSpec(550, 600_000_000, "GPS and premium cabin"),
                    "helicopter", new VehicleSpec(320, 800_000_000, "GPS, autopilot and premium cabin")
            ),
            "used", Map.of(
                    "plane", new VehicleSpec(800, 300_000_000, "Navigation system"),
                    "light aircraft", new VehicleSpec(450, 150_000_000, "Aviation GPS"),
                    "helicopter", new VehicleSpec(250, 200_000_000, "Navigation system")
            )
    );

    @Override
    public Vehicle createVehicle(String category, String model) {
        Map<String, VehicleSpec> models = SPECS.get(category.toLowerCase());
        if (models == null) {
            throw new IllegalArgumentException("Category not available: " + category);
        }
        VehicleSpec spec = models.get(model.toLowerCase());
        if (spec == null) {
            throw new IllegalArgumentException("Air model not available: " + model);
        }
        return new AirVehicle(category, model, spec.maxSpeed(), spec.price(), spec.equipment());
    }
}
