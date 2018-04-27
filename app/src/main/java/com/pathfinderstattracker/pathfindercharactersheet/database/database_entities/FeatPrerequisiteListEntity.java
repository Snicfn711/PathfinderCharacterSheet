package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = FeatEntity.class,
                                   parentColumns = "featID",
                                   childColumns = "featID"),
                       @ForeignKey(entity = PrerequisiteEntity.class,
                                   parentColumns = "prerequisiteID",
                                   childColumns = "prerequisiteID")},
        indices = {@Index("featID"),
                   @Index("prerequisiteID")})

public class FeatPrerequisiteListEntity
{
    @PrimaryKey
    private int featPrerequisiteListID;
    @ColumnInfo(name = "featID")
    private int featID;
    @ColumnInfo(name = "prerequisiteID")
    private int prerequisiteID;

    //region Getters and Setters
    public int getFeatPrerequisiteListID()
    {
        return featPrerequisiteListID;
    }

    public void setFeatPrerequisiteListID(int featPrerequisiteListID)
    {
        this.featPrerequisiteListID = featPrerequisiteListID;
    }

    public int getFeatID()
    {
        return featID;
    }

    public void setFeatID(int featID)
    {
        this.featID = featID;
    }

    public int getPrerequisiteID()
    {
        return prerequisiteID;
    }

    public void setPrerequisiteID(int prerequisiteID)
    {
        this.prerequisiteID = prerequisiteID;
    }
    //endregion
}
