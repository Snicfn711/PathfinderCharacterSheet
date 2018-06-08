package com.pathfinderstattracker.pathfindercharactersheet.database.type_converters;

import android.arch.persistence.room.TypeConverter;

import com.pathfinderstattracker.pathfindercharactersheet.models.characters.DamageReduction;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IDamageReduction;

public class DamageReductionConverter
{
    @TypeConverter
    public IDamageReduction fromString(String value)
    {
        //TODO:Damage Reduction isn't workng quite yet, so for now, the only ting being tracked is the amount, not the type
        DamageReduction formattedDamageReduction = new DamageReduction();
        String[] damageReductionTokens = value.split("/");
        formattedDamageReduction.setAmount(Integer.parseInt(damageReductionTokens[0]));
        formattedDamageReduction.setType("Slashing");
        return formattedDamageReduction;
    }

    @TypeConverter
    public String toString(IDamageReduction value)
    {
        if(value != null)
        {
            return Integer.toString(value.getAmount());
        }
        else return null;
    }
}
