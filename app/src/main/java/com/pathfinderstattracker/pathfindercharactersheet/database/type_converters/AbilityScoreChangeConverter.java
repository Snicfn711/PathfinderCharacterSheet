package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreChange;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScoreChange;

/**
 * Created by Stephen Hagen on 4/30/2018.
 */

public class AbilityScoreChangeConverter
{
    @TypeConverter
    public IAbilityScoreChange fromString(String value)
    {
        IAbilityScoreChange formattedAbilityScoreChange = new AbilityScoreChange();
        String[] tokens = value.split(" ");
        formattedAbilityScoreChange.setAmountChanged(Integer.parseInt(tokens[0]));
        switch(tokens[1])
        {
            case "STR":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.STR);
            case "DEX":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.DEX);
            case "CON":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.CON);
            case "INT":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.INT);
            case "WIS":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.WIS);
            case "CHA":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.CHA);
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.STR);
        }

        return formattedAbilityScoreChange;
    }

    @TypeConverter
    public String toString(IAbilityScoreChange value)
    {
        return value.toString();
    }
}
