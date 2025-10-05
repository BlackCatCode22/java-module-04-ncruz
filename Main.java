package com.cruz.zoo;

import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Zoo Keeper Challenge\n");

        ZooManager zooManager = new ZooManager();

        // Load names from animalNames.txt
        Map<String, Queue<String>> nameMap = App.loadAnimalNames("animalNames.txt");

        // Parse arriving animals
        AppUtils.parseArrivingAnimals("arrivingAnimals.txt", zooManager, nameMap);

        // Print report
        zooManager.printAnimalCounts();
        zooManager.printHabitatReport();

        // Optional: save report to file
        zooManager.writeReportToFile("zooPopulation.txt");
    }
}
