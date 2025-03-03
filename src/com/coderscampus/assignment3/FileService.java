package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

    public String[] readFile(String fileName){
        String[] fileData = new String[4];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                fileData[index++] = line;
            }
        } catch (IOException e) {
            System.out.println("Oops, there was an error reading the file: " + e.getMessage());
        }
        return fileData;
    }
}
