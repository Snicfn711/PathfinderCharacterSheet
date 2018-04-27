package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */

public class AbilityScoreConverter
{
    @TypeConverter
    public IAbilityScore fromString(String value)
    {
        IAbilityScore formattedAbilityScore = new AbilityScore();
        String[] tokens = value.split(" ");
        formattedAbilityScore.setAmount(Integer.parseInt(tokens[0]));
        switch(tokens[1])
        {
            case "STR":
                formattedAbilityScore.setStat(AbilityScoreEnum.STR);
            case "DEX":
                formattedAbilityScore.setStat(AbilityScoreEnum.DEX);
            case "CON":
                formattedAbilityScore.setStat(AbilityScoreEnum.CON);
            case "INT":
                formattedAbilityScore.setStat(AbilityScoreEnum.INT);
            case "WIS":
                formattedAbilityScore.setStat(AbilityScoreEnum.WIS);
            case "CHA":
                formattedAbilityScore.setStat(AbilityScoreEnum.CHA);
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                formattedAbilityScore.setStat(AbilityScoreEnum.STR);
        }
        
        return formattedAbilityScore;
    }
    
    @TypeConverter
    public String toString(IAbilityScore value)
    {
        return value.toString();
    }
}
