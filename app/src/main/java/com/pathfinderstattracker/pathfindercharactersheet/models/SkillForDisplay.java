package com.pathfinderstattracker.pathfindercharactersheet.models;

import android.support.annotation.NonNull;

import java.util.UUID;

public class SkillForDisplay implements Comparable<SkillForDisplay>
{
    private AbilityScoreEnum AddedStat;

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

    public String getSkillName()
    {
        return SkillName;
    }

    public void setSkillName(String skillName)
    {
        SkillName = skillName;
    }

    public int getTotalSkillScore()
    {
        return TotalSkillScore;
    }

    public void setTotalSkillScore(int totalSkillScore)
    {
        TotalSkillScore = totalSkillScore;
    }

    private boolean ArmorCheckPenaltyApplied;
    private String SkillName;
    private int TotalSkillScore;

    public SkillForDisplay(AbilityScoreEnum addedStat, boolean armorCheckPenaltyApplied, String skillName, int totalSkillScore)
    {
        setAddedStat(addedStat);
        setArmorCheckPenaltyApplied(armorCheckPenaltyApplied);
        setSkillName(skillName);
        setTotalSkillScore(totalSkillScore);
    }

    @Override
    public int compareTo(@NonNull SkillForDisplay o)
    {
        SkillForDisplay temp = (SkillForDisplay)o;
        return this.SkillName.compareTo(temp.getSkillName());
    }
}
