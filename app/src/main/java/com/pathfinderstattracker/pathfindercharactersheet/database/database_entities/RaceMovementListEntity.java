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
                       @ForeignKey(entity = MovementEntity.class,
                                   parentColumns = "movementID",
                                   childColumns = "movementID")},
        indices = {@Index("raceID"),
                   @Index("movementID")})
public class RaceMovementListEntity
{
    @PrimaryKey
    private int raceMovementListID;
    @ColumnInfo(name = "raceID")
    private int raceID;
    @ColumnInfo(name = "movementID")
    private int movementID;

    //region Getters and Setters
    public int getRaceMovementListID()
    {
        return raceMovementListID;
    }

    public void setRaceMovementListID(int raceMovementListID)
    {
        this.raceMovementListID = raceMovementListID;
    }

    public int getRaceID()
    {
        return raceID;
    }

    public void setRaceID(int raceID)
    {
        this.raceID = raceID;
    }

    public int getMovementID()
    {
        return movementID;
    }

    public void setMovementID(int movementID)
    {
        this.movementID = movementID;
    }
    //endregion
}
