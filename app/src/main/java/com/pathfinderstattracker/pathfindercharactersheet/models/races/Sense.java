package com.pathfinderstattracker.pathfindercharactersheet.models.races;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Sense implements ISense
{
    private String Name;
    private int Distance;
    private String EffectText;

    //region Getters and Setters
    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getDistance()
    {
        return Distance;
    }

    public void setDistance(int distance)
    {
        Distance = distance;
    }

    public String getEffectText()
    {
        return EffectText;
    }

    public void setEffectText(String effectText)
    {
        EffectText = effectText;
    }
    //endregion

    public Sense()
    {
        //Default Constructor
    }

    public Sense(String name, int distance, String effectText)
    {
        setName(name);
        setDistance(distance);
        setEffectText(effectText);
    }
}
