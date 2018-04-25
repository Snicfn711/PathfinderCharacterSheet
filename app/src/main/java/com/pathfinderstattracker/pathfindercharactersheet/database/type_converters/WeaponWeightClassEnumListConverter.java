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
        StringBuilder formattedString = new StringBuilder(new String());
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
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return WeaponWeightClassEnum.Light;
        }
    }
}
