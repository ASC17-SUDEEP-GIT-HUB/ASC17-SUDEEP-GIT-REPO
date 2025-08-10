package com.BusBookingApp.src.main.java.com.demo.Service;

import com.demo.Model.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
    String bookTicket(Ticket ticket);
    Ticket getTicketById(String ticketId);
    List<Ticket> getUserBookingHistory(String userId);
    List<Ticket> getBusBookings(String busId);
    boolean cancelTicket(String ticketId);
    boolean updateTicket(Ticket ticket);
    List<Integer> getAvailableSeats(String busId, LocalDate travelDate);
    boolean validateBooking(Ticket ticket);
    double calculateTotalAmount(String busId, int numberOfSeats);
}
