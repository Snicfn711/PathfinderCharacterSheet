package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;

public class HitPointsConverter
{
    @TypeConverter
    public IHitPoints fromString(String value)
    {
        HitPoints formattedHitPoints = new HitPoints();
        String[] hitPointTokens = value.split(" ");
        formattedHitPoints.setValue(Integer.parseInt(hitPointTokens[0]));
        formattedHitPoints.setFavoredClassPointsInvested(Integer.parseInt(hitPointTokens[5]));
        return formattedHitPoints;
    }

    @TypeConverter
    public String toString(IHitPoints value)
    {
        if(value != null)
        {
            return value.toString();
        }
        else return null;
    }
}
