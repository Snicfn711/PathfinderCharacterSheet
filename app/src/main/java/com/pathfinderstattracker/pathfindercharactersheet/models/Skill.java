package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class Skill implements ISkill
{
    public boolean Proficiency;
    public int PointsInvested;
    public int FavoredClassPointsInvested;
    public AbilityScoreEnum AddedStat;
    public boolean ArmorCheckPenaltyApplied;
}
