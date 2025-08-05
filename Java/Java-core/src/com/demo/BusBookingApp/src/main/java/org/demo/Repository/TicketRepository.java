package org.demo.Repository;

import org.demo.Model.Ticket;

import java.util.List;

public interface TicketRepository {

    boolean bookTicket(Ticket ticket);
    Ticket bookTicketById(String ticketId);
    List<Ticket> getTicketByUser(String userId);
    boolean cancelTicket(String ticketId);
    String getNextTicketId();
}


