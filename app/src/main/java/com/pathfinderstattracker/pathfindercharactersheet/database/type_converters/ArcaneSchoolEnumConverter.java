package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class ArcaneSchoolEnumConverter
{

    @TypeConverter
    public ArcaneSchoolEnum fromString(String value)
    {
        switch (value)
        {
            case "Abjuration":
                return ArcaneSchoolEnum.Abjuration;
            case "Conjuration":
                return ArcaneSchoolEnum.Conjuration;
            case "Divination":
                return ArcaneSchoolEnum.Divination;
            case "Enchantment":
                return ArcaneSchoolEnum.Enchantment;
            case "Evocation":
                return ArcaneSchoolEnum.Evocation;
            case "Illusion":
                return ArcaneSchoolEnum.Illusion;
            case "Necromancy":
                return ArcaneSchoolEnum.Necromancy;
            case "Transmutation":
                return ArcaneSchoolEnum.Transmutation;
            default:
                throw new RuntimeException("ArcaneSchoolEnumConverter was given an invalid ArcaneSchoolEnum");
        }
    }

    @TypeConverter
    public String toString(ArcaneSchoolEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
