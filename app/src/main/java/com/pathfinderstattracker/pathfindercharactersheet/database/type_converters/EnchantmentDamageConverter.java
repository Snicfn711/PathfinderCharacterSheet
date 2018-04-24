package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;

/**
 * Created by Stephen Hagen on 4/23/2018.
 */

public class EnchantmentDamageConverter
{
    @TypeConverter
    public Damage fromString(String value)
    {
        Damage formattedDamage = new Damage();
        String[] tokens = value.split("d");
        formattedDamage.setNumberOfDice(Integer.parseInt(tokens[0]));
        formattedDamage.setSizeOfDice(Integer.parseInt(tokens[1]));
        return formattedDamage;
    }

    @TypeConverter
    public String toString(Damage value)
    {
        return value.toString();
    }
}
