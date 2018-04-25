package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/25/2018.
 */
@Entity
public class SenseEntity
{
    @PrimaryKey
    private int senseID;
    @ColumnInfo(name = "sense_name")
    private String Name;
    @ColumnInfo(name = "distance")
    private int Distance;
    @ColumnInfo(name = "effect_text")
    private String EffectText;

    //region Getters and Setters
    public int getSenseID()
    {
        return senseID;
    }

    public void setSenseID(int senseID)
    {
        this.senseID = senseID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getDistance()
    {
        return Distance;
    }

    public void setDistance(int distance)
    {
        Distance = distance;
    }

    public String getEffectText()
    {
        return EffectText;
    }

    public void setEffectText(String effectText)
    {
        EffectText = effectText;
    }
    //endregion
}
