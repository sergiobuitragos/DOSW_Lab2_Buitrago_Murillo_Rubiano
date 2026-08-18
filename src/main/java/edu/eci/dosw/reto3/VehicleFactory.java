package edu.eci.dosw.reto3;

/**
 * Factory crea un vehículo según la familia, categoría y modelo seleccionado
 */
public class VehicleFactory {

    /**
     * crea el vehiculo segun la familia, categoria y modelo
     *
     * @param family
     * @param category
     * @param model
     * @return
     */
    public static Vehicle createVehicle(
            String family,
            String category,
            String model) {

        switch (family.toLowerCase()) {

            case "terrestre":
                return createLandVehicle(category, model);

            case "acuatico":
                return createWaterVehicle(category, model);

            case "aereo":
                return createAirVehicle(category, model);

            default:
                throw new IllegalArgumentException(
                        "Familia de vehículo no disponible");
        }
    }

    /**
     * Crea un vehiculo terrestre
     */
    private static Vehicle createLandVehicle(
            String category,
            String model) {

        switch (category.toLowerCase()) {

            case "economia":
                return createEconomyLandVehicle(model);

            case "lujo":
                return createLuxuryLandVehicle(model);

            case "usado":
                return createUsedLandVehicle(model);

            default:
                throw new IllegalArgumentException(
                        "Categoría no disponible");
        }
    }

    /**
     * Crea un vehiculo acuatico
     */
    private static Vehicle createWaterVehicle(
            String category,
            String model) {

        switch (category.toLowerCase()) {

            case "economia":
                return createEconomyWaterVehicle(model);

            case "lujo":
                return createLuxuryWaterVehicle(model);

            case "usado":
                return createUsedWaterVehicle(model);

            default:
                throw new IllegalArgumentException(
                        "Categoría no disponible");
        }
    }

    /**
     * Crea un vehiculo aereo
     */
    private static Vehicle createAirVehicle(
            String category,
            String model) {

        switch (category.toLowerCase()) {

            case "economia":
                return createEconomyAirVehicle(model);

            case "lujo":
                return createLuxuryAirVehicle(model);

            case "usado":
                return createUsedAirVehicle(model);

            default:
                throw new IllegalArgumentException(
                        "Categoría no disponible");
        }
    }

    
}