package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.MovementManeuverabilityEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */
@Entity
@TypeConverters(MovementManeuverabilityEnumConverter.class)
public class MovementEntity
{
    @PrimaryKey
    private int movementID;
    @ColumnInfo(name = "name")
    private String Name;
    @ColumnInfo(name = "speed")
    private int Speed;
    @ColumnInfo(name = "maneuverability")
    private MovementManeuverabilityEnum Maneuverability;

    //region Getters and Setters
    public int getMovementID()
    {
        return movementID;
    }

    public void setMovementID(int movementID)
    {
        this.movementID = movementID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getSpeed()
    {
        return Speed;
    }

    public void setSpeed(int speed)
    {
        Speed = speed;
    }

    public MovementManeuverabilityEnum getManeuverability()
    {
        return Maneuverability;
    }

    public void setManeuverability(MovementManeuverabilityEnum maneuverability)
    {
        Maneuverability = maneuverability;
    }
    //endregion
}
