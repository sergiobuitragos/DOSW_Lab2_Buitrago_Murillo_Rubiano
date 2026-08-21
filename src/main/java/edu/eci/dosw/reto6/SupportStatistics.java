package edu.eci.dosw.reto6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Calcula estadísticas sobre un conjunto de tickets usando Java Streams.
 */
public final class SupportStatistics {

    private final List<Ticket> tickets;

    public SupportStatistics(List<Ticket> tickets) {
        if (tickets == null) {
            throw new IllegalArgumentException("La lista de tickets no puede ser null");
        }
        this.tickets = tickets;
    }

    public Map<Difficulty, Long> ticketsByLevel() {
        return tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getDifficulty, Collectors.counting()));
    }

    public long resolvedCount() {
        return tickets.stream().filter(Ticket::isResolved).count();
    }

    public long pendingCount() {
        return tickets.stream().filter(t -> !t.isResolved()).count();
    }

    public double averagePriorityOfResolved() {
        return tickets.stream()
                .filter(Ticket::isResolved)
                .mapToInt(t -> t.getPriority().getValue())
                .average()
                .orElse(0.0);
    }

    public void printSummary() {
        System.out.println("Tickets por nivel: " + ticketsByLevel());
        System.out.println("Resueltos: " + resolvedCount());
        System.out.println("Pendientes: " + pendingCount());
        System.out.println("Promedio de prioridad de resueltos: " + averagePriorityOfResolved());
    }
}
