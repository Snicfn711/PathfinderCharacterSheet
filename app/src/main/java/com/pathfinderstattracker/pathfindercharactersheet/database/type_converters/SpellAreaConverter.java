package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellArea;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellArea;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellAreaEnum;

/**
 * Created by Stephen Hagen on 5/2/2018.
 */

public class SpellAreaConverter
{
    @TypeConverter
    public ISpellArea fromString(String value)
    {
        SpellArea formattedSpellArea = new SpellArea();
        String[] areaTokens = value.split(" ");
        formattedSpellArea.setNumberOfFeetInArea(Integer.parseInt(areaTokens[0]));
        formattedSpellArea.setSpellArea(StringToAreaEnumConverter(areaTokens[2]));
        return formattedSpellArea;
    }

    @TypeConverter
    public String toString(ISpellArea value)
    {
        return value.toString();
    }

    private SpellAreaEnum StringToAreaEnumConverter(String value)
    {
        switch (value)
        {
            case "Burst":
                return SpellAreaEnum.Burst;
            case "Emanation":
                return SpellAreaEnum.Emanation;
            case "Spread":
                return SpellAreaEnum.Spread;
            case "Cone":
                return SpellAreaEnum.Cone;
            case "Cylinder":
                return SpellAreaEnum.Cylinder;
            case "Line":
                return SpellAreaEnum.Line;
            case "Ray":
                return SpellAreaEnum.Ray;
            case "Sphere":
                return SpellAreaEnum.Sphere;
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                return SpellAreaEnum.Cone;

        }
    }
}
