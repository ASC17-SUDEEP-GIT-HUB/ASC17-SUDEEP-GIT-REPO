package org.demo.Service;

import org.demo.Model.Bus;
import org.demo.Model.Ticket;
import org.demo.Repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;
    private final BusService busService;

    public TicketServiceImpl(TicketRepository ticketRepository, BusService busService) {
        this.ticketRepository = ticketRepository;
        this.busService = busService;
    }

    @Override
    public String bookTicket(String userId, String busId, int seatCounts) {
        // 1. Find the bus
        List<Bus> buses = busService.getAllBuses();
        Bus selectedBus = null;
        for (Bus bus : buses) {
            if (bus.getBusId().equals(busId)) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            return "Bus not found!";
        }

        // 2. Check seat availability
        if (selectedBus.getAvailableSeats() < seatCounts) {
            return "Not enough available seats!";
        }

        // 3. Calculate total fare
        double totalFare = seatCounts * selectedBus.getFare();

        // 4. Generate ticket ID
        String ticketId = ticketRepository.getNextTicketId();

        // 5. Create and save ticket
        Ticket ticket = null;
        ticket.setTicketId(ticketId);
        ticket.setUserId(userId);
        ticket.setBusId(busId);
        ticket.setSeatCount(seatCounts);
        ticket.setFare(totalFare);
        ticket.setDepartureTime(LocalDateTime.now());

        boolean success = ticketRepository.bookTicket(ticket);

        if (success) {
            // 6. Update available seats
            busService.updateSeats(busId, seatCounts);
            return "Ticket booked successfully. Ticket ID: " + ticketId;
        } else {
            return "Failed to book ticket.";
        }
    }

    @Override
    public Ticket ViewTicket(String ticketId) {
        return ticketRepository.bookTicketById(ticketId);
    }

    @Override
    public List<Ticket> viewUserTickets(String userId) {
        return ticketRepository.getTicketByUser(userId);
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        Ticket ticket = ticketRepository.bookTicketById(ticketId);
        if (ticket == null) {
            return false;
        }

        boolean result = ticketRepository.cancelTicket(ticketId);
        if (result) {
            // add back the seats
            busService.updateSeats(ticket.getBusId(), -ticket.getSeatCount()); // negative means adding back
        }
        return result;
    }
}
