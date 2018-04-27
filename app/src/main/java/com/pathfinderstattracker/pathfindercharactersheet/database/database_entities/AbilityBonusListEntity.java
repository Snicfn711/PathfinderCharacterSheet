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
                       @ForeignKey(entity = BonusEntity.class,
                                   parentColumns = "bonusID",
                                   childColumns = "bonusID")})
public class AbilityBonusListEntity
{
    @PrimaryKey
    private int abilityBonusListID;
    @ColumnInfo(name = "abilityID")
    private int abilityID;
    @ColumnInfo(name = "bonusID")
    private int bonusID;

    //region Getters and Setters
    public int getAbilityBonusListID()
    {
        return abilityBonusListID;
    }

    public void setAbilityBonusListID(int abilityBonusListID)
    {
        this.abilityBonusListID = abilityBonusListID;
    }

    public int getAbilityID()
    {
        return abilityID;
    }

    public void setAbilityID(int abilityID)
    {
        this.abilityID = abilityID;
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
