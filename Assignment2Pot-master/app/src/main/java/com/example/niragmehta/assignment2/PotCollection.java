package com.example.niragmehta.assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage a collection of pots.
 */

public class PotCollection {
    private List<Pot> pots = new ArrayList<>();

    public List<Pot> getPots()
    {
        return pots;
    }

    public void addPot(Pot pot)
    {
        pots.add(pot);
    }

    public void changePot(Pot pot, int indexOfPotEditing) {
        validateIndexWithException(indexOfPotEditing);
        pots.remove(indexOfPotEditing);
        pots.add(indexOfPotEditing, pot);
    }

    public int countPots() {
        return pots.size();
    }

    public Pot getPot(int index) {
        validateIndexWithException(index);
        return pots.get(index);
    }

    // Useful for integrating with an ArrayAdapter
    public String[] getPotDescriptions() {
        String[] descriptions = new String[countPots()];
        for (int i = 0; i < countPots(); i++) {
            Pot pot = getPot(i);
            descriptions[i] = pot.getName() + " - " + pot.getWeightInG() + "g";
        }
        return descriptions;
    }

    private void validateIndexWithException(int index) {
        if (index < 0 || index >= countPots()) {
            throw new IllegalArgumentException();
        }

    }

    public void removePot(int index){
        pots.remove(index);
    }
}