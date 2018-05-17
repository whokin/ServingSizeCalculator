package com.example.niragmehta.assignment2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by niragmehta on 2018-01-28.
 */
public class PotTest {



    @Test
    public void getWeightInG() throws Exception {        Pot pot=new Pot("Gohan",1000);
        assertEquals(1000,pot.getWeightInG());
    }

    @Test
    public void setWeightInG() throws Exception {
        Pot pot=new Pot("Piccolo",600);
        pot.setWeightInG(700);
        assertEquals(700,pot.getWeightInG());

    }

    @Test
    public void getName() throws Exception {
        Pot pot=new Pot("Goku",5200);
        assertEquals("Goku",pot.getName());
    }

    @Test
    public void setName() throws Exception {
        Pot pot=new Pot("Krillin",500);
        pot.setName("Vegeta");
        assertEquals("Vegeta",pot.getName());
    }



}