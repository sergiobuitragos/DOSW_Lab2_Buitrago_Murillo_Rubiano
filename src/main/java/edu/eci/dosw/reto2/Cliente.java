package edu.eci.dosw.reto2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Client-side entry point for the burger ordering system.
 *
 * This class allows the user to build a customized burger by selecting items
 * from predefined catalogs for bread, meat, and optional extras. The user
 * chooses the product names, while the prices are retrieved from the catalog.
 */
public class Cliente {

    /**
     * Available bread options and their prices.
     */
    private static final Map<String, Double> BREADS = new LinkedHashMap<>();

    /**
     * Available meat options and their prices.
     */
    private static final Map<String, Double> MEATS = new LinkedHashMap<>();

    /**
     * Available optional extras and their prices.
     */
    private static final Map<String, Double> EXTRAS = new LinkedHashMap<>();

    static {
        BREADS.put("Brioche", 2.5);
        BREADS.put("Integral", 2.8);

        MEATS.put("Res", 5.0);
        MEATS.put("Pollo", 4.5);

        EXTRAS.put("Cheddar", 1.0);
        EXTRAS.put("Lechuga", 0.5);
        EXTRAS.put("Tomate", 0.5);
        EXTRAS.put("BBQ", 0.8);
    }

    /**
     * Runs the interactive burger customization flow.
     *
     * @param args command-line arguments; not used in this application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BurgerBuilder builder = new BurgerBuilder();

        System.out.println("*****Five-Star Chef: build your burger*****");

        String breadName = elegirDeCatalogo(scanner, "Choose the bread:", BREADS);
        builder.withBread(breadName, BREADS.get(breadName));

        String meatName = elegirDeCatalogo(scanner, "Choose the meat:", MEATS);
        builder.withMeat(meatName, MEATS.get(meatName));

        System.out.println("\nAdd optional ingredients (type 'fin' to finish):");
        String option;
        do {
            mostrarCatalogo(EXTRAS);
            System.out.print("Option (or 'fin'): ");
            option = scanner.nextLine().trim();

            if (!option.equalsIgnoreCase("fin")) {
                String name = obtenerPorIndice(EXTRAS, option);
                if (name != null) {
                    builder.addIngredient(name, EXTRAS.get(name));
                } else {
                    System.out.println("Invalid option, please try again.");
                }
            }
        } while (!option.equalsIgnoreCase("fin"));

        Burger burger = builder.build();
        burger.showSummary();

        scanner.close();
    }

    /**
     * Displays a numbered catalog and returns the selected item name.
     * The method keeps prompting until the user chooses a valid option.
     *
     * @param scanner the input source used to read the user's selection
     * @param title   the label shown before the catalog
     * @param catalog the available options and their prices
     * @return the selected ingredient name
     */
    private static String elegirDeCatalogo(Scanner scanner, String title, Map<String, Double> catalog) {
        String name = null;
        while (name == null) {
            System.out.println("\n" + title);
            mostrarCatalogo(catalog);
            System.out.print("Option: ");
            String option = scanner.nextLine().trim();
            name = obtenerPorIndice(catalog, option);
            if (name == null) {
                System.out.println("Invalid option, please try again.");
            }
        }
        return name;
    }

    /**
     * Prints a catalog in numbered format.
     *
     * @param catalog the available ingredients and prices
     */
    private static void mostrarCatalogo(Map<String, Double> catalog) {
        int i = 1;
        for (Map.Entry<String, Double> entry : catalog.entrySet()) {
            System.out.printf("  %d. %s ($%.2f)%n", i, entry.getKey(), entry.getValue());
            i++;
        }
    }

    /**
     * Returns the ingredient name associated with a 1-based index.
     *
     * @param catalog   the catalog to search
     * @param indexText the text entered by the user
     * @return the corresponding item name, or null if the index is invalid
     */
    private static String obtenerPorIndice(Map<String, Double> catalog, String indexText) {
        try {
            int index = Integer.parseInt(indexText);
            int i = 1;
            for (String name : catalog.keySet()) {
                if (i == index) {
                    return name;
                }
                i++;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }
}