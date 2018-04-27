package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity(foreignKeys = {@ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "abilityID"),
                       @ForeignKey(entity = PenaltyEntity.class,
                                   parentColumns = "penaltyID",
                                   childColumns = "penaltyID")})
public class AbilityPenaltyListEntity
{
    @PrimaryKey
    private int abilityPenaltyListID;
    @ColumnInfo(name = "abilityID")
    private int abilityID;
    @ColumnInfo(name = "penaltyID")
    private int penaltyID;

    //region Getters and Setters
    public int getAbilityPenaltyListID()
    {
        return abilityPenaltyListID;
    }

    public void setAbilityPenaltyListID(int abilityPenaltyListID)
    {
        this.abilityPenaltyListID = abilityPenaltyListID;
    }

    public int getAbilityID()
    {
        return abilityID;
    }

    public void setAbilityID(int abilityID)
    {
        this.abilityID = abilityID;
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
