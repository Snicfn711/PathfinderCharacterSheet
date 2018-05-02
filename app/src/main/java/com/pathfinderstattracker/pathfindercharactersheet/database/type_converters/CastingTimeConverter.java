package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.CastingTime;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ICastingTime;

/**
 * Created by Stephen Hagen on 5/2/2018.
 */

public class CastingTimeConverter
{
    @TypeConverter
    public ICastingTime fromString(String value)
    {
        //This assumes a format of either # " " interval (i.e. 1 hour, 4 days, etc)
        //or Action " Action" (i.e. Standard Action, Free Action, etc)
        CastingTime formattedCastingTime = new CastingTime();
        String[] tokens = value.split(" ");
        if(tokens[1].equals("Action"))
        {
            formattedCastingTime.setAction(StringToActionEnum(tokens[0]));
        }
        else
        {
            formattedCastingTime.setNumberOfActions(Integer.parseInt(tokens[0]));
            formattedCastingTime.setInterval(tokens[1]);
        }
        return formattedCastingTime;
    }

    @TypeConverter
    public String toString(ICastingTime value)
    {
        return value.toString();
    }
    
    private ActionsEnum StringToActionEnum(String value)
    {
        switch (value)
        {
            case "Immediate":
                return ActionsEnum.Immediate;
            case "Standard":
                return ActionsEnum.Standard;
            case "Move":
                return ActionsEnum.Move;
            case "Swift":
                return ActionsEnum.Swift;
            case "Free":
                return ActionsEnum.Free;
            case "FullRound":
                return ActionsEnum.FullRound;
            case "More":
                return ActionsEnum.More;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return ActionsEnum.More;
        }
    }
}
