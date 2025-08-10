package com.BusBookingApp.src.main.java.com.demo.UI;

import com.BusBookingApp.src.main.java.com.demo.Model.User;
import com.BusBookingApp.src.main.java.com.demo.Service.UserService;
import com.BusBookingApp.src.main.java.com.demo.Service.UserServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserUI {

    private UserService userService;
    private Scanner scanner;

    public UserUI() {
        this.userService = new UserServiceImpl();
        this.scanner = MainApp.getScanner();
    }

    public void registerUser() {
        System.out.println("\n=== User Registration ===");

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine().trim();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter your phone number (10 digits): ");
        String phoneNumber = scanner.nextLine().trim();

        System.out.print("Enter your password (minimum 6 characters): ");
        String password = scanner.nextLine().trim();

        User user = new User(null, userName, email, phoneNumber, password, LocalDateTime.now());

        String userId = userService.registerUser(user);
        if (userId != null) {
            System.out.println("Registration successful! Your User ID is: " + userId);
        } else {
            System.out.println("Registration failed! Please check your details and try again.");
        }
    }

    public String loginUser() {
        System.out.println("\n=== User Login ===");

        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine().trim();

        if (userService.loginUser(email, password)) {
            User user = userService.getUserByEmail(email);
            return user != null ? user.getUserId() : null;
        } else {
            System.out.println("Invalid email or password!");
            return null;
        }
    }

    public void viewProfile(String userId) {
        System.out.println("\n=== User Profile ===");

        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("Name: " + user.getUserName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhoneNumber());
            System.out.println("Member since: " + user.getCreatedDate().toLocalDate());
        } else {
            System.out.println("User not found!");
        }
    }

    public void updateProfile(String userId) {
        System.out.println("\n=== Update Profile ===");

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Current Details:");
        System.out.println("Name: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhoneNumber());

        System.out.print("Enter new name (or press Enter to keep current): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            user.setUserName(newName);
        }

        System.out.print("Enter new email (or press Enter to keep current): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) {
            user.setEmail(newEmail);
        }

        System.out.print("Enter new phone number (or press Enter to keep current): ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            user.setPhoneNumber(newPhone);
        }

        System.out.print("Enter new password (or press Enter to keep current): ");
        String newPassword = scanner.nextLine().trim();
        if (!newPassword.isEmpty()) {
            user.setPassword(newPassword);
        }

        if (userService.updateUser(user)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Failed to update profile!");
        }
    }

    public void viewAllUsers() {
        System.out.println("\n=== All Users ===");

        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found!");
            return;
        }

        System.out.printf("%-10s %-20s %-25s %-15s %-20s%n",
                "User ID", "Name", "Email", "Phone", "Created Date");
        System.out.println("-------------------------------------------------------------------------------------");

        for (User user : users) {
            System.out.printf("%-10s %-20s %-25s %-15s %-20s%n",
                    user.getUserId(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getCreatedDate().toLocalDate());
        }
    }
}
