package edu.eci.dosw.reto8;

/**
 * es la clase del reptil
 */
public class Reptile extends Animal {

    public Reptile(
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
