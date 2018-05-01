package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.DescriptorEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class SpellDescriptorListConverter
{
    @TypeConverter
    public List<DescriptorEnum> fromString(String value)
    {
        List<DescriptorEnum> formattedList = new ArrayList<DescriptorEnum>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToDescriptorEnumConverter(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<DescriptorEnum> value)
    {
        StringBuilder formattedString = new StringBuilder();
        for(DescriptorEnum descriptorEnum: value)
        {
            formattedString.append(descriptorEnum.toString()).append("/");
        }
        return formattedString.toString();
    }

    private DescriptorEnum StringToDescriptorEnumConverter(String string)
    {
        switch(string)
        {
            case "Acid":
                return DescriptorEnum.Acid;
            case "Air":
                return DescriptorEnum.Air;
            case "Chaotic":
                return DescriptorEnum.Chaotic;
            case "Cold":
                return DescriptorEnum.Cold;
            case "Curse":
                return DescriptorEnum.Curse;
            case "Darkness":
                return DescriptorEnum.Darkness;
            case "Death":
                return DescriptorEnum.Death;
            case "Disease":
                return DescriptorEnum.Disease;
            case "Draconic":
                return DescriptorEnum.Draconic;
            case "Earth":
                return DescriptorEnum.Earth;
            case "Electricity":
                return DescriptorEnum.Electricity;
            case "Emotion":
                return DescriptorEnum.Emotion;
            case "Evil":
                return DescriptorEnum.Evil;
            case "Fear":
                return DescriptorEnum.Fear;
            case "Fire":
                return DescriptorEnum.Fire;
            case "Force":
                return DescriptorEnum.Force;
            case "Good":
                return DescriptorEnum.Good;
            case "LanguageDependent":
                return DescriptorEnum.LanguageDependent;
            case "Lawful":
                return DescriptorEnum.Lawful;
            case "Light":
                return DescriptorEnum.Light;
            case "Meditative":
                return DescriptorEnum.Meditative;
            case "MindAffecting":
                return DescriptorEnum.MindAffecting;
            case "Pain":
                return DescriptorEnum.Pain;
            case "Poison":
                return DescriptorEnum.Poison;
            case "Ruse":
                return DescriptorEnum.Ruse;
            case "Shadow":
                return DescriptorEnum.Shadow;
            case "Sonic":
                return DescriptorEnum.Sonic;
            case "Water":
                return DescriptorEnum.Water;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return DescriptorEnum.Acid;
        }
    }
}
