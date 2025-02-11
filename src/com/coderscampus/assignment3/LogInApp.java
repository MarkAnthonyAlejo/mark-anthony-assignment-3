package com.coderscampus.assignment3;

import java.util.List;
import java.util.Scanner;

public class LogInApp {
    public static void main(String[] ars){

        int attempts = 0;
        final int MAX_ATTEMPTS = 5;
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        List<User> users = userService.readUsersFromFile("data.txt");

        while(attempts < MAX_ATTEMPTS){

            System.out.println("Enter username: ");
            username = scanner.nextLine();

            System.out.println("Enter password: ");
            password = scanner.nextLine();

            boolean isValid = userService.validateUser(username, password,users);

            if(isValid){
                break;
            } else {
                attempts++;
                System.out.println("Invalid login, pleaser try again.");
            }

            if(attempts == MAX_ATTEMPTS){
                System.out.println("Too many failed login attempts, you are lock out.");
                break;
            }

        }

        scanner.close();

    }
}
