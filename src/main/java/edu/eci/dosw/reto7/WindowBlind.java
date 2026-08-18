package edu.eci.dosw.reto7;

/**
 * es la clase persiana que se puede abrir y cerrar
 */
public class WindowBlind {

    private int position;

    /**
     * crea una persiana cerrada
     */
    public WindowBlind() {
        position = 0;
    }

    /**
     * @param position
     */
    public void setPosition(int position) {

        if (position < 0 || position > 100) {
            throw new IllegalArgumentException(
                    "La posición debe estar entre 0 y 100");
        }

        this.position = position;
    }

    /**
     * @return
     */
    public int getPosition() {
        return position;
    }
}
