package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

@Entity(foreignKeys = {@ForeignKey(entity = RaceEntity.class,
                                   parentColumns = "raceID",
                                   childColumns = "raceID"),
                       @ForeignKey(entity = SenseEntity.class,
                                   parentColumns = "senseID",
                                   childColumns = "senseID")},
        indices = {@Index("raceID"),
                   @Index("senseID")})
public class RaceSenseListEntity
{
    @PrimaryKey
    private int raceSenseListID;
    @ColumnInfo(name = "raceID")
    private int raceID;
    @ColumnInfo(name = "senseID")
    private int senseID;

    //region Getters and Setters
    public int getRaceSenseListID()
    {
        return raceSenseListID;
    }

    public void setRaceSenseListID(int raceSenseListID)
    {
        this.raceSenseListID = raceSenseListID;
    }

    public int getRaceID()
    {
        return raceID;
    }

    public void setRaceID(int raceID)
    {
        this.raceID = raceID;
    }

    public int getSenseID()
    {
        return senseID;
    }

    public void setSenseID(int senseID)
    {
        this.senseID = senseID;
    }
    //endregion
}
