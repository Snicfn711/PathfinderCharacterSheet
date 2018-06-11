package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;

import java.util.ArrayList;
import java.util.List;

public class AbilityScoreListConverter
{
    @TypeConverter
    public List<IAbilityScore> fromString(String value)
    {
        List<IAbilityScore> formattedList = new ArrayList<IAbilityScore>();
        String[] tokens = value.split("/");
        for (String token : tokens)
        {
            formattedList.add(StringToAbilityScore(token));
        }
        return formattedList;
    }

    @TypeConverter
    public String toString(List<IAbilityScore> value)
    {
        StringBuilder formattedString = new StringBuilder(new String());
        for(IAbilityScore IAbilityScore: value)
        {
            formattedString.append(IAbilityScore.toString()).append("/");
        }
        return formattedString.toString();
    }

    private IAbilityScore StringToAbilityScore(String value)
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
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                formattedAbilityScore.setStat(AbilityScoreEnum.STR);
        }
        return formattedAbilityScore;
    }
}
