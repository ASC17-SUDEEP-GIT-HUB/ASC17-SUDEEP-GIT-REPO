package com.BusBookingApp.src.main.java.com.demo.UI;

import com.BusBookingApp.src.main.java.com.demo.Model.Bus;
import com.BusBookingApp.src.main.java.com.demo.Model.Ticket;
import com.BusBookingApp.src.main.java.com.demo.Service.BusService;
import com.BusBookingApp.src.main.java.com.demo.Service.BusServiceImpl;
import com.BusBookingApp.src.main.java.com.demo.Service.TicketService;
import com.BusBookingApp.src.main.java.com.demo.Service.TicketServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingUI {
    private TicketService ticketService;
    private BusService busService;
    private Scanner scanner;

    public BookingUI() {
        this.ticketService = new TicketServiceImpl();
        this.busService = new BusServiceImpl();
        this.scanner = MainApp.getScanner();
    }

    public void bookTicket(String userId) {
        System.out.println("\n=== Book Ticket ===");

        System.out.println("\n=== All Buses ===");
        List<Bus> allBuses = busService.getAllBuses();
        displayBusList(allBuses);
        
        System.out.print("Enter source city: ");
        String source = scanner.nextLine().trim();

        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().trim();

        List<Bus> availableBuses = busService.getAvailableBuses(source, destination);
        if (availableBuses.isEmpty()) {
            System.out.println("No buses available for this route!");
            return;
        }

        System.out.println("\nAvailable Buses:");
        displayBusList(availableBuses);

        System.out.print("Enter Bus ID to book: ");
        String busId = scanner.nextLine().trim();

        Bus selectedBus = busService.getBusById(busId);
        if (selectedBus == null) {
            System.out.println("Invalid Bus ID!");
            return;
        }
        boolean isBusAvailable = availableBuses.stream()
                .anyMatch(bus -> bus.getBusId().equals(busId));

        if (!isBusAvailable) {
            System.out.println("Selected bus is not available for this route!");
            return;
        }

        System.out.print("Enter travel date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine().trim();
        LocalDate travelDate = parseDate(dateStr);
        if (travelDate == null) return;

        if (travelDate.isBefore(LocalDate.now())) {
            System.out.println("Travel date cannot be in the past!");
            return;
        }

        List<Integer> availableSeats = ticketService.getAvailableSeats(busId, travelDate);
        if (availableSeats.isEmpty()) {
            System.out.println("No seats available for the selected date!");
            return;
        }

        System.out.println("Available Seats: " + availableSeats);
        System.out.print("Enter seat number: ");
        int seatNumber = MainApp.getIntInput();

        if (!availableSeats.contains(seatNumber)) {
            System.out.println("Selected seat is not available!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine().trim();

        double totalAmount = ticketService.calculateTotalAmount(busId, 1);

        Ticket ticket = new Ticket(null, userId, busId, passengerName, seatNumber,
                null, travelDate, BigDecimal.valueOf(totalAmount), "BOOKED");

        String ticketId = ticketService.bookTicket(ticket);
        if (ticketId != null) {
            System.out.println("\n=== Booking Successful ===");
            System.out.println("Ticket ID: " + ticketId);
            System.out.println("Passenger: " + passengerName);
            System.out.println("Bus: " + selectedBus.getBusName());
            System.out.println("Route: " + selectedBus.getSource() + " to " + selectedBus.getDestination());
            System.out.println("Travel Date: " + travelDate);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Total Amount: ₹" + totalAmount);
        } else {
            System.out.println("Booking failed! Please try again.");
        }
    }

    public void viewUserBookings(String userId) {
        System.out.println("\n=== My Bookings ===");

        List<Ticket> tickets = ticketService.getUserBookingHistory(userId);
        if (tickets.isEmpty()) {
            System.out.println("No bookings found!");
            return;
        }

        displayTicketList(tickets);
    }

    public void cancelTicket(String userId) {
        System.out.println("\n=== Cancel Ticket ===");

        List<Ticket> tickets = ticketService.getUserBookingHistory(userId);
        List<Ticket> activeTickets = tickets.stream()
                .filter(ticket -> "BOOKED".equals(ticket.getStatus()))
                .collect(Collectors.toList());

        if (activeTickets.isEmpty()) {
            System.out.println("No active bookings to cancel!");
            return;
        }

        System.out.println("Your Active Bookings:");
        displayTicketList(activeTickets);

        System.out.print("Enter Ticket ID to cancel: ");
        String ticketId = scanner.nextLine().trim();

        Ticket ticket = ticketService.getTicketById(ticketId);
        if (ticket == null || !ticket.getUserId().equals(userId) || !"BOOKED".equals(ticket.getStatus())) {
            System.out.println("Invalid ticket ID or ticket cannot be cancelled!");
            return;
        }

        System.out.print("Are you sure you want to cancel this ticket? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(confirmation)) {
            if (ticketService.cancelTicket(ticketId)) {
                System.out.println("Ticket cancelled successfully!");
                System.out.println("Refund amount: ₹" + ticket.getTotalAmount());
            } else {
                System.out.println("Failed to cancel ticket!");
            }
        } else {
            System.out.println("Ticket cancellation cancelled.");
        }
    }

    public void viewAllBookings() {
        System.out.println("\n=== All Bookings (Admin View) ===");

        // This would typically get all tickets from all users
        // For simplicity, we'll show a message
      //  System.out.println("Admin functionality to view all bookings would be implemented here.");
        System.out.println("This would require additional Access to view All Tickets!!");
    }

    private void displayBusList(List<Bus> buses) {
        System.out.printf("%-8s %-20s %-15s %-15s %-10s %-10s %-8s %-10s%n",
                "Bus ID", "Bus Name", "Source", "Destination", "Departure",
                "Arrival", "Seats", "Fare");
        System.out.println("---------------------------------------------------------------------------------");

        for (Bus bus : buses) {
            System.out.printf("%-8s %-20s %-15s %-15s %-10s %-10s %-8s ₹%-9.2f%n",
                    bus.getBusId(),
                    bus.getBusName(),
                    bus.getSource(),
                    bus.getDestination(),
                    bus.getDepartureTime(),
                    bus.getArrivalTime(),
                    bus.getAvailableSeats() + "/" + bus.getTotalSeats(),
                    bus.getFare());
        }
    }

    private void displayTicketList(List<Ticket> tickets) {
        System.out.printf("%-10s %-8s %-20s %-8s %-12s %-12s %-10s %-10s%n",
                "Ticket ID", "Bus ID", "Passenger", "Seat", "Travel Date",
                "Booking Date", "Amount", "Status");
        System.out.println("------------------------------------------------------------------------------------------");

        for (Ticket ticket : tickets) {
            System.out.printf("%-10s %-8s %-20s %-8s %-12s %-12s ₹%-9.2f %-10s%n",
                    ticket.getTicketId(),
                    ticket.getBusId(),
                    ticket.getPassengerName(),
                    ticket.getSeatNumber(),
                    ticket.getTravelDate(),
                    ticket.getBookingDate().toLocalDate(),
                    ticket.getTotalAmount(),
                    ticket.getStatus());
        }
    }

    private LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please use YYYY-MM-DD format.");
            return null;
        }
    }
}
