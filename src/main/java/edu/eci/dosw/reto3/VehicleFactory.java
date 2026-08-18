package edu.eci.dosw.reto3;

/**
 * Factory crea un vehículo según la familia, categoria y modelo seleccionado
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
                        "Categoria no disponible");
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
                        "Categoria no disponible");
        }
    }
private static Vehicle createEconomyLandVehicle(String model) {
        switch (model.toLowerCase()) {
            case "coche":
                return new Vehicle(
                        "Terrestre",
                        "Economia",
                        "Coche",
                        160,
                        45000000,
                        "Radio y aire acondicionado");

            case "bicicleta":
                return new Vehicle(
                        "Terrestre",
                        "Economia",
                        "Bicicleta",
                        40,
                        1500000,
                        "Luces LED");

            case "motocicleta":
                return new Vehicle(
                        "Terrestre",
                        "Economia",
                        "Motocicleta",
                        140,
                        18000000,
                        "Tablero digital");

            default:
                throw new IllegalArgumentException(
                        "Modelo terrestre no disponible");
        }
    }

    private static Vehicle createLuxuryLandVehicle(String model) {

        switch (model.toLowerCase()) {

            case "coche":
                return new Vehicle(
                        "Terrestre",
                        "Lujo",
                        "Coche",
                        220,
                        120000000,
                        "GPS, camara 360 y asientos de cuero");

            case "bicicleta":
                return new Vehicle(
                        "Terrestre",
                        "Lujo",
                        "Bicicleta",
                        50,
                        6000000,
                        "Fibra de carbono y sistema electronico");

            case "motocicleta":
                return new Vehicle(
                        "Terrestre",
                        "Lujo",
                        "Motocicleta",
                        220,
                        85000000,
                        "Pantalla digital y GPS");

            default:
                throw new IllegalArgumentException(
                        "Modelo terrestre no disponible");
        }
    }

    private static Vehicle createUsedLandVehicle(String model) {

        switch (model.toLowerCase()) {

            case "coche":
                return new Vehicle(
                        "Terrestre",
                        "Usado",
                        "Coche",
                        170,
                        30000000,
                        "Radio y sensores de parqueo");

            case "bicicleta":
                return new Vehicle(
                        "Terrestre",
                        "Usado",
                        "Bicicleta",
                        35,
                        800000,
                        "Luces LED");

            case "motocicleta":
                return new Vehicle(
                        "Terrestre",
                        "Usado",
                        "Motocicleta",
                        130,
                        12000000,
                        "Baul trasero");

            default:
                throw new IllegalArgumentException(
                        "Modelo terrestre no disponible");
        }
    }

    private static Vehicle createEconomyWaterVehicle(String model) {

        switch (model.toLowerCase()) {

            case "lancha":
                return new Vehicle(
                        "Acuatico",
                        "Economia",
                        "Lancha motora",
                        70,
                        80000000,
                        "GPS y chalecos salvavidas");

            case "velero":
                return new Vehicle(
                        "Acuatico",
                        "Economia",
                        "Velero",
                        30,
                        65000000,
                        "Brujula y radio");

            case "moto acuatica":
                return new Vehicle(
                        "Acuatico",
                        "Economia",
                        "Moto acuatica",
                        80,
                        55000000,
                        "Sistema de seguridad");

            default:
                throw new IllegalArgumentException(
                        "Modelo acuatico no disponible");
        }
    }

    private static Vehicle createLuxuryWaterVehicle(String model) {

        switch (model.toLowerCase()) {

            case "lancha":
                return new Vehicle(
                        "Acuatico",
                        "Lujo",
                        "Lancha motora",
                        100,
                        250000000,
                        "GPS, sonido premium y camarote");

            case "velero":
                return new Vehicle(
                        "Acuatico",
                        "Lujo",
                        "Velero",
                        45,
                        180000000,
                        "GPS, radar y sistema de navegación");

            case "moto acuatica":
                return new Vehicle(
                        "Acuatico",
                        "Lujo",
                        "Moto acuatica",
                        110,
                        95000000,
                        "GPS y sistema de navegación");

            default:
                throw new IllegalArgumentException(
                        "Modelo acuatico no disponible");
        }
    }

    private static Vehicle createUsedWaterVehicle(String model) {

        switch (model.toLowerCase()) {

            case "lancha":
                return new Vehicle(
                        "Acuatico",
                        "Usado",
                        "Lancha motora",
                        60,
                        50000000,
                        "GPS y radio");

            case "velero":
                return new Vehicle(
                        "Acuatico",
                        "Usado",
                        "Velero",
                        25,
                        40000000,
                        "Brujula");

            case "moto acuatica":
                return new Vehicle(
                        "Acuatico",
                        "Usado",
                        "Moto acuatica",
                        70,
                        35000000,
                        "Sistema de seguridad");

            default:
                throw new IllegalArgumentException(
                        "Modelo acuatico no disponible");
        }
    }

    private static Vehicle createEconomyAirVehicle(String model) {

        switch (model.toLowerCase()) {

            case "avion":
                return new Vehicle(
                        "Aereo",
                        "Economia",
                        "Avión",
                        850,
                        500000000,
                        "Sistema de navegación");

            case "avion ligero":
                return new Vehicle(
                        "Aereo",
                        "Economia",
                        "Avión ligero",
                        500,
                        250000000,
                        "GPS aeronáutico");

            case "helicoptero":
                return new Vehicle(
                        "Aereo",
                        "Economia",
                        "Helicóptero",
                        280,
                        350000000,
                        "Sistema de navegación");

            default:
                throw new IllegalArgumentException(
                        "Modelo aereo no disponible");
        }
    }

    private static Vehicle createLuxuryAirVehicle(String model) {

        switch (model.toLowerCase()) {

            case "avion":
                return new Vehicle(
                        "Aereo",
                        "Lujo",
                        "Avión",
                        950,
                        2500000000.0,
                        "Cabina premium y sistema de navegacion");

            case "avion ligero":
                return new Vehicle(
                        "Aereo",
                        "Lujo",
                        "Avión ligero",
                        550,
                        600000000,
                        "GPS y cabina premium");

            case "helicoptero":
                return new Vehicle(
                        "Aereo",
                        "Lujo",
                        "Helicóptero",
                        320,
                        800000000,
                        "GPS, piloto automático y cabina premium");

            default:
                throw new IllegalArgumentException(
                        "Modelo aereo no disponible");
        }
    }

    private static Vehicle createUsedAirVehicle(String model) {

        switch (model.toLowerCase()) {

            case "avion":
                return new Vehicle(
                        "Aereo",
                        "Usado",
                        "Avión",
                        800,
                        300000000,
                        "Sistema de navegación");

            case "avion ligero":
                return new Vehicle(
                        "Aereo",
                        "Usado",
                        "Avión ligero",
                        450,
                        150000000,
                        "GPS aeronautico");

            case "helicoptero":
                return new Vehicle(
                        "Aereo",
                        "Usado",
                        "Helicóptero",
                        250,
                        200000000,
                        "Sistema de navegacion");

            default:
                throw new IllegalArgumentException(
                        "Modelo aereo no disponible");
        }
    }
    
}