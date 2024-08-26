package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Matter> entities = MatterGenerator.generateMatters();
        List<String> matchingFields = Arrays.asList("matterType", "matterSubtype", "jurisdiction", "matterOwner", "matterClient");

        for (Matter entity : entities) {
            System.out.println(entity);
        }
    }
}