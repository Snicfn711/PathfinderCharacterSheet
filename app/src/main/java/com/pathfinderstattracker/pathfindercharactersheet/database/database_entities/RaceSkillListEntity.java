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
                       @ForeignKey(entity = SkillEntity.class,
                                   parentColumns = "skillID",
                                   childColumns = "skillID")},
        indices = {@Index("raceID"),
                   @Index("skillID")})
public class RaceSkillListEntity
{
    @PrimaryKey
    private int raceSkillListID;
    @ColumnInfo(name = "raceID")
    private int raceID;
    @ColumnInfo(name = "skillID")
    private int skillID;

    //region Getters and Setters
    public int getRaceSkillListID()
    {
        return raceSkillListID;
    }

    public void setRaceSkillListID(int raceSkillListID)
    {
        this.raceSkillListID = raceSkillListID;
    }

    public int getRaceID()
    {
        return raceID;
    }

    public void setRaceID(int raceID)
    {
        this.raceID = raceID;
    }

    public int getSkillID()
    {
        return skillID;
    }

    public void setSkillID(int skillID)
    {
        this.skillID = skillID;
    }
    //endregion
}
