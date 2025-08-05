package org.demo.Ui;

import org.demo.Model.User;
import org.demo.Repository.UserRepository;
import org.demo.Repository.UserRepositoryImpl;
import org.demo.Service.UserService;
import org.demo.Service.UserServiceImpl;

import java.util.Scanner;

public class UserUI {
    private final Scanner sc = new Scanner(System.in);
    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    public void registerUser() {
        System.out.println("Enter Full Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("Enter Phone number: ");
        String phoneNumber = sc.nextLine();

        User user = new User(name, email, phoneNumber, password);
        boolean success = userService.registerUser(user);

        if (success) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("User already exists.");
        }
    }

    public void loginUser() {
        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        User user = userService.loginUser(email, password);
        if (user != null) {
            System.out.println("Login successful. Welcome " + user.getName());
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}