package com.cruz.zoo;

import java.io.*;
import java.util.*;

public class AppUtils {

    public static void parseArrivingAnimals(String filename, ZooManager zooManager, Map<String, Queue<String>> nameMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 9) {
                    System.out.println("Invalid animal entry: " + line);
                    continue;
                }

                String species = parts[0].trim();
                String sex = parts[1].trim();
                int age;
                int weight;
                try {
                    age = Integer.parseInt(parts[2].trim());
                    weight = Integer.parseInt(parts[3].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in entry: " + line);
                    continue;
                }

                String birthDate = parts[4].trim();
                String color = parts[5].trim();
                String origin = parts[6].trim();
                String arrivalDate = parts[7].trim();
                String id = parts[8].trim();

                String name = nameMap.get(species).poll(); // Get next name for the species
                if (name == null) {
                    name = "Unknown"; // fallback if no name available
                }

                Animal animal;
                switch (species) {
                    case "Hyena":
                        animal = new Hyena(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                        break;
                    case "Lion":
                        animal = new Lion(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                        break;
                    case "Tiger":
                        animal = new Tiger(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                        break;
                    case "Bear":
                        animal = new Bear(sex, age, weight, name, id, birthDate, color, origin, arrivalDate);
                        break;
                    default:
                        System.out.println("Unknown species: " + species);
                        continue;
                }

                zooManager.addAnimal(animal);
            }
        } catch (IOException e) {
            System.out.println("Error reading arriving animals: " + e.getMessage());
        }
    }
}
