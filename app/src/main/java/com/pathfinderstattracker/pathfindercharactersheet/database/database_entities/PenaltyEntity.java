package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity
public class PenaltyEntity
{
    @PrimaryKey
    private int penaltyID;

    @ColumnInfo(name = "object_affected")
    private Object objectAffected;
    @ColumnInfo(name = "value")
    private double value;
    @ColumnInfo(name = "conditions")
    private String conditions;
    @ColumnInfo(name = "source")
    private Object source;

    //region Getters and Setters
    public int getPenaltyID()
    {
        return penaltyID;
    }

    public void setPenaltyID(int penaltyID)
    {
        this.penaltyID = penaltyID;
    }

    public Object getObjectAffected()
    {
        return objectAffected;
    }

    public void setObjectAffected(Object objectAffected)
    {
        this.objectAffected = objectAffected;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public String getConditions()
    {
        return conditions;
    }

    public void setConditions(String conditions)
    {
        this.conditions = conditions;
    }

    public Object getSource()
    {
        return source;
    }

    public void setSource(Object source)
    {
        this.source = source;
    }
    //endregion
}
