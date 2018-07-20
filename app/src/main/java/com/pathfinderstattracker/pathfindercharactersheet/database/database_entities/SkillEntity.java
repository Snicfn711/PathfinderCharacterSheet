package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

import java.util.UUID;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

@Entity(tableName = "skills")
@TypeConverters({AbilityScoreEnumConverter.class,
                 UUIDConverter.class})
public class SkillEntity
{
    //This entity is primarily used for initializing a default skill set for new characters. Afterward we'll reference the PlayerSkillEntity.
    //This will allow players to add their own custom skills later on.
    @PrimaryKey
    @NonNull
    private UUID skillID;
    @ColumnInfo(name = "added_stat")
    private AbilityScoreEnum AddedStat;
    @ColumnInfo(name = "armor_check_penalty_applied")
    private boolean ArmorCheckPenaltyApplied;
    @ColumnInfo(name = "skill_name")
    private String SkillName;

    //region Getters and Setters
    public UUID getSkillID()
    {
        return skillID;
    }

    public void setSkillID(UUID skillID)
    {
        this.skillID = skillID;
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

    public String getSkillName()
    {
        return SkillName;
    }

    public void setSkillName(String skillName)
    {
        SkillName = skillName;
    }
    //endregion
}
