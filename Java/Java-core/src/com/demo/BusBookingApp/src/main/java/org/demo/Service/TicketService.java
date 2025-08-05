package org.demo.Service;

import org.demo.Model.Ticket;

import java.util.List;

public interface TicketService {

    String bookTicket(String userId, String busId, int seatCounts);
    Ticket ViewTicket(String ticketId);
    List<Ticket> viewUserTickets(String userId);
    boolean cancelTicket(String ticketId);

}