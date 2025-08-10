package com.BusBookingApp.src.main.java.com.demo.UI;

import com.BusBookingApp.src.main.java.com.demo.Model.Bus;
import com.BusBookingApp.src.main.java.com.demo.Service.BusService;
import com.BusBookingApp.src.main.java.com.demo.Service.BusServiceImpl;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class BusUI {
    private BusService busService;
    private Scanner scanner;

    public BusUI() {
        this.busService = new BusServiceImpl();
        this.scanner = MainApp.getScanner();
    }

    public void addBus() {
        System.out.println("\n=== Add New Bus ===");

        System.out.print("Enter bus name: ");
        String busName = scanner.nextLine().trim();

        System.out.print("Enter source city: ");
        String source = scanner.nextLine().trim();

        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().trim();

        System.out.print("Enter departure time (HH:MM format): ");
        String departureTimeStr = scanner.nextLine().trim();
        LocalTime departureTime = parseTime(departureTimeStr);
        if (departureTime == null) return;

        System.out.print("Enter arrival time (HH:MM format): ");
        String arrivalTimeStr = scanner.nextLine().trim();
        LocalTime arrivalTime = parseTime(arrivalTimeStr);
        if (arrivalTime == null) return;

        System.out.print("Enter total number of seats: ");
        int totalSeats = MainApp.getIntInput();
        if (totalSeats <= 0) {
            System.out.println("Invalid number of seats!");
            return;
        }

        System.out.print("Enter fare amount: ");
        double fare = getDoubleInput();
        if (fare <= 0) {
            System.out.println("Invalid fare amount!");
            return;
        }

        System.out.print("Enter bus type (AC Sleeper/AC Semi Sleeper/Non-AC Seater): ");
        String busType = scanner.nextLine().trim();

        Bus bus = new Bus(null, busName, source, destination, departureTime, arrivalTime,
                totalSeats, totalSeats, BigDecimal.valueOf(fare), busType);

        String busId = busService.addBus(bus);
        if (busId != null) {
            System.out.println("Bus added successfully! Bus ID: " + busId);
        } else {
            System.out.println("Failed to add bus!");
        }
    }

    public void displayAllBuses() {
        System.out.println("\n=== All Available Buses ===");

        List<Bus> buses = busService.getAllBuses();
        if (buses.isEmpty()) {
            System.out.println("No buses available!");
            return;
        }

        displayBusList(buses);
    }

    public void searchBuses() {
        System.out.println("\n=== Search Buses ===");

        System.out.print("Enter source city: ");
        String source = scanner.nextLine().trim();

        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().trim();

        List<Bus> buses = busService.getAvailableBuses(source, destination);
        if (buses.isEmpty()) {
            System.out.println("No buses found for the given route!");
            return;
        }

        System.out.println("\nAvailable buses from " + source + " to " + destination + ":");
        displayBusList(buses);
    }

    public void updateBus() {
        System.out.println("\n=== Update Bus ===");

        System.out.print("Enter Bus ID to update: ");
        String busId = scanner.nextLine().trim();

        Bus bus = busService.getBusById(busId);
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }

        System.out.println("Current Bus Details:");
        displayBusDetails(bus);

        System.out.print("Enter new bus name (or press Enter to keep current): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            bus.setBusName(newName);
        }

        System.out.print("Enter new fare (or press Enter to keep current): ");
        String fareStr = scanner.nextLine().trim();
        if (!fareStr.isEmpty()) {
            double newFare = parseDouble(fareStr);
            if (newFare > 0) {
                bus.setFare(BigDecimal.valueOf(newFare));
            }
        }

        if (busService.updateBus(bus)) {
            System.out.println("Bus updated successfully!");
        } else {
            System.out.println("Failed to update bus!");
        }
    }

    public void deleteBus() {
        System.out.println("\n=== Delete Bus ===");

        System.out.print("Enter Bus ID to delete: ");
        String busId = scanner.nextLine().trim();

        Bus bus = busService.getBusById(busId);
        if (bus == null) {
            System.out.println("Bus not found!");
            return;
        }

        System.out.println("Bus Details:");
        displayBusDetails(bus);

        System.out.print("Are you sure you want to delete this bus? (yes/no): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(confirmation)) {
            if (busService.deleteBus(busId)) {
                System.out.println("Bus deleted successfully!");
            } else {
                System.out.println("Failed to delete bus!");
            }
        } else {
            System.out.println("Bus deletion cancelled.");
        }
    }

    private void displayBusList(List<Bus> buses) {
        System.out.printf("%-8s %-20s %-15s %-15s %-10s %-10s %-8s %-10s %-15s%n",
                "Bus ID", "Bus Name", "Source", "Destination", "Departure",
                "Arrival", "Seats", "Fare", "Type");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (Bus bus : buses) {
            System.out.printf("%-8s %-20s %-15s %-15s %-10s %-10s %-8s %-10.2f %-15s%n",
                    bus.getBusId(),
                    bus.getBusName(),
                    bus.getSource(),
                    bus.getDestination(),
                    bus.getDepartureTime(),
                    bus.getArrivalTime(),
                    bus.getAvailableSeats() + "/" + bus.getTotalSeats(),
                    bus.getFare(),
                    bus.getBusType());
        }
    }

    private void displayBusDetails(Bus bus) {
        System.out.println("Bus ID: " + bus.getBusId());
        System.out.println("Bus Name: " + bus.getBusName());
        System.out.println("Route: " + bus.getSource() + " to " + bus.getDestination());
        System.out.println("Departure: " + bus.getDepartureTime());
        System.out.println("Arrival: " + bus.getArrivalTime());
        System.out.println("Total Seats: " + bus.getTotalSeats());
        System.out.println("Available Seats: " + bus.getAvailableSeats());
        System.out.println("Fare: ₹" + bus.getFare());
        System.out.println("Type: " + bus.getBusType());
    }

    private LocalTime parseTime(String timeStr) {
        try {
            return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format! Please use HH:MM format.");
            return null;
        }
    }

    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double parseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
