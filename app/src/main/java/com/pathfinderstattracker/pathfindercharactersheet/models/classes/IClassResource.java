package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IClassResource
{
    String Name = null;
    AbilityScoreEnum AddedStat = AbilityScoreEnum.Strength;
    int StartingLevel = 0;
    String Formula = null; //It looks like Java has a scriptmanager object for interpreting this
    boolean HasMinimumValue = false;
}
