package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.toPath().toString()));

            String currentline;

            String name = "";
            int age = 0;
            String email = "";
            long phone = 0;

            while ((currentline = bufferedReader.readLine()) != null) {
                String[] strings = currentline.split(": ");

                switch (strings[0]) {
                    case "Name":
                        name = strings[1];
                        break;
                    case "Age":
                        age = Integer.parseInt(strings[1]);
                        break;
                    case "Email":
                        email = strings[1];
                        break;
                    case "Phone":
                        phone = Long.parseLong(strings[1]);
                        break;
                    default:
                        System.out.println("Default in swith");
                        break;
                }

            }
            bufferedReader.close();
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
