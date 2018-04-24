package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ISkill extends Comparable<ISkill>
{
    void setProficiency(boolean proficiency);
    boolean isProficiency();
    void setPointsInvested(int pointsInvested);
    int getPointsInvested();
    void setFavoredClassPointsInvested(int favoredClassPointsInvested);
    int getFavoredClassPointsInvested();
    void setAddedStat(AbilityScoreEnum addedStat);
    AbilityScoreEnum getAddedStat();
    void setArmorCheckPenaltyApplied(boolean armorCheckPenaltyApplied);
    boolean isArmorCheckPenaltyApplied();
    void setSkillName(String skillName);
    String getSkillName();
}
