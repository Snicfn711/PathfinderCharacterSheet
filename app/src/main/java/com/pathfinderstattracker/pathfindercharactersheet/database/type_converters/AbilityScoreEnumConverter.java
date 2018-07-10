package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

public class AbilityScoreEnumConverter
{
    @TypeConverter
    public AbilityScoreEnum fromString(String value)
    {
        switch (value)
        {
            case "STR":
                return AbilityScoreEnum.STR;
            case "DEX":
                return AbilityScoreEnum.DEX;
            case "CON":
                return AbilityScoreEnum.CON;
            case "INT":
                return AbilityScoreEnum.INT;
            case "WIS":
                return AbilityScoreEnum.WIS;
            case "CHA":
                return AbilityScoreEnum.CHA;
            default:
                throw new RuntimeException("AbilityScoreEnumConverter was given an invalid AbilityScoreEnum");
        }
    }

    @TypeConverter
    public String toString(AbilityScoreEnum value)
    {
        if(value != null)
        {
            return value.toString();
        }
        else return null;
    }
}
