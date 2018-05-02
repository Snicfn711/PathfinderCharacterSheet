package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDurationEnum;

/**
 * Created by Stephen Hagen on 5/2/2018.
 */

public class SpellDurationConverter
{
    @TypeConverter
    public ISpellDuration fromString(String value)
    {
        //This converter currently ignores the full implementation of SpellDuration in favor of just looking at the enum
        //Todo:Once we've properly implemented spell duration, this converter will need to be changed
        SpellDuration formattedSpellDuration = new SpellDuration();
        formattedSpellDuration.setTimeIncrement("Minutes");
        formattedSpellDuration.setNumberOfIncrements(0);
        switch (value)
        {
            case "Instant":
                formattedSpellDuration.setSpellDuration(SpellDurationEnum.Instant);
            case "Concentration":
                formattedSpellDuration.setSpellDuration(SpellDurationEnum.Concentration);
            case "Timed":
                formattedSpellDuration.setSpellDuration(SpellDurationEnum.Timed);
            case "Permanent":
                formattedSpellDuration.setSpellDuration(SpellDurationEnum.Permanent);
            default:
                //This may cause issues down the line if a non existent enum gets in the db somehow, but we don't have any error handling yet
                //Todo: Add error handling
                formattedSpellDuration.setSpellDuration(SpellDurationEnum.Instant);
        }
        return formattedSpellDuration;
}

    @TypeConverter
    public String toString(ISpellDuration value)
    {
        //All SpellDuration does for its toString right now is put the DurationEnum in a string format
        return value.toString();
    }
}
