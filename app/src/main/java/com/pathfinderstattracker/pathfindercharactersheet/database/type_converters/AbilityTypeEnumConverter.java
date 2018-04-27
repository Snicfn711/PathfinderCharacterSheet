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
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return AbilityTypeEnum.ExtraOrdinary;
        }
    }

    @TypeConverter
    public String toString(AbilityTypeEnum value)
    {
        return value.toString();
    }
}
