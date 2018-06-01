package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ICombatManeuver;

public class CombatManeuverConverter {
    @TypeConverter
    public ICombatManeuver fromString(String value)
    {
        //This assumes a format of either # " " interval (i.e. 1 hour, 4 days, etc)
        //or Action " Action" (i.e. Standard Action, Free Action, etc)
        ICombatManeuver formattedCombatManeuver = new CombatManeuver();
        String[] tokens = value.split(" ");
        formattedCombatManeuver.setCombatManeuverCheck(Integer.parseInt(tokens[0]));
        formattedCombatManeuver.setCombatManeuverDefense(Integer.parseInt(tokens[0]));
        return formattedCombatManeuver;
    }

    @TypeConverter
    public String toString(ICombatManeuver value)
    {
        return value.toString();
    }
}
