package edu.eci.dosw.reto5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Entry point for the coffee customization application.
 *
 * This class allows the user to create multiple coffees in a single execution,
 * add any number of toppings to each one, and display the final description and
 * total price for every coffee.
 */
public final class Main {

    /**
     * Utility class constructor to prevent instantiation.
     */
    private Main() {
        // Startup class; not intended to be instantiated
    }

    /**
     * Starts the interactive coffee ordering flow.
     *
     * @param args command-line arguments; not used by the application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Coffee> coffees = new ArrayList<>();

        System.out.print("How many coffees would you like to create? ");
        int totalCoffees = readPositiveInt(scanner);

        for (int i = 1; i <= totalCoffees; i++) {
            System.out.println("\n--- Coffee #" + i + " ---");
            Coffee coffee = buildBaseCoffee(scanner);
            coffee = addToppings(scanner, coffee);
            coffees.add(coffee);
        }

        showCoffees(coffees);

        scanner.close();
    }

    /**
     * Displays the predefined base coffee menu and returns the selected option.
     *
     * @param scanner input source for reading the user's choice
     * @return a coffee instance with the selected base drink and fixed price
     */
    private static Coffee buildBaseCoffee(Scanner scanner) {
        System.out.println("Choose the base coffee:");
        System.out.println("1. Espresso (COP 2500)");
        System.out.println("2. Americano (COP 3000)");
        System.out.println("3. Cappuccino (COP 5000)");
        System.out.println("4. Caramel Cappuccino (COP 5500)");
        System.out.println("5. Latte (COP 4000)");
        System.out.print("Option: ");

        int option = readIntInRange(scanner, 1, 5);

        switch (option) {
            case 1:
                return new NormalCoffee("Espresso", 2500);
            case 2:
                return new NormalCoffee("Americano", 3000);
            case 3:
                return new NormalCoffee("Capuchino", 5000);
            case 4:
                return new NormalCoffee("Capuchino de caramelo", 5500);
            case 5:
                return new NormalCoffee("Latte", 4000);
            default:
                // Unreachable: readIntInRange guarantees values between 1 and 5
                throw new IllegalStateException("Invalid base coffee option");
        }
    }

    /**
     * Shows the topping menu and allows the user to wrap the coffee with multiple
     * toppings. Repeated toppings are allowed, creating layered ingredients.
     *
     * @param scanner input source for reading topping selections
     * @param coffee  the current coffee being decorated
     * @return the coffee after all selected toppings have been applied
     */
    private static Coffee addToppings(Scanner scanner, Coffee coffee) {
        boolean addingToppings = true;

        while (addingToppings) {
            System.out.println("Add topping? (0 to finish)");
            System.out.println("1. Milk (COP 1000)");
            System.out.println("2. Chocolate (COP 1500)");
            System.out.println("3. Caramel (COP 1200)");
            System.out.println("4. Whipped Cream (COP 2000)");
            System.out.println("5. Mint (COP 1300)");
            System.out.println("6. Custom Topping");
            System.out.print("Option: ");

            int option = readIntInRange(scanner, 0, 6);

            switch (option) {
                case 0:
                    addingToppings = false;
                    break;
                case 1:
                    coffee = new Milk(coffee);
                    break;
                case 2:
                    coffee = new Chocolate(coffee);
                    break;
                case 3:
                    coffee = new Caramel(coffee);
                    break;
                case 4:
                    coffee = new WhippedCream(coffee);
                    break;
                case 5:
                    coffee = new Mint(coffee);
                    break;
                case 6:
                    coffee = buildCustomTopping(scanner, coffee);
                    break;
                default:
                    // Unreachable: readIntInRange guarantees values between 0 and 6
                    break;
            }
        }

        return coffee;
    }

    /**
     * Creates a custom topping using the name and price entered by the user.
     *
     * @param scanner input source for reading the topping data
     * @param coffee  the coffee to decorate
     * @return the updated coffee after adding the custom topping
     */
    private static Coffee buildCustomTopping(Scanner scanner, Coffee coffee) {
        System.out.print("Custom topping name: ");
        String name = scanner.nextLine();

        System.out.print("Custom topping price (COP): ");
        double price = readNonNegativeDouble(scanner);

        return new CustomTopping(coffee, name, price);
    }

    /**
     * Displays the final summary for all coffees created in the current session.
     * Each coffee is shown with its description, individual total, and the
     * combined total across the whole order.
     *
     * @param coffees the coffees produced during the session
     */
    private static void showCoffees(List<Coffee> coffees) {
        System.out.println("\n*****Coffee summary*****");

        List<Double> totalsPerCoffee = coffees.stream()
                .map(Coffee::getPrice)
                .collect(Collectors.toList());

        for (int i = 0; i < coffees.size(); i++) {
            System.out.printf("Coffee #%d: %s -> COP %.2f%n",
                    i + 1, coffees.get(i).getDescription(), totalsPerCoffee.get(i));
        }

        double grandTotal = coffees.stream()
                .collect(Collectors.summingDouble(Coffee::getPrice));

        System.out.printf("Total for all coffees: COP %.2f%n", grandTotal);
    }

    /**
     * Reads a positive integer value from the console.
     *
     * @param scanner input source for reading the value
     * @return a positive integer greater than zero
     */
    private static int readPositiveInt(Scanner scanner) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.print("It must be a number greater than 0. Please try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    /**
     * Reads an integer value within the specified range.
     *
     * @param scanner input source for reading the value
     * @param min     minimum allowed value
     * @param max     maximum allowed value
     * @return an integer inside the valid range
     */
    private static int readIntInRange(Scanner scanner, int min, int max) {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("It must be between %d and %d. Please try again: %n", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    /**
     * Reads a non-negative numeric value.
     *
     * @param scanner input source for reading the value
     * @return a non-negative number
     */
    private static double readNonNegativeDouble(Scanner scanner) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.print("It must be a non-negative number. Please try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}