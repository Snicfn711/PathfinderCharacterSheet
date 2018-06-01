package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IHitPoints
{
    void setFavoredClassPointsInvested(int pointsInvested);
    int getFavoredClassPointsInvested();
    void setValue(int value);
    int getValue();
}
