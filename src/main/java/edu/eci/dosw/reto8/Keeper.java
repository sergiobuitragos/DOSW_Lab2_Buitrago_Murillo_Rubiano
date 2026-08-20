package edu.eci.dosw.reto8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a Zoo Keeper, asociated to 1 or more animals
 */
public final class Keeper {
    private final String name;
    private final int age;
    private final String specialty;
    private final List<Animal> animals = new ArrayList<>();

    public Keeper(String name, int age, String specialty){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null");
        }
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if(specialty == null || specialty.isBlank()){
            throw new IllegalArgumentException("Specialty cannot be null");
        }

        this.name = name;
        this.age = age;
        this.specialty = specialty;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getSpecialty(){
        return specialty;
    }

    /**
     * Matches an animal to the keeper
     */
    public void assignAnimal(Animal animal){
        if(animal == null){
            throw new IllegalArgumentException("Animal cannot be null");
        }
        animals.add(animal);
    }

    public List<Animal> getAnimals(){
        return Collections.unmodifiableList(animals);
    }

    public void feed(Animal animal){
        requireAssigned(animal);
        System.out.println(name + "feeds " + animal.getName() + "with " + animal.getFavoriteFood());
    }

    public void bathe(Animal animal){
        requireAssigned(animal);
        System.out.println(name + "bathes " + animal.getName());
    }

    public void cleanHabitat(Animal animal){
        requireAssigned(animal);
        System.out.println(name + " cleans " + animal.getName() + "habitat: " + animal.getHabitat());
    }

    /**
     * A keeper only can act over animals that are matched to.
     * @param animal
     */
    private void requireAssigned(Animal animal){
        if(!animals.contains(animal)){
            String animalName = animal != null ? animal.getName() : "null";
            throw new IllegalArgumentException(name + "is not matched to " + animalName);
        }
    }
}
