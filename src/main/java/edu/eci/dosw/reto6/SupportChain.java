package edu.eci.dosw.reto6;

/**
 * Arma la cadena de técnicos y pone un método para procesar un ticket de soporte.
 */
public final class SupportChain {
    private final TechnicalSupport firstTechnician;

    public SupportChain(TechnicalSupport firstTechnician){
        if(firstTechnician == null){
            throw new IllegalArgumentException("Chain must have at least one technician");
        }
        this.firstTechnician = firstTechnician;
    }

    public void process(Ticket ticket){
        firstTechnician.handle(ticket);
    }
}
