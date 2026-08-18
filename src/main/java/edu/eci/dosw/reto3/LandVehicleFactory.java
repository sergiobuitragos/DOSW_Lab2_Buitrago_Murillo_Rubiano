package edu.eci.dosw.reto3;

import java.util.Map;

/**
 * Creates land vehicles (car, bicycle, motorcycle)
 * from a table of specifications by category and model
 */
public final class LandVehicleFactory implements VehicleFactory {

    private static final Map<String, Map<String, VehicleSpec>> SPECS = Map.of(
            "economy", Map.of(
                    "car", new VehicleSpec(160, 45_000_000, "radio and parking sensors"),
                    "bicycle", new VehicleSpec(40, 1_500_000, "LED lights"),
                    "motorcycle", new VehicleSpec(140, 18_000_000, "Digital table")
            ),
            "luxury", Map.of(
                    "car", new VehicleSpec(220, 120_000_000, "GPS, 360 camera and leather sits"),
                    "bicycle", new VehicleSpec(50, 6_000_000, "Carbon fiber and electronic system"),
                    "motorcycle", new VehicleSpec(220, 85_000_000, "Digital display and GPS")
            ),
            "used", Map.of(
                    "car", new VehicleSpec(170, 30_000_000, "Radio and parking sensors"),
                    "bicycle", new VehicleSpec(35, 800_000, "LED lights"),
                    "motorcycle", new VehicleSpec(130, 12_000_000, "Rear trunk")
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
            throw new IllegalArgumentException("Land model not available: " + model);
        }
        return new LandVehicle(category, model, spec.maxSpeed(), spec.price(), spec.equipment());
    }
}
