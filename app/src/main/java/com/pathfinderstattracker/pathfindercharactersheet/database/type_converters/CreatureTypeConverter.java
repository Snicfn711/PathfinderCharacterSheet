package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.races.CreatureType;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class CreatureTypeConverter
{
    @TypeConverter
    public CreatureType fromString(String value)
    {
        CreatureType creatureType = new CreatureType();
        String[] tokens = value.split(" ");
        creatureType.setType(tokens[0]);
        creatureType.setSubType(tokens[1]);
        return creatureType;
    }

    @TypeConverter
    public String toString(CreatureType value)
    {
        return value.toString();
    }
}
