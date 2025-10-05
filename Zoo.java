package com.cruz.zoo;

import java.util.*;
import com.cruz.zoo.Animal;

public class Zoo {
    public static void main(String[] args) {
        List<Animal> zooAnimals = new ArrayList<>();

        // Correct Animal objects
        zooAnimals.add(new Animal(
                "Male",              // sex
                4,                   // age
                190,                 // weight (int only)
                "Simba",             // name
                "LION001",           // ID
                "2020-06-15",        // birthDate
                "Golden",            // color
                "Africa",            // origin
                "2021-03-01"         // arrivalDate
        ));

        zooAnimals.add(new Animal(
                "Male",
                17,
                5000,
                "Yeller",
                "ELEPH001",
                "2015-05-01",
                "Gray",
                "India",
                "2022-01-10"
        ));

        // Print all animals
        for (Animal a : zooAnimals) {
            System.out.println(a);
        }
    }
}
