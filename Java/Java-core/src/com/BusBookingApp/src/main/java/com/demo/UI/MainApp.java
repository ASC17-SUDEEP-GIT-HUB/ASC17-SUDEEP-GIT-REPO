package com.BusBookingApp.src.main.java.com.demo.UI;

import java.util.Scanner;

public class MainApp {

    private static Scanner scanner = new Scanner(System.in);
    private static UserUI userUI = new UserUI();
    private static BusUI busUI = new BusUI();
    private static BookingUI bookingUI = new BookingUI();
    private static String currentUserId = null;

    public static void main(String[] args) {
        System.out.println("=== Welcome to Bus Booking System ===");

        while (true) {
            if (currentUserId == null) {
                showMainMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. User Registration");
        System.out.println("2. User Login");
        System.out.println("3. View All Buses");
        System.out.println("4. Search Buses");
        System.out.println("5. Admin Menu");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                userUI.registerUser();
                break;
            case 2:
                currentUserId = userUI.loginUser();
                if (currentUserId != null) {
                    System.out.println("Login successful!");
                }
                break;
            case 3:
                busUI.displayAllBuses();
                break;
            case 4:
                busUI.searchBuses();
                break;
            case 5:
                showAdminMenu();
                break;
            case 6:
                System.out.println("Thank you for using Bus Booking System!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void showUserMenu() {
        System.out.println("\n=== User Menu ===");
        System.out.println("1. Search Buses");
        System.out.println("2. Book Ticket");
        System.out.println("3. View My Bookings");
        System.out.println("4. Cancel Ticket");
        System.out.println("5. View Profile");
        System.out.println("6. Update Profile");
        System.out.println("7. Logout");
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                busUI.searchBuses();
                break;
            case 2:
                bookingUI.bookTicket(currentUserId);
                break;
            case 3:
                bookingUI.viewUserBookings(currentUserId);
                break;
            case 4:
                bookingUI.cancelTicket(currentUserId);
                break;
            case 5:
                userUI.viewProfile(currentUserId);
                break;
            case 6:
                userUI.updateProfile(currentUserId);
                break;
            case 7:
                currentUserId = null;
                System.out.println("Logged out successfully!");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void showAdminMenu() {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Bus");
        System.out.println("2. Update Bus");
        System.out.println("3. Delete Bus");
        System.out.println("4. View All Users");
        System.out.println("5. View All Bookings");
        System.out.println("6. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                busUI.addBus();
                break;
            case 2:
                busUI.updateBus();
                break;
            case 3:
                busUI.deleteBus();
                break;
            case 4:
                userUI.viewAllUsers();
                break;
            case 5:
                bookingUI.viewAllBookings();
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    public static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }
}
