package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityTypeEnum;

/**
 * Created by Stephen Hagen on 4/26/2018.
 */

public class AbilityTypeEnumConverter
{
    @TypeConverter
    public AbilityTypeEnum fromString(String value)
    {
        switch (value)
        {
            case "SuperNatural":
                return AbilityTypeEnum.SuperNatural;
            case "ExtraOrdinary":
                return AbilityTypeEnum.ExtraOrdinary;
            case "SpellLike":
                return AbilityTypeEnum.SpellLike;
            default:
                throw new RuntimeException("AbilityTypeEnumConverter was given an invalid AbilityTypeEnum");
        }
    }

    @TypeConverter
    public String toString(AbilityTypeEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
