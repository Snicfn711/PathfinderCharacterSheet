package com.pathfinderstattracker.pathfindercharactersheet.models.spells;

/**
 * Created by Stephen Hagen on 1/9/2018.
 */

public class SpellDuration implements ISpellDuration
{

    private SpellDurationEnum spellDuration;
    private Integer NumberOfIncrements;
    private String TimeIncrement;

    //region Getters and Setters
    @Override
    public SpellDurationEnum getSpellDuration()
    {
        return spellDuration;
    }

    @Override
    public void setSpellDuration(SpellDurationEnum spellDuration)
    {
        this.spellDuration = spellDuration;
    }

    @Override
    public Integer getNumberOfIncrements()
    {
        return NumberOfIncrements;
    }

    @Override
    public void setNumberOfIncrements(Integer numberOfIncrements)
    {
        NumberOfIncrements = numberOfIncrements;
    }

    @Override
    public String getTimeIncrement()
    {
        return TimeIncrement;
    }

    @Override
    public void setTimeIncrement(String timeIncrement)
    {
        TimeIncrement = timeIncrement;
    }
    //endregion

    public SpellDuration()
    {
        //Default constructor
    }

    public SpellDuration(SpellDurationEnum spellDuration, Integer numberOfIncrements, String timeIncrement)
    {
        setSpellDuration(spellDuration);
        setNumberOfIncrements(numberOfIncrements);
        setTimeIncrement(timeIncrement);
    }

    @Override
    public String toString()
    {
        return spellDuration.toString();
        //Todo:This is a vastly over-simplified version of how duration works, fix it later
    }
}
