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
}
