package edu.eci.dosw.reto6;

/**
 * clase que representa el ticket de soporte
 */
public class Ticket {

    private final String description;
    private final Difficulty difficulty;
    private final Priority priority;

    private String resolvedBy;
    private boolean resolved;

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
                    "La descripcion no puede estar vacia");
        }

        if (difficulty == null) {
            throw new IllegalArgumentException(
                    "La dificultad no puede ser null");
        }

        if (priority == null) {
            throw new IllegalArgumentException(
                    "La prioridad no puede ser null");
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
                    "El nombre del tecnico no puede estar vacio");
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
}
