package com.BusBookingApp.src.main.java.com.demo.Service;

import com.demo.Model.Bus;
import com.demo.Model.Ticket;
import com.BusBookingApp.src.main.java.com.demo.Repository.BusRepository;
import com.BusBookingApp.src.main.java.com.demo.Repository.BusRepositoryImpl;
import com.BusBookingApp.src.main.java.com.demo.Repository.TicketRepository;
import com.BusBookingApp.src.main.java.com.demo.Repository.TicketRepositoryImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.*;


public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;
    private BusRepository busRepository;

    public TicketServiceImpl() {
        this.ticketRepository = new TicketRepositoryImpl();
        this.busRepository = new BusRepositoryImpl();
    }

    @Override
    public String bookTicket(Ticket ticket) {
        if (ticket == null || !validateBooking(ticket)) {
            return null;
        }

        // Check if seat is available
        List<Integer> bookedSeats = ticketRepository.getBookedSeats(ticket.getBusId(), ticket.getTravelDate());
        if (bookedSeats.contains(ticket.getSeatNumber())) {
            System.out.println("Seat " + ticket.getSeatNumber() + " is already booked");
            return null;
        }

        // Calculate total amount
        double totalAmount = calculateTotalAmount(ticket.getBusId(), 1);
        ticket.setTotalAmount(BigDecimal.valueOf(totalAmount));

        // Book the ticket
        String ticketId = ticketRepository.bookTicket(ticket);

        if (ticketId != null) {
            // Update available seats
            busRepository.updateAvailableSeats(ticket.getBusId(), 1);
        }

        return ticketId;
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            return null;
        }
        return ticketRepository.getTicketById(ticketId);
    }

    @Override
    public List<Ticket> getUserBookingHistory(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return ticketRepository.getTicketsByUserId(userId);
    }

    @Override
    public List<Ticket> getBusBookings(String busId) {
        if (busId == null || busId.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return ticketRepository.getTicketsByBusId(busId);
    }

    @Override
    public boolean cancelTicket(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            return false;
        }

        Ticket ticket = ticketRepository.getTicketById(ticketId);
        if (ticket == null || !"BOOKED".equals(ticket.getStatus())) {
            return false;
        }

        // Cancel the ticket
        boolean cancelled = ticketRepository.cancelTicket(ticketId);

        if (cancelled) {
            // Increase available seats
            Bus bus = busRepository.getBusById(ticket.getBusId());
            if (bus != null) {
                bus.setAvailableSeats(bus.getAvailableSeats() + 1);
                busRepository.updateBus(bus);
            }
        }

        return cancelled;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        if (ticket == null || ticket.getTicketId() == null || !validateBooking(ticket)) {
            return false;
        }
        return ticketRepository.updateTicket(ticket);
    }

    @Override
    public List<Integer> getAvailableSeats(String busId, LocalDate travelDate) {
        if (busId == null || busId.trim().isEmpty() || travelDate == null) {
            return Collections.emptyList();
        }


        Bus bus = busRepository.getBusById(busId);
        if (bus == null) {
            return Collections.emptyList();
        }

        List<Integer> bookedSeats = ticketRepository.getBookedSeats(busId, travelDate);
        List<Integer> availableSeats = new ArrayList<>();

        IntStream.rangeClosed(1, bus.getTotalSeats())
                .filter(seat -> !bookedSeats.contains(seat))
                .forEach(availableSeats::add);

        return availableSeats;
    }

    @Override
    public boolean validateBooking(Ticket ticket) {
        if (ticket == null) return false;

        // Basic validation
        if (ticket.getUserId() == null || ticket.getUserId().trim().isEmpty() ||
                ticket.getBusId() == null || ticket.getBusId().trim().isEmpty() ||
                ticket.getPassengerName() == null || ticket.getPassengerName().trim().isEmpty() ||
                ticket.getTravelDate() == null || ticket.getSeatNumber() <= 0) {
            return false;
        }

        // Check if travel date is in the future
        if (ticket.getTravelDate().isBefore(LocalDate.now())) {
            System.out.println("Travel date cannot be in the past");
            return false;
        }

        // Check if bus exists
        Bus bus = busRepository.getBusById(ticket.getBusId());
        if (bus == null) {
            System.out.println("Bus not found");
            return false;
        }

        // Check if seat number is valid
        if (ticket.getSeatNumber() > bus.getTotalSeats()) {
            System.out.println("Invalid seat number");
            return false;
        }

        return true;
    }

    @Override
    public double calculateTotalAmount(String busId, int numberOfSeats) {
        Bus bus = busRepository.getBusById(busId);
        if (bus == null) {
            return 0.0;
        }
        return bus.getFare().doubleValue() * numberOfSeats;
    }
}
