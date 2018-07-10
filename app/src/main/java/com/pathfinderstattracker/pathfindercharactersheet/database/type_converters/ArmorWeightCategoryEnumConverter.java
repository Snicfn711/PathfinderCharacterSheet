package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;

public class ArmorWeightCategoryEnumConverter
{
    @TypeConverter
    public ArmorWeightCategoryEnum fromString(String value)
    {
        switch (value)
        {
            case "Light":
                return ArmorWeightCategoryEnum.Light;
            case "Medium":
                return ArmorWeightCategoryEnum.Medium;
            case "Heavy":
                return ArmorWeightCategoryEnum.Heavy;
            default:
                throw new RuntimeException("ArmorWeightCategoryEnumConverter was given an invalid ArmorWeightCategory.");
        }
    }

    @TypeConverter
    public String toString(ArmorWeightCategoryEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
