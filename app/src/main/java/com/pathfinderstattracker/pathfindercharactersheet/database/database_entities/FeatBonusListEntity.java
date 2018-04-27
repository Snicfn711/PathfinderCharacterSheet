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
                       @ForeignKey(entity = BonusEntity.class,
                                   parentColumns = "bonusID",
                                   childColumns = "bonusID")})
public class FeatBonusListEntity
{
    @PrimaryKey
    private int featBonusListID;
    @ColumnInfo(name = "featID")
    private int featID;
    @ColumnInfo(name = "bonusID")
    private int bonusID;

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

    public int getBonusID()
    {
        return bonusID;
    }

    public void setBonusID(int bonusID)
    {
        this.bonusID = bonusID;
    }
    //endregion
}
