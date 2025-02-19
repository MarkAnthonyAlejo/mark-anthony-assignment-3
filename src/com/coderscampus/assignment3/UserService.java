package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

    public User[] userService(String fileName){

        User[] users = new User[4];

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null){
                String[] splitLine = line.split(",");
                String username = splitLine[0];
                String password = splitLine[1];
                String name = splitLine[2];
                User user = new User(username,password,name);
                users[index] = user;
                index++;
            }
        } catch (FileNotFoundException e){
            System.err.println("File not found " + fileName);
        } catch (IOException e){
            System.err.println("IOException " + e);
        }
        return users;
    }


    public static User validateUser(User[] users, String username, String password) {
        for(User user: users){
           if(user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
               return user;
           }
       }
       return null;
    }
}
