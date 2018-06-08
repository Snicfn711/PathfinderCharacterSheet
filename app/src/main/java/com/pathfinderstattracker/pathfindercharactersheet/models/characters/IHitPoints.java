package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */
import java.io.Serializable;

public interface IHitPoints extends Serializable
{
    void setFavoredClassPointsInvested(int pointsInvested);
    int getFavoredClassPointsInvested();
    void setValue(int value);
    int getValue();
}
