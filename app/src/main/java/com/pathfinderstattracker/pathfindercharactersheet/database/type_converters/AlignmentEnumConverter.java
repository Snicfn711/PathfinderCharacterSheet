package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;

/**
 * Created by Stephen Hagen on 4/20/2018.
 */

public class AlignmentEnumConverter
{
    @TypeConverter
    public AlignmentEnum fromString(String value)
    {
        switch (value)
        {
            case "LawfulGood":
                return AlignmentEnum.LawfulGood;
            case "LawfulNeutral":
                return AlignmentEnum.LawfulNeutral;
            case "LawfulEvil":
                return AlignmentEnum.LawfulEvil;
            case "NeutralGood":
                return AlignmentEnum.NeutralGood;
            case "TrueNeutral":
                return AlignmentEnum.TrueNeutral;
            case "NeutralEvil":
                return AlignmentEnum.NeutralEvil;
            case "ChaoticGood":
                return AlignmentEnum.ChaoticGood;
            case "ChaoticNeutral":
                return AlignmentEnum.ChaoticNeutral;
            case "ChaoticEvil":
                return AlignmentEnum.ChaoticEvil;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return AlignmentEnum.TrueNeutral;
        }
    }

    @TypeConverter
    public String toString(AlignmentEnum value)
    {
        if(value == null)
        {
            return null;
        }
        return value.toString();
    }
}
