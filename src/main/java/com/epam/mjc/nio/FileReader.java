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
                }

            }
            bufferedReader.close();
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Path path = Paths.get(file.toPath().toString());

//        try {
//
//            Map<String, String> linesMap = new HashMap<>();
//
//            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
//
//            for (String line : lines) {
//                String[] pairs = line.split(": ", 2);
//                if (pairs.length == 2) {
//                    linesMap.put(pairs[0].trim(), pairs[1].trim());
//                }
//            }
//
//            String name = linesMap.get("Name");
//            int age = Integer.parseInt(linesMap.get("Age"));
//            String email = linesMap.get("Email");
//            long phone = Long.parseLong(linesMap.get("Phone"));
//
//            return new Profile(name, age, email, phone);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
