package edu.eci.dosw.reto7;
/**
 * clase que representa la luz, tiene la liga de prender y apagar
 */
public class Light {

    private boolean on;

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    /**
     * mira el estado de la luz
     * @return
     */
    public boolean isOn() {
        return on;
    }
}
