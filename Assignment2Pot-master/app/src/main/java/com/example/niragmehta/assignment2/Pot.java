package com.example.niragmehta.assignment2;

/**
 * Store information about a single pot
 */

public class Pot {

    private int weight;
    private String name;

    // Set member data based on parameters.
    public Pot(String name, int weightInG) {
        this.name=name;
        this.weight=weightInG;
    }


    // Return the weight
    public int getWeightInG() {
        return weight;
    }

    // Set the weight. Throws IllegalArgumentException if weight is less than 0.
    public void setWeightInG(int weightInG) {
        this.weight=weightInG;
    }

    // Return the name.
    public String getName() {
        return name;
    }


    // Set the name. Throws IllegalArgumentException if name is an empty string (length 0),
    // or if name is a null-reference.
    public void setName(String name) {
        this.name=name;
    }


}