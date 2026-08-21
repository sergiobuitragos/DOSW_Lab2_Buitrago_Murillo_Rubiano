package edu.eci.dosw.reto6;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupportChainTest {

    private SupportChain buildChain() {
        TechnicalSupport basic = new BasicTechinician("Ana", Priority.MEDIUM);
        TechnicalSupport intermediate = new IntermediateTechinician("Luis", Priority.HIGH);
        TechnicalSupport advanced = new AdvancedTechinician("Carla", Priority.HIGH);
        basic.setNext(intermediate).setNext(advanced);
        return new SupportChain(basic);
    }

    @Test
    void resolvesTicketWithMatchingTechnician() {
        Ticket ticket = new Ticket("Problema básico", Difficulty.BASIC, Priority.LOW);
        buildChain().process(ticket);

        assertTrue(ticket.isResolved());
        assertEquals("Ana", ticket.getResolvedBy());
    }

    @Test
    void escalatesThroughMultipleTechniciansWhenNeeded() {
        Ticket ticket = new Ticket("Problema avanzado", Difficulty.ADVANCED, Priority.HIGH);
        buildChain().process(ticket);

        assertTrue(ticket.isResolved());
        assertEquals("Carla", ticket.getResolvedBy());
        assertTrue(ticket.getAttemptedTechnicians().size() > 1,
                "El ticket debió pasar por más de un técnico antes de resolverse");
    }

    @Test
    void marksTicketAsPendingWhenNoTechnicianCanResolve() {
        Ticket ticket = new Ticket("Consulta fuera de alcance", Difficulty.BASIC, Priority.HIGH);
        buildChain().process(ticket);

        assertFalse(ticket.isResolved());
    }

    @Test
    void statisticsReflectResolvedAndPendingTickets() {
        Ticket resolved = new Ticket("Básico resuelto", Difficulty.BASIC, Priority.LOW);
        Ticket pending = new Ticket("Fuera de alcance", Difficulty.BASIC, Priority.HIGH);

        SupportChain chain = buildChain();
        chain.process(resolved);
        chain.process(pending);

        SupportStatistics stats = new SupportStatistics(List.of(resolved, pending));

        assertEquals(1, stats.resolvedCount());
        assertEquals(1, stats.pendingCount());
    }
}
