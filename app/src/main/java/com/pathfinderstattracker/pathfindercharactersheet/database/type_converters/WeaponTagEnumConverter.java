package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;

/**
 * Created by Stephen Hagen on 5/4/2018.
 */

public class WeaponTagEnumConverter
{
    @TypeConverter
    public WeaponTagEnum fromString(String value)
    {
        switch(value)
        {
            case "Reach":
                return WeaponTagEnum.Reach;
            case "Thrown":
                return WeaponTagEnum.Thrown;
            case "DoubleHeaded":
                return WeaponTagEnum.DoubleHeaded;
            case "Projectile":
                return WeaponTagEnum.Projectile;
            case "Firearm":
                return WeaponTagEnum.Firearm;
            case "Improvised":
                return WeaponTagEnum.Improvised;
            case "Brace":
                return WeaponTagEnum.Brace;
            case "Disarm":
                return WeaponTagEnum.Disarm;
            case "Monk":
                return WeaponTagEnum.Monk;
            case "Trip":
                return WeaponTagEnum.Trip;
            case "Nonlethal":
                return WeaponTagEnum.Nonlethal;
            case "Composite":
                return WeaponTagEnum.Composite;
            case "Finesse":
                return WeaponTagEnum.Finesse;
            default:
                throw new RuntimeException("WeaponTagEnumConverter was given an invalid WeaponTagEnum");
        }
    }

    @TypeConverter
    public String toString(WeaponTagEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }

}
