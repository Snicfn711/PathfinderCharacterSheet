package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;

import java.util.ArrayList;
import java.util.List;

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
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return WeaponTagEnum.Improvised;
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
