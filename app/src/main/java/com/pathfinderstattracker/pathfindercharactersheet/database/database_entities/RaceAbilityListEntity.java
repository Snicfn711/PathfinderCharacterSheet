package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/30/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "abilityID"),
                       @ForeignKey(entity = RaceEntity.class,
                                   parentColumns = "raceID",
                                   childColumns = "raceID")},
        indices = {@Index("abilityID"),
                   @Index("raceID")})
public class RaceAbilityListEntity
{
    @PrimaryKey
    private int raceAbilityListID;
    @ColumnInfo(name = "raceID")
    private int raceID;
    @ColumnInfo(name = "abilityID")
    private int abilityID;

    //region Getters and Setters
    public int getRaceAbilityListID()
    {
        return raceAbilityListID;
    }

    public void setRaceAbilityListID(int raceAbilityListID)
    {
        this.raceAbilityListID = raceAbilityListID;
    }

    public int getRaceID()
    {
        return raceID;
    }

    public void setRaceID(int raceID)
    {
        this.raceID = raceID;
    }

    public int getAbilityID()
    {
        return abilityID;
    }

    public void setAbilityID(int abilityID)
    {
        this.abilityID = abilityID;
    }
    //endregion
}
