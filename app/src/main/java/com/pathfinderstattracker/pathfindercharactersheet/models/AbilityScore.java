package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class AbilityScore implements IAbilityScore
{
    AbilityScoreEnum Stat;
    int Amount;

    public AbilityScore()
    {
        //Default Constructor
    }
    public AbilityScore(AbilityScoreEnum stat, int amount)
    {
        setStat(stat);
        setAmount(amount);
    }

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

}
