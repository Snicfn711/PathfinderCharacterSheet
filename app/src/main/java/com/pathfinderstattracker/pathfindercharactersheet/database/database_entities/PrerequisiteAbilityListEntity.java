package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "abilityID"),
                       @ForeignKey(entity = PrerequisiteEntity.class,
                                   parentColumns = "prerequisiteID",
                                   childColumns = "prerequisiteID")},
        indices = {@Index("abilityID"),
                   @Index("prerequisiteID")})
public class PrerequisiteAbilityListEntity
{
    @PrimaryKey
    private int prerequisiteAbilityListID;
    @ColumnInfo(name = "prerequisiteID")
    private int prerequisiteID;
    @ColumnInfo(name = "abilityID")
    private int abilityID;
}
