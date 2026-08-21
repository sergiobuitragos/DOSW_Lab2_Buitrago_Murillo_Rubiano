package edu.eci.dosw.reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a dealership workflow that guides the user through the selection
 * process of a vehicle using a predefined menu flow: family -> category ->
 * model.
 * The user can add multiple vehicles in the same session.
 */
public final class Dealership {

    /**
     * Supported vehicle families.
     */
    private static final String[] FAMILIES = { "land", "water", "air" };

    /**
     * Available vehicle categories.
     */
    private static final String[] CATEGORIES = { "economy", "luxury", "used" };

    /**
     * Maps each vehicle family to the models that belong to it.
     */
    private static final Map<String, String[]> MODELS_BY_FAMILY = Map.of(
            "land", new String[] { "car", "bicycle", "motorcycle" },
            "water", new String[] { "boat", "sailboat", "jet ski" },
            "air", new String[] { "plane", "light aircraft", "helicopter" });

    /**
     * The list of vehicles selected by the user during the current session.
     */
    private final List<Vehicle> selectedVehicles = new ArrayList<>();

    /**
     * Input source used to interact with the user.
     */
    private final Scanner scanner;

    /**
     * Creates a new dealership flow using the provided scanner.
     *
     * @param scanner the input object used for menu choices and confirmations
     */
    public Dealership(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Returns the vehicles selected by the user.
     *
     * @return the list of chosen vehicles
     */
    public List<Vehicle> getSelectedVehicles() {
        return selectedVehicles;
    }

    /**
     * Starts the interactive process of adding vehicles until the user decides to
     * stop.
     */
    public void run() {
        boolean addMore = true;
        while (addMore) {
            addVehicleFromUserInput();
            addMore = askYesNo("Do you want to add another vehicle? (s/n): ");
        }
    }

    /**
     * Prompts the user for a vehicle family, category, and model, then creates
     * the corresponding vehicle instance through the factory provider.
     */
    private void addVehicleFromUserInput() {
        Vehicle vehicle = null;
        while (vehicle == null) {
            String family = selectFromMenu("Vehicle family", FAMILIES);
            String category = selectFromMenu("Category", CATEGORIES);
            String model = selectFromMenu("Model", MODELS_BY_FAMILY.get(family));

            try {
                vehicle = VehicleFactoryProvider.createVehicle(family, category, model);
            } catch (IllegalArgumentException e) {
                System.out.println("Error creating the vehicle: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
        selectedVehicles.add(vehicle);
        System.out.println("Vehicle added successfully.\n");
    }

    /**
     * Displays a numbered menu and waits until the user selects a valid option.
     *
     * @param title   the menu title
     * @param options the list of valid choices
     * @return the selected option string
     */
    private String selectFromMenu(String title, String[] options) {
        System.out.println(title + ":");
        for (int i = 0; i < options.length; i++) {
            System.out.println("  " + (i + 1) + ". " + options[i]);
        }

        int choice = -1;
        while (choice < 1 || choice > options.length) {
            System.out.print("Select an option (1-" + options.length + "): ");
            String input = scanner.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid option, please try again.");
            }
        }
        return options[choice - 1];
    }

    /**
     * Prompts the user for a yes/no answer and returns the corresponding boolean.
     *
     * @param prompt the confirmation message shown to the user
     * @return true when the user answers yes, false otherwise
     */
    private boolean askYesNo(String prompt) {
        System.out.print(prompt);
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("s") || answer.equals("si");
    }
}