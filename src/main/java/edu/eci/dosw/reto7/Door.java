package edu.eci.dosw.reto7;
/**
 * Es la clase puerta que se abre y se cierra 
 */
public class Door {

    private boolean open;

    public void open() {
        open = true;
    }

    public void close() {
        open = false;
    }

    /**
     * mira si la puerta esta abierta o cerrada
     * @return
     */
    public boolean isOpen() {
        return open;
    }
}
