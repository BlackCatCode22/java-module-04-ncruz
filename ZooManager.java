package com.cruz.zoo;

import java.util.*;
import java.io.*;

public class ZooManager {
    private Map<String, List<Animal>> zooPopulation;

    public ZooManager() {
        zooPopulation = new HashMap<>();
        zooPopulation.put("Hyena", new ArrayList<>());
        zooPopulation.put("Lion", new ArrayList<>());
        zooPopulation.put("Tiger", new ArrayList<>());
        zooPopulation.put("Bear", new ArrayList<>());
    }

    public void addAnimal(Animal animal) {
        String species = animal.getClass().getSimpleName();
        zooPopulation.get(species).add(animal);
    }

    public void printAnimalCounts() {
        System.out.println("******** Animal Counts ********");
        for (Map.Entry<String, List<Animal>> entry : zooPopulation.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }
    }

    public void printHabitatReport() {
        System.out.println("\n******* Zoo Population and Habitat Assignment Report ********");
        for (Map.Entry<String, List<Animal>> entry : zooPopulation.entrySet()) {
            System.out.println("\n" + entry.getKey() + " Habitat:\n");
            for (Animal a : entry.getValue()) {
                System.out.println(a);
            }
        }
    }

    public void writeReportToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("******* Zoo Population and Habitat Assignment Report ********");
            for (Map.Entry<String, List<Animal>> entry : zooPopulation.entrySet()) {
                writer.println("\n" + entry.getKey() + " Habitat:\n");
                for (Animal a : entry.getValue()) {
                    writer.println(a);
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}
