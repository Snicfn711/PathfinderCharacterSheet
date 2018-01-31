package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public interface IPenalty
{
    Object[] objectsAffected = null;
    double value = 0;
    String conditions = " ";
    Object source = null;
}
