package com.pathfinderstattracker.pathfindercharactersheet.models;

import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ISkill extends Comparable<ISkill>
{
    UUID getSkillID();
    void setSkillID(UUID skillID);
    void setAddedStat(AbilityScoreEnum addedStat);
    AbilityScoreEnum getAddedStat();
    void setArmorCheckPenaltyApplied(boolean armorCheckPenaltyApplied);
    boolean isArmorCheckPenaltyApplied();
    void setSkillName(String skillName);
    String getSkillName();
}
