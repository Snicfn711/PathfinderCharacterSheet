package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellRangeEnum;

/**
 * Created by Stephen Hagen on 5/2/2018.
 */

public class SpellRangeEnumConverter
{
    @TypeConverter
    public SpellRangeEnum fromString(String value)
    {
        switch (value)
        {
            case "Personal":
                return SpellRangeEnum.Personal;
            case "Touch":
                return SpellRangeEnum.Touch;
            case "Close":
                return SpellRangeEnum.Close;
            case "Medium":
                return SpellRangeEnum.Medium;
            case "Long":
                return SpellRangeEnum.Long;
            case "Unlimited":
                return SpellRangeEnum.Unlimited;
            case "Feet":
                return SpellRangeEnum.Feet;
            default:
                throw new RuntimeException("SpellRangeEnumConverter was given an invalid SpellRangeEnum");
        }
    }

    @TypeConverter
    public String toString(SpellRangeEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
