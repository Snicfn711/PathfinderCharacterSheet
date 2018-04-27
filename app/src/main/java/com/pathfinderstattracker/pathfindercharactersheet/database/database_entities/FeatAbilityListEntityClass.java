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
                       @ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "abilityID")},
        indices = {@Index("featID"),
                   @Index("abilityID")})
public class FeatAbilityListEntityClass
{
    @PrimaryKey
    private int featListID;
    @ColumnInfo(name = "featID")
    private int featID;
    @ColumnInfo(name = "abilityID")
    private int abilityID;

    //region Getters and Setters
    public int getFeatListID()
    {
        return featListID;
    }

    public void setFeatListID(int featListID)
    {
        this.featListID = featListID;
    }

    public int getFeatID()
    {
        return featID;
    }

    public void setFeatID(int featID)
    {
        this.featID = featID;
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
