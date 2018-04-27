package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class AbilityScore implements IAbilityScore
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

    @Override
    public String toString()
    {
        return Integer.toString(Amount) + " " + Stat.toString();
    }
}
