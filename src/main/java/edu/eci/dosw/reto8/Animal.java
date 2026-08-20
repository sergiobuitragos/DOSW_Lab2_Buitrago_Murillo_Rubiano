package edu.eci.dosw.reto8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for all animals.
 */
public abstract class Animal {

    private final String name;
    private final int age;
    private final String characteristicSound;
    private final String diet;
    private final String favoriteFood;
    private final double weight;
    private final double height;
    private HealthStatus healthStatus;
    private final String habitat;
    private final Map<String, Object> dynamicAttributes = new HashMap<>();

    protected Animal(String name, int age, String characteristicSound, String diet, String favoriteFood,
            double weight, double height, HealthStatus healthStatus, String habitat) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (healthStatus == null) {
            throw new IllegalArgumentException("Health Status cannot be null");
        }

        this.name = name;
        this.age = age;
        this.characteristicSound = characteristicSound;
        this.diet = diet;
        this.favoriteFood = favoriteFood;
        this.weight = weight;
        this.height = height;
        this.healthStatus = healthStatus;
        this.habitat = habitat;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCharacteristicSound() {
        return characteristicSound;
    }

    public String getDiet() {
        return diet;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public HealthStatus getHealthStatus() {
        return healthStatus;
    }

    public String getHabitat() {
        return habitat;
    }

    /**
     * Health Status is the only attribute that changes
     * along animal's life (Healthy/Sick/Quarantine).
     */
    public void setHealthStatus(HealthStatus healthStatus) {
        if (healthStatus == null) {
            throw new IllegalArgumentException("Health Status cannot be null");
        }
        this.healthStatus = healthStatus;
    }

    
    public void addAttribute(String key, Object value) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Attribute key cannot be null");
        }
        dynamicAttributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return dynamicAttributes.get(key);
    }

    public Map<String, Object> getAttributes() {
        return Collections.unmodifiableMap(dynamicAttributes);
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Characteristic Sound: " + characteristicSound);
        System.out.println("Diet: " + diet);
        System.out.println("Favorite Food: " + favoriteFood);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Height: " + height + " m");
        System.out.println("Health Status: " + healthStatus);
        System.out.println("Habitat: " + habitat);
        if (!dynamicAttributes.isEmpty()) {
            System.out.println("Added Attributes: " + dynamicAttributes);
        }
    }
}
