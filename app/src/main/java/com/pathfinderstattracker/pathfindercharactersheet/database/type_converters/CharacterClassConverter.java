package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.classes.ICharacterClass;
import com.pathfinderstattracker.pathfindercharactersheet.models.classes.MartialCharacterClass;

/**
 * Created by Stephen Hagen on 5/2/2018.
 */

public class CharacterClassConverter
{
    @TypeConverter
    public ICharacterClass fromString(String value)
    {
        //Todo: When we implement cahracter classes, we'll have to come back to this.
        return new MartialCharacterClass();
    }

    @TypeConverter
    public String toString(ICharacterClass value)
    {
        return " ";
    }

}
