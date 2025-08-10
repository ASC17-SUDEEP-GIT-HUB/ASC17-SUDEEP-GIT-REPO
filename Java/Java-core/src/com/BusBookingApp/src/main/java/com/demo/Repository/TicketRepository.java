package com.BusBookingApp.src.main.java.com.demo.Repository;

import com.demo.Model.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository {
    String bookTicket(Ticket ticket);
    Ticket getTicketById(String ticketId);
    List<Ticket> getTicketsByUserId(String userId);
    List<Ticket> getTicketsByBusId(String busId);
    List<Ticket> getTicketsByDate(LocalDate travelDate);
    boolean cancelTicket(String ticketId);
    boolean updateTicket(Ticket ticket);
    List<Integer> getBookedSeats(String busId, LocalDate travelDate);
    String generateTicketId();
}
