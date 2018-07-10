package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 4/30/2018.
 */
public class SizeCategoryEnumConverter
{
    @TypeConverter
    public SizeCategoryEnum fromString(String value)
    {
        switch (value)
        {
            case "Fine":
                return SizeCategoryEnum.Fine;
            case "Diminutive":
                return SizeCategoryEnum.Diminutive;
            case "Tiny":
                return SizeCategoryEnum.Tiny;
            case "Small":
                return SizeCategoryEnum.Small;
            case "Medium":
                return SizeCategoryEnum.Medium;
            case "Large":
                return SizeCategoryEnum.Large;
            case "Huge":
                return SizeCategoryEnum.Huge;
            case "Gargantuan":
                return SizeCategoryEnum.Gargantuan;
            case "Colossal":
                return SizeCategoryEnum.Colossal;
            case "Colossal_Plus":
                return SizeCategoryEnum.Colossal_Plus;
            default:
                throw new RuntimeException("SizeCategoryEnumConverter was given an invalid SizeCategoryEnum");
        }
    }

    @TypeConverter
    public String toString(SizeCategoryEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
