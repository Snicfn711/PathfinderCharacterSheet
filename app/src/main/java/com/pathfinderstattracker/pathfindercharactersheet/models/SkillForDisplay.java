package com.pathfinderstattracker.pathfindercharactersheet.models;

import android.support.annotation.NonNull;

import java.util.UUID;

public class SkillForDisplay implements Comparable<SkillForDisplay>
{
    private UUID SkillID;
    private AbilityScoreEnum AddedStat;
    private boolean ArmorCheckPenaltyApplied;
    private String SkillName;
    private int TotalSkillScore;

    public UUID getSkillID(){return SkillID;}
    public void setSkillID(UUID skillID){SkillID = skillID;}
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

    public SkillForDisplay(UUID SkillID, AbilityScoreEnum addedStat, boolean armorCheckPenaltyApplied, String skillName, int totalSkillScore)
    {
        setSkillID(SkillID);
        setAddedStat(addedStat);
        setArmorCheckPenaltyApplied(armorCheckPenaltyApplied);
        setSkillName(skillName);
        setTotalSkillScore(totalSkillScore);
    }

    @Override
    public int compareTo(@NonNull SkillForDisplay o)
    {
        SkillForDisplay temp = o;
        return this.SkillName.compareTo(temp.getSkillName());
    }
}
