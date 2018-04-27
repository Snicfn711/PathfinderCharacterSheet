package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class ClassResource implements IClassResource
{
    private String Name;
    private AbilityScoreEnum AddedStat;
    private int StartingLevel;
    private String Formula; //It looks like Java has a scriptmanager object for interpreting this
    private int MinimumValue;
    private int MinimumLevel;

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public AbilityScoreEnum getAddedStat()
    {
        return AddedStat;
    }

    public void setAddedStat(AbilityScoreEnum addedStat)
    {
        AddedStat = addedStat;
    }

    public int getStartingLevel()
    {
        return StartingLevel;
    }

    public void setStartingLevel(int startingLevel)
    {
        StartingLevel = startingLevel;
    }

    public String getFormula()
    {
        return Formula;
    }

    public void setFormula(String formula)
    {
        Formula = formula;
    }

    public int getMinimumValue()
    {
        return MinimumValue;
    }

    public void setMinimumValue(int minimumValue)
    {
        MinimumValue = minimumValue;
    }

    public int getMinimumLevel()
    {
        return MinimumLevel;
    }

    public void setMinimumLevel(int minimumLevel)
    {
        MinimumLevel = minimumLevel;
    }
}
