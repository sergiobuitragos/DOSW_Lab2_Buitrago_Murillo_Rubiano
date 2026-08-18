package edu.eci.dosw.reto8;

/**
 * 
 */
public class Bird extends Animal {

    public Bird(
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
