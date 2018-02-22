package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class Skill implements ISkill
{
    private boolean Proficiency;
    private int PointsInvested;
    private int FavoredClassPointsInvested;
    private AbilityScoreEnum AddedStat;
    private boolean ArmorCheckPenaltyApplied;
    private String SkillName;

    public boolean isProficiency()
    {
        return Proficiency;
    }

    public void setProficiency(boolean proficiency)
    {
        Proficiency = proficiency;
    }

    public int getPointsInvested()
    {
        return PointsInvested;
    }

    public void setPointsInvested(int pointsInvested)
    {
        PointsInvested = pointsInvested;
    }

    public int getFavoredClassPointsInvested()
    {
        return FavoredClassPointsInvested;
    }

    public void setFavoredClassPointsInvested(int favoredClassPointsInvested)
    {
        FavoredClassPointsInvested = favoredClassPointsInvested;
    }

    public AbilityScoreEnum getAddedStat()
    {
        return AddedStat;
    }

    public void setAddedStat(AbilityScoreEnum addedStat)
    {
        AddedStat = addedStat;
    }

    public boolean isArmorCheckPenaltyApplied()
    {
        return ArmorCheckPenaltyApplied;
    }

    public void setArmorCheckPenaltyApplied(boolean armorCheckPenaltyApplied)
    {
        ArmorCheckPenaltyApplied = armorCheckPenaltyApplied;
    }

    @Override
    public void setSkillName(String skillName)
    {
        SkillName = skillName;
    }

    @Override
    public String getSkillName()
    {
        return SkillName;
    }

    public Skill(String skillName, boolean proficiency, int pointsInvested, int favoredClassPointsInvested, AbilityScoreEnum addedStat, boolean armorCheckPenaltyApplied)
    {
        setProficiency(proficiency);
        setPointsInvested(pointsInvested);
        setFavoredClassPointsInvested(favoredClassPointsInvested);
        setAddedStat(addedStat);
        setArmorCheckPenaltyApplied(armorCheckPenaltyApplied);
        setSkillName(skillName);
    }
}
