package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Hagen on 4/25/2018.
 */

public class WeaponWeightClassEnumListConverter
{
    @TypeConverter
    public List<WeaponWeightClassEnum> fromString(String value)
    {
        List<WeaponWeightClassEnum> formattedList = new ArrayList<WeaponWeightClassEnum>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToWeaponWeightClassEnumConverter(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<WeaponWeightClassEnum> value)
    {
        if(value == null)
        {
            return null;
        }
        StringBuilder formattedString = new StringBuilder();
        for(WeaponWeightClassEnum tagEnum: value)
        {
            formattedString.append(tagEnum.toString()).append("/");
        }
        return formattedString.toString();
    }

    private WeaponWeightClassEnum StringToWeaponWeightClassEnumConverter(String string)
    {
        switch (string)
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
                throw new RuntimeException("WeaponWeightClassEnumListConverter was given an invalid WeaponWeightClassEnum");
        }
    }
}
