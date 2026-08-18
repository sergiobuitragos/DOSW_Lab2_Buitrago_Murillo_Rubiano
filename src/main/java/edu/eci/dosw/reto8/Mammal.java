package edu.eci.dosw.reto8;

/**
 * Representa un mamifero.
 */
public class Mammal extends Animal {

    public Mammal(
            String name,
            int age,
            String characteristicSound,
            String diet,
            String favoriteFood,
            double weight,
            double height,
            HealthStatus healthStatus,
            String habitat) {

        super(
                name,
                age,
                characteristicSound,
                diet,
                favoriteFood,
                weight,
                height,
                healthStatus,
                habitat);
    }

    @Override
    public void makeSound() {
        System.out.println(
                getName() + " emite: " + getCharacteristicSound());
    }
}
