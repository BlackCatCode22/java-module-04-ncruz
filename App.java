package com.cruz.zoo;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Zoo Keeper Challenge!\n");

        ZooManager zooManager = new ZooManager();
        Map<String, Queue<String>> nameMap = loadAnimalNames("animalNames.txt");

        AppUtils.parseArrivingAnimals("arrivingAnimals.txt", zooManager, nameMap);

        zooManager.printAnimalCounts();
        zooManager.printHabitatReport();

        zooManager.writeReportToFile("zooPopulation.txt");
    }

    public static Map<String, Queue<String>> loadAnimalNames(String fileName) {
        Map<String, Queue<String>> nameMap = new HashMap<>();
        nameMap.put("Hyena", new LinkedList<>());
        nameMap.put("Lion", new LinkedList<>());
        nameMap.put("Tiger", new LinkedList<>());
        nameMap.put("Bear", new LinkedList<>());

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String currentSpecies = null;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Hyena")) currentSpecies = "Hyena";
                else if (line.contains("Lion")) currentSpecies = "Lion";
                else if (line.contains("Tiger")) currentSpecies = "Tiger";
                else if (line.contains("Bear")) currentSpecies = "Bear";
                else if (!line.trim().isEmpty() && currentSpecies != null) {
                    String[] names = line.split(",");
                    for (String name : names) {
                        nameMap.get(currentSpecies).add(name.trim());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading animalNames.txt: " + e.getMessage());
        }

        return nameMap;
    }
}
