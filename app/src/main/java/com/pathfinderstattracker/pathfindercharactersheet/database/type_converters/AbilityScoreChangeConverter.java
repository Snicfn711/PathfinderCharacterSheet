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
                break;
            case "DEX":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.DEX);
                break;
            case "CON":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.CON);
                break;
            case "INT":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.INT);
                break;
            case "WIS":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.WIS);
                break;
            case "CHA":
                formattedAbilityScoreChange.setStatChanged(AbilityScoreEnum.CHA);
                break;
            default:
                throw new RuntimeException("AbilityScoreChangeConverter was given an invalid AbilityScoreEnum");
        }

        return formattedAbilityScoreChange;
    }

    @TypeConverter
    public String toString(IAbilityScoreChange value)
    {
        return value.toString();
    }
}
