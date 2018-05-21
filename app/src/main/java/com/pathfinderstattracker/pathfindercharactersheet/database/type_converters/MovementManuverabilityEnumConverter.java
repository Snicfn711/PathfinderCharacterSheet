package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class MovementManuverabilityEnumConverter
{
    @TypeConverter
    public MovementManeuverabilityEnum fromString(String value)
    {
        switch (value)
        {
            case "Clumsy":
                return MovementManeuverabilityEnum.Clumsy;
            case "Poor":
                return MovementManeuverabilityEnum.Poor;
            case "Average":
                return MovementManeuverabilityEnum.Average;
            case "Good":
                return MovementManeuverabilityEnum.Good;
            case "Perfect":
                return MovementManeuverabilityEnum.Perfect;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return MovementManeuverabilityEnum.Average;
        }
    }

    @TypeConverter
    public String toString(MovementManeuverabilityEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
