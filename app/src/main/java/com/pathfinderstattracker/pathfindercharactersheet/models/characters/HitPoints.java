package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */
import java.io.Serializable;

public class HitPoints implements IHitPoints, Serializable
{
    int favoredClassPointsInvested;
    int value;

    public HitPoints()
    {
        //Default Constructor
    }
    public HitPoints(int favoredClassPointsInvested, int value)
    {
        setFavoredClassPointsInvested(favoredClassPointsInvested);
        setValue(value);
    }

    @Override
    public void setFavoredClassPointsInvested(int pointsInvested)
    {
        favoredClassPointsInvested = pointsInvested;
    }

    @Override
    public int getFavoredClassPointsInvested()
    {
        return favoredClassPointsInvested;
    }

    @Override
    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return Integer.toString(value) + " total hit points / " + Integer.toString(favoredClassPointsInvested) + " from favored class";
    }
}
