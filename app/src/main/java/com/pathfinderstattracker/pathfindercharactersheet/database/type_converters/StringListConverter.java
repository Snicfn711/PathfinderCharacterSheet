package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */

public class StringListConverter
{
    @TypeConverter
    public List<String> fromString(String value)
    {
        ArrayList<String> formattedStringList = new ArrayList<String>();
        String[] tokens = value.split(" ");
        formattedStringList.addAll(Arrays.asList(tokens));
        return formattedStringList;
    }

    @TypeConverter
    public String toString(List<String> value)
    {
        StringBuilder formattedString = new StringBuilder();
        for (String x:value)
        {
            formattedString.append(value).append(" ");
        }
        return formattedString.toString();
    }
}
