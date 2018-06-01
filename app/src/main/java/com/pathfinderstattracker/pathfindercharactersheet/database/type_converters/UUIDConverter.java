package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import java.util.UUID;

public class UUIDConverter
{
    @TypeConverter
    public UUID fromString(String value)
    {
        return  UUID.fromString(value);
    }

    @TypeConverter
    public String toString(UUID value)
    {
        return value.toString();
    }
}
