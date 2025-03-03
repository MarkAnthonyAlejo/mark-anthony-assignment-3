package com.coderscampus.assignment3;

import java.util.Scanner;

public class LogInApp {
    public static void main(String[] ars){
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        UserService userService = new UserService();

        try(Scanner scanner = new Scanner(System.in)) {
            userService.loadUsers("data.txt");
            while (attempts < MAX_ATTEMPTS) {
                System.out.println("Enter username: ");
                String username = scanner.nextLine();

                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                User validUser = userService.validateUser(username, password);

                if (validUser != null) {
                    System.out.println("Welcome " + validUser.getName());
                    return;
                } else {
                    attempts++;
                    System.out.println("Invalid login, pleaser try again.");
                }

            }
            System.out.println("Too many failed login attempts, you are lock out.");
        }
    }
}
