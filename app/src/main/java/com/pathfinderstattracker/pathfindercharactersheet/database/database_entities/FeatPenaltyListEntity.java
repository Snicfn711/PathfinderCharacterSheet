package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = FeatEntity.class,
                                   parentColumns = "featID",
                                   childColumns = "featID"),
                       @ForeignKey(entity = PenaltyEntity.class,
                                   parentColumns = "penaltyID",
                                   childColumns = "penaltyID")})
public class FeatPenaltyListEntity
{
        @PrimaryKey
        private int featBonusListID;
        @ColumnInfo(name = "featID")
        private int featID;
        @ColumnInfo(name = "penaltyID")
        private int penaltyID;

    //region Getters and Setters
    public int getFeatBonusListID()
    {
        return featBonusListID;
    }

    public void setFeatBonusListID(int featBonusListID)
    {
        this.featBonusListID = featBonusListID;
    }

    public int getFeatID()
    {
        return featID;
    }

    public void setFeatID(int featID)
    {
        this.featID = featID;
    }

    public int getPenaltyID()
    {
        return penaltyID;
    }

    public void setPenaltyID(int penaltyID)
    {
        this.penaltyID = penaltyID;
    }
    //endregion
}
