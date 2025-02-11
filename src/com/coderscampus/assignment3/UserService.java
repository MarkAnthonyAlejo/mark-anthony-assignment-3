package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

  public List<User> readUsersFromFile(String fileName){
      List<User> users = new ArrayList<>();

      try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
          String line;

          while((line = bufferedReader.readLine()) != null) {

              String[] userData = line.split(",");

              if(userData.length == 3){
                  String username = userData[0].trim();
                  String password = userData[1].trim();
                  String name = userData[2].trim();
                  users.add(new User(username,password,name));
              }

          }
      } catch (IOException e) {
          System.err.println("Error reading file");
      }

      return users;

  }

  public boolean validateUser(String inputUsername, String inputPassword, List<User> users) {
      for(User user: users){
        if(user.getUsername().equalsIgnoreCase(inputUsername) && user.getPassword().equalsIgnoreCase(inputPassword)) {
              System.out.println("Welcome: " + user.getName());
              return true;
          }
      }
      return false;
  }

}
