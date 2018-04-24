package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Damage
{
    private int numberOfDice;
    private int sizeOfDice;

    public int getNumberOfDice()
    {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice)
    {
        this.numberOfDice = numberOfDice;
    }

    public int getSizeOfDice()
    {
        return sizeOfDice;
    }

    public void setSizeOfDice(int sizeOfDice)
    {
        this.sizeOfDice = sizeOfDice;
    }

    public Damage()
    {
        numberOfDice = 0;
        sizeOfDice = 0;
    }

    public Damage(int number, int size)
    {
        setNumberOfDice(number);
        setSizeOfDice(size);
    }

    @Override
    public String toString()
    {
        return Integer.toString(numberOfDice) + "d" + Integer.toString(sizeOfDice);
    }
}
