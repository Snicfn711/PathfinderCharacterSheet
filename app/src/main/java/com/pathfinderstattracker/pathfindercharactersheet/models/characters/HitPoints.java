package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class HitPoints implements IHitPoints
{
    int FavoredClassPointsInvested;
    int Value;

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
        FavoredClassPointsInvested = pointsInvested;
    }

    @Override
    public int getFavoredClassPointsInvested()
    {
        return FavoredClassPointsInvested;
    }

    @Override
    public void setValue(int value)
    {
        Value = value;
    }

    @Override
    public int getValue()
    {
        return Value;
    }
}
