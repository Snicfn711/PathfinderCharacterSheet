package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;

public class ArmorTypesEnumConverter
{
    @TypeConverter
    public ArmorTypesEnum fromString(String value)
    {
        switch(value)
        {
            case "Armor":
                return ArmorTypesEnum.Armor;
            case "Deflection":
                return ArmorTypesEnum.Deflection;
            case "Dodge":
                return ArmorTypesEnum.Dodge;
            case "NaturalArmor":
                return ArmorTypesEnum.NaturalArmor;
            case "Shield":
                return ArmorTypesEnum.Shield;
            default:
                throw new RuntimeException("AbilityScoreConverter was given an invalid AbilityScoreEnum");
        }
    }

    @TypeConverter
    public String toString(ArmorTypesEnum value)
    {
        return value.toString();
    }
}
