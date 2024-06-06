package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Path path = Paths.get(file.toPath().toString());

        try {

            Map<String, String> linesMap = new HashMap<>();

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String line : lines) {
                String[] pairs = line.split(": ", 2);
                if (pairs.length == 2) {
                    linesMap.put(pairs[0].trim(), pairs[1].trim());
                }
            }

            String name = linesMap.get("Name");
            int age = Integer.parseInt(linesMap.get("Age"));
            String email = linesMap.get("Email");
            long phone = Long.parseLong(linesMap.get("Phone"));

            return new Profile(name, age, email, phone);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
