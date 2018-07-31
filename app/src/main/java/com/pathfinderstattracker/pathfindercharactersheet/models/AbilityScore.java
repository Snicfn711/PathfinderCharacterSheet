package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */
import java.io.Serializable;

public class AbilityScore implements IAbilityScore, Serializable
{
    private AbilityScoreEnum Stat;
    private int Amount;

    public void setAmount(int amount)
    {
        Amount = amount;
    }
    public void setStat(AbilityScoreEnum stat)
    {
        Stat = stat;
    }
    public int getAmount()
    {
        return Amount;
    }
    public AbilityScoreEnum getStat()
    {
        return Stat;
    }

    public AbilityScore()
    {
        //Default Constructor
    }
    public AbilityScore(AbilityScoreEnum stat, int amount)
    {
        setStat(stat);
        setAmount(amount);
    }

    public int calculateModifier()
    {
        if(Amount >= 10)
        {
            return (Amount - 10) / 2;
        }
        else
        {
            //For some reason, rounding isn't working like we need for negative numbers, rounding to the number closest to 0, instead of farthest (so -2.5 becomes -2 instead of -3)
            //And it's not really worth the time to look into the intricacies of math operations to find the right call, so we've split the call instead
            return (Amount - 11)/2;
        }
    }

    @Override
    public String toString()
    {
        return Integer.toString(Amount) + " " + Stat.toString();
    }
}
