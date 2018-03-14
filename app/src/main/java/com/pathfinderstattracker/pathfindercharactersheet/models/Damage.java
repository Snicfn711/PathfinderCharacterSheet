package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Damage
{
    public int numberOfDice;
    public int sizeOfDice;

    public Damage()
    {
        numberOfDice = 0;
        sizeOfDice = 0;
    }

    public Damage(int number, int size)
    {
        numberOfDice = number;
        sizeOfDice = size;
    }
}
