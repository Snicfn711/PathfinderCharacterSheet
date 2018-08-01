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

            //While this is technically more complicated than our previous solution of (Amount - 11)/2, we're keeping it because it more clearly shows what's being done.
            //This solution also more properly utilizes our math functions, rather than relying on a quirk of integer division.
            return (int)Math.floor((Amount - 10.0)/2.0);
        }
    }

    @Override
    public String toString()
    {
        return Integer.toString(Amount) + " " + Stat.toString();
    }
}
