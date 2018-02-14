package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ISkill
{
    boolean Proficiency = false;
    int PointsInvested = 0;
    int FavoredClassPointsInvested = 0;
    AbilityScoreEnum AddedStat = AbilityScoreEnum.STR;
    boolean ArmorCheckPenaltyApplied = false;
}
