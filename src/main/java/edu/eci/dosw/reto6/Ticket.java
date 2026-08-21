package edu.eci.dosw.reto6;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * clase que representa el ticket de soporte
 */
public class Ticket {

    private final String description;
    private final Difficulty difficulty;
    private final Priority priority;

    private String resolvedBy;
    private boolean resolved;

    private final List<String> attemptedTechnicians = new ArrayList<>();

    /**
     * crea un ticket
     * @param description
     * @param difficulty
     * @param priority
     */
    public Ticket(
            String description,
            Difficulty difficulty,
            Priority priority) {

        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException(
                    "Description cannot be null");
        }

        if (difficulty == null) {
            throw new IllegalArgumentException(
                    "Difficulty cannot be null");
        }

        if (priority == null) {
            throw new IllegalArgumentException(
                    "priority caannot be null");
        }

        this.description = description;
        this.difficulty = difficulty;
        this.priority = priority;
        this.resolved = false;
        this.resolvedBy = null;
    }

    public String getDescription() {
        return description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public boolean isResolved() {
        return resolved;
    }

    /**
     *muestra el ticket resuelto y el nombre del tecnico
     * @param technicianName
     */
    public void resolve(String technicianName) {

        if (technicianName == null || technicianName.isBlank()) {
            throw new IllegalArgumentException(
                    "Technician name cannot be empty");
        }

        this.resolved = true;
        this.resolvedBy = technicianName;
    }

    /**
     * pone el ticket como pendiente
     */
    public void markAsPending() {
        this.resolved = false;
        this.resolvedBy = null;
    }

    public void addAttempt(String technicianName){
        if(technicianName == null || technicianName.isBlank()){
            throw new IllegalArgumentException(
                    "Technician name cannot be empty");
        }
        attemptedTechnicians.add(technicianName);
    }

    public List<String> getAttemptedTechnicians() {
        return Collections.unmodifiableList(attemptedTechnicians);
    }
    //con eso dice directamente si pasó por mas de un tecnico si .size() es mayor a 1
}
