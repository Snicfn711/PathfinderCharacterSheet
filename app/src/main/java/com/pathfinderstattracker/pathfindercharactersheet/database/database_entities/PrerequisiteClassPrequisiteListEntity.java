package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = ClassPrerequisiteEntity.class,
                                   parentColumns = "classPrerequisiteID",
                                   childColumns = "classPrerequisiteID"),
                       @ForeignKey(entity = PrerequisiteEntity.class,
                                   parentColumns = "prerequisiteID",
                                   childColumns = "prerequisiteID")},
        indices = {@Index("classPrerequisiteID"),
                   @Index("prerequisiteID")})
public class PrerequisiteClassPrequisiteListEntity
{
    @PrimaryKey
    private int prerequisiteClassPrequisiteListID;
    @ColumnInfo(name = "prerequisiteID")
    private int prerequisiteID;
    @ColumnInfo(name = "classPrerequisiteID")
    private int classPrerequisiteID;

    //region Getters and Setters
    public int getPrerequisiteClassPrequisiteListID()
    {
        return prerequisiteClassPrequisiteListID;
    }

    public void setPrerequisiteClassPrequisiteListID(int prerequisiteClassPrequisiteListID)
    {
        this.prerequisiteClassPrequisiteListID = prerequisiteClassPrequisiteListID;
    }

    public int getPrerequisiteID()
    {
        return prerequisiteID;
    }

    public void setPrerequisiteID(int prerequisiteID)
    {
        this.prerequisiteID = prerequisiteID;
    }

    public int getClassPrerequisiteID()
    {
        return classPrerequisiteID;
    }

    public void setClassPrerequisiteID(int classPrerequisiteID)
    {
        this.classPrerequisiteID = classPrerequisiteID;
    }
    //endregion
}
