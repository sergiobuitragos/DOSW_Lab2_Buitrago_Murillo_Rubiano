package edu.eci.dosw.reto3;

import java.util.Map;

/**
 * Crea vehículos acuáticos (lancha, velero, moto acuática)
 * a partir de una tabla de especificaciones por categoría y modelo.
 */
public final class WaterVehicleFactory implements VehicleFactory {

    private static final Map<String, Map<String, VehicleSpec>> SPECS = Map.of(
            "economy", Map.of(
                    "boat", new VehicleSpec(70, 80_000_000, "GPS and life jackets"),
                    "sailboat", new VehicleSpec(30, 65_000_000, "compass and radio"),
                    "jet ski", new VehicleSpec(80, 55_000_000, "Security system")
            ),
            "luxury", Map.of(
                    "boat", new VehicleSpec(100, 250_000_000, "GPS, premium sound and cabin"),
                    "sailboat", new VehicleSpec(45, 180_000_000, "GPS, radar and navigation system"),
                    "jet ski", new VehicleSpec(110, 95_000_000, "GPS and navigation system")
            ),
            "used", Map.of(
                    "boat", new VehicleSpec(60, 50_000_000, "GPS and radio"),
                    "sailboat", new VehicleSpec(25, 40_000_000, "Compass"),
                    "jet ski", new VehicleSpec(70, 35_000_000, "Security system")
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
            throw new IllegalArgumentException("Water model not available: " + model);
        }
        return new WaterVehicle(category, model, spec.maxSpeed(), spec.price(), spec.equipment());
    }
}