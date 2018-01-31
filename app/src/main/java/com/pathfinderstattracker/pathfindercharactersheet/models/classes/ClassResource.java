package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class ClassResource implements IClassResource
{
    public String Name;
    public AbilityScoreEnum AddedStat;
    public int StartingLevel;
    public String Formula; //It looks like Java has a scriptmanager object for interpreting this
    public boolean HasMinimumValue;
}
