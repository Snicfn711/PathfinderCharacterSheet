package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Hagen on 4/30/2018.
 */

public class BodySlotEnumListConverter
{
    @TypeConverter
    public List<BodySlotsEnum> fromString(String value)
    {
        List<BodySlotsEnum> formattedList = new ArrayList<BodySlotsEnum>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToBodySlotsEnumConverter(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<BodySlotsEnum> value)
    {
        if(value == null)
        {
            return null;
        }
        StringBuilder formattedString = new StringBuilder();
        for(BodySlotsEnum tagEnum: value)
        {
            formattedString.append(tagEnum.toString()).append("/");
        }
        return formattedString.toString();
    }

    private BodySlotsEnum StringToBodySlotsEnumConverter(String string)
    {
        switch(string)
        {
            case "Head":
                return BodySlotsEnum.Head;
            case "Face":
                return BodySlotsEnum.Face;
            case "Throat":
                return BodySlotsEnum.Throat;
            case "Shoulder":
                return BodySlotsEnum.Shoulder;
            case "Body":
                return BodySlotsEnum.Body;
            case "Torso":
                return BodySlotsEnum.Torso;
            case "Hands":
                return BodySlotsEnum.Hands;
            case "Arms":
                return BodySlotsEnum.Arms;
            case "Waist":
                return BodySlotsEnum.Waist;
            case "Feet":
                return BodySlotsEnum.Feet;
            case "Ring1":
                return BodySlotsEnum.Ring1;
            case "Ring2":
                return BodySlotsEnum.Ring2;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return BodySlotsEnum.Head;
        }
    }
}
