package edu.eci.dosw.reto6;

import java.util.List;

public final class Reto6 {

    private Reto6() {
    }

    public static void run() {
        System.out.println("Running Challenge 6 — Talk to Technical Support...");

        TechnicalSupport basic = new BasicTechinician("Ana", Priority.MEDIUM);
        TechnicalSupport intermediate = new IntermediateTechinician("Luis", Priority.HIGH);
        TechnicalSupport advanced = new AdvancedTechinician("Carla", Priority.HIGH);
        basic.setNext(intermediate).setNext(advanced);

        SupportChain chain = new SupportChain(basic);

        Ticket t1 = new Ticket("No enciende el monitor", Difficulty.BASIC, Priority.LOW);
        Ticket t2 = new Ticket("Error de red intermitente", Difficulty.INTERMEDIATE, Priority.HIGH);
        Ticket t3 = new Ticket("Falla de servidor crítica", Difficulty.ADVANCED, Priority.HIGH);
        Ticket t4 = new Ticket("Consulta general sobre facturación", Difficulty.BASIC, Priority.HIGH);

        List<Ticket> tickets = List.of(t1, t2, t3, t4);
        tickets.forEach(chain::process);

        for (Ticket ticket : tickets) {
            if (ticket.isResolved()) {
                System.out.println(ticket.getDescription() + " -> resuelto por " + ticket.getResolvedBy()
                        + " (intentos: " + ticket.getAttemptedTechnicians() + ")");
            } else {
                System.out.println(ticket.getDescription() + " -> PENDIENTE de escalamiento");
            }
        }

        System.out.println();
        new SupportStatistics(tickets).printSummary();
    }
}
