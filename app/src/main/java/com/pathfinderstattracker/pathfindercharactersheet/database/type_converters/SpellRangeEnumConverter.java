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
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return SpellRangeEnum.Medium;
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
