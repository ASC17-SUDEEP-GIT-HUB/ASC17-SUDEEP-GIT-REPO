package org.demo.Ui;

import org.demo.Ui.UserUI;
import org.demo.Ui.BusUI;
import org.demo.Ui.BookingUI;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserUI userUI = new UserUI();
        BusUI busUI = new BusUI();
        BookingUI bookingUI = new BookingUI();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Bus Booking System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Buses");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1: userUI.registerUser();
                case 2: userUI.loginUser();
                case 3: busUI.viewAllBuses();
                case 4: bookingUI.bookTicket();
                case 5: bookingUI.cancelTicket();
                case 6: {
                    running = false;
                    System.out.println("Thank you for using the Bus Booking System.");
                }
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}

