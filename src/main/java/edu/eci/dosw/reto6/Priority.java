package edu.eci.dosw.reto6;

/**
 * clase que muestra la prioridad del tickete
 */
public enum Priority {

    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    /**
     * recoge el valor del tickete
     * @return
     */
    public int getValue() {
        return value;
    }
}
