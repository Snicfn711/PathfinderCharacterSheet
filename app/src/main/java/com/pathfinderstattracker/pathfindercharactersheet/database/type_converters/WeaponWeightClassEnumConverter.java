package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

/**
 * Created by Stephen Hagen on 4/23/2018.
 */

public class WeaponWeightClassEnumConverter
{
    @TypeConverter
    public WeaponWeightClassEnum fromString(String value)
    {
        switch (value)
        {
            case "Light":
                return WeaponWeightClassEnum.Light;
            case "OneHanded":
                return WeaponWeightClassEnum.OneHanded;
            case "TwoHanded":
                return WeaponWeightClassEnum.TwoHanded;
            case "Ranged":
                return WeaponWeightClassEnum.Ranged;
            default:
                throw new RuntimeException("WeaponWeightClassEnumConverter was given an invalid WeaponWeightClassEnum");
        }
    }

    @TypeConverter
    public String toString(WeaponWeightClassEnum value)
    {

        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
