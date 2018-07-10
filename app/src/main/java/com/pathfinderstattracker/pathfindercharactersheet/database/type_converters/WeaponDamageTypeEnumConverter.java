package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

public class WeaponDamageTypeEnumConverter
{
    @TypeConverter
    public WeaponDamageTypeEnum fromString(String value)
    {
        switch (value)
        {
            case "Bludgeoning":
                return WeaponDamageTypeEnum.Bludgeoning;
            case "Slashing":
                return WeaponDamageTypeEnum.Slashing;
            case "Piercing":
                return WeaponDamageTypeEnum.Piercing;
            default:
                throw new RuntimeException("WeaponDamageTypeEnumConverter was given an invalid WeaponDamageTypeEnum");
        }
    }

    @TypeConverter
    public String toString(WeaponDamageTypeEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
