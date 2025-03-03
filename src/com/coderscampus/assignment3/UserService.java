package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {
    private static final User[] users = new User[4];

    public void loadUsers(String fileName){
        FileService fileService = new FileService();
        String[] lines = fileService.readFile(fileName);
        int index = 0;
        for(String line:  lines){
            String[] splitLine = line.split(",");
            String username = splitLine[0];
            String password = splitLine[1];
            String name = splitLine[2];
            User user = new User(username,password,name);
            users[index++] = user;
        }
    }


    public User validateUser(String username, String password) {
        for(User user: users){
           if(user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
               return user;
           }
       }
       return null;
    }
}
