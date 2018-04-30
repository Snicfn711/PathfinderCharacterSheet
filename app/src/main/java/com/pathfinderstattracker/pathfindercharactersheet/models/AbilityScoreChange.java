package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class AbilityScoreChange implements IAbilityScoreChange
{
    private AbilityScoreEnum StatChanged;
    private int AmountChanged;

    //region Getters and Setters
    public AbilityScoreEnum getStatChanged()
    {
        return StatChanged;
    }

    public void setStatChanged(AbilityScoreEnum statChanged)
    {
        StatChanged = statChanged;
    }

    public int getAmountChanged()
    {
        return AmountChanged;
    }

    public void setAmountChanged(int amountChanged)
    {
        AmountChanged = amountChanged;
    }
    //endregion

    public AbilityScoreChange()
    {
        //Default Constructor
    }

    public AbilityScoreChange(AbilityScoreEnum statChanged, int amountChanged)
    {
        setStatChanged(statChanged);
        setAmountChanged(amountChanged);
    }

    @Override
    public String toString()
    {
        return Integer.toString(AmountChanged) + " " + StatChanged.toString();
    }
}
