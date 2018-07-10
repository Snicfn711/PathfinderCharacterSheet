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
                break;
            case "DEX":
                formattedAbilityScore.setStat(AbilityScoreEnum.DEX);
                break;
            case "CON":
                formattedAbilityScore.setStat(AbilityScoreEnum.CON);
                break;
            case "INT":
                formattedAbilityScore.setStat(AbilityScoreEnum.INT);
                break;
            case "WIS":
                formattedAbilityScore.setStat(AbilityScoreEnum.WIS);
                break;
            case "CHA":
                formattedAbilityScore.setStat(AbilityScoreEnum.CHA);
                break;
            default:
                throw new RuntimeException("AbilityScoreConverter was given an invalid AbilityScoreEnum");
        }
        
        return formattedAbilityScore;
    }
    
    @TypeConverter
    public String toString(IAbilityScore value)
    {
        return value.toString();
    }
}
