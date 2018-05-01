package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreChange;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScoreChange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class AbilityScoreChangeListConverter
{
    @TypeConverter
    public List<AbilityScoreChange> fromString(String value)
    {
        List<AbilityScoreChange> formattedList = new ArrayList<AbilityScoreChange>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToAbilityScoreChange(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<AbilityScoreChange> value)
    {
        StringBuilder formattedString = new StringBuilder(new String());
        for(AbilityScoreChange abilityScoreChange: value)
        {
            formattedString.append(abilityScoreChange.toString()).append("/");
        }
        return formattedString.toString();
    }
    private AbilityScoreChange StringToAbilityScoreChange(String value)
    {
        AbilityScoreChange formattedAbilityScoreChange = new AbilityScoreChange();
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
}