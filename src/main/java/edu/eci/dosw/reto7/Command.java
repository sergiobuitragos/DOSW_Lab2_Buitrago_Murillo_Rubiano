package edu.eci.dosw.reto7;

/**
 * patron de diseño Command
 * comandos que se ejecutan o se deshacen
 */
public interface Command {

    /**
    * hace la accion
     */
    void execute();

    /**
     * deshace la accion 
     */
    void undo();
}
