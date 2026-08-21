package edu.eci.dosw;

import edu.eci.dosw.reto1.Reto1;
import edu.eci.dosw.reto2.Reto2;
import edu.eci.dosw.reto4.Reto4;
import edu.eci.dosw.reto6.Reto6;

public class Application {

    public static void main(String[] args) {
        System.out.println("Maven project configured and running correctly.");
        Reto1.run();
        Reto2.run();
        // Ejecuta la demo del reto3
        // Reto3 (Dealership) requiere input interactivo por teclado.
        // Ejecutar manualmente: edu.eci.dosw.reto3.Main
        // edu.eci.dosw.reto3.Main.main(args);
        Reto4.run();
        // Ejecuta la demo del reto5
        edu.eci.dosw.reto5.Main.main(args);
        Reto6.run();
    }

}

