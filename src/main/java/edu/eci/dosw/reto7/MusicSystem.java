package edu.eci.dosw.reto7;

/**
 * es la clase de musica que tiene el volumen y se puede cambiar
 */
public class MusicSystem {

    private int volume;
    /**
     * Crea un sistema con el volumen 0
     */
    public MusicSystem() {
        volume = 0;
    }

    /**
     * @param volume
     */
    public void setVolume(int volume) {

        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException(
                    "El volumen debe estar entre 0 y 100");
        }

        this.volume = volume;
    }

    /**
     * @return
     */
    public int getVolume() {
        return volume;
    }
}
