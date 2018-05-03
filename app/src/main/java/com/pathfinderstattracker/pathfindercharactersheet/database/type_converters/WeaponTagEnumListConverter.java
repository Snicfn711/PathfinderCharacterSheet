package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Hagen on 4/23/2018.
 */

public class WeaponTagEnumListConverter
{
    @TypeConverter
    public List<WeaponTagEnum> fromString(String value)
    {
        List<WeaponTagEnum> formattedList = new ArrayList<WeaponTagEnum>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToWeaponTagEnumConverter(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<WeaponTagEnum> value)
    {
        StringBuilder formattedString = new StringBuilder(new String());
        for(WeaponTagEnum tagEnum: value)
        {
            formattedString.append(tagEnum.toString()).append("/");
        }
        return formattedString.toString();
    }

    private WeaponTagEnum StringToWeaponTagEnumConverter(String string)
    {
        switch(string)
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
}
