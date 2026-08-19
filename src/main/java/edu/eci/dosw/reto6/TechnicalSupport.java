package edu.eci.dosw.reto6;

/**
 * Cada tecnico decide si puede resolver el ticket segun su especialidad y prioridad.
 * si no puede, se lo deja al siguiente tecnico
 */
public abstract class TechnicalSupport {
    private final String name;
    private final Difficulty speciality;
    private final Priority maxPriority;
    private TechnicalSupport next;

    protected TechnicalSupport(String name, Difficulty speciality, Priority maxPriority){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.speciality = speciality;
        this.maxPriority = maxPriority;
    }
    
    public TechnicalSupport setNext(TechnicalSupport next){
        this.next = next;
        return next;
    }

    public String getName(){
        return name;
    }
    
    /**
     * Procesa el ticket.
     * Si se puede resolver, pues se resuelve
     * pero si no, se le delega al siguietne. Si no hay siguiente, queda como pendiente
     * @param ticket
     */
    public void handle(Ticket ticket){
        ticket.addAttempt(name);

        if(canResolve(ticket)){
            ticket.resolve(name);
            return;
        }
        if(next != null){
            next.handle(ticket);
        } else{
            ticket.markAsPending();
        }
    }

    private boolean canResolve(Ticket ticket){
        return ticket.getDifficulty() == speciality && ticket.getPriority().getValue() <= maxPriority.getValue();
    }
}
