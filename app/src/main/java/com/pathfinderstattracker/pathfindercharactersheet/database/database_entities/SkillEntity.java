package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

@Entity
@TypeConverters(AbilityScoreEnumConverter.class)
public class SkillEntity
{
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "proficiency")
    private boolean Proficiency;
    @ColumnInfo(name = "points_invested")
    private int PointsInvested;
    @ColumnInfo(name = "favored_class_points_invested")
    private int FavoredClassPointsInvested;
    @ColumnInfo(name = "added_stat")
    private AbilityScoreEnum AddedStat;
    @ColumnInfo(name = "armor_check_penalty_applied")
    private boolean ArmorCheckPenaltyApplied;
    @ColumnInfo(name = "skill_name")
    private String SkillName;

    //region Getters and Setters
    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

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