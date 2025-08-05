package org.demo.Ui;

import java.util.Scanner;

public class BookingUI {
    private final Scanner sc = new Scanner(System.in);

    public void bookTicket() {
        System.out.println("Booking ticket...");
        System.out.print("Enter Bus ID: ");
        String busId = sc.nextLine();
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.println("Ticket booked for " + name + " on Bus ID " + busId);
    }

    public void cancelTicket() {
        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = sc.nextLine();
        System.out.println("Booking ID " + bookingId + " cancelled.");
    }
}
