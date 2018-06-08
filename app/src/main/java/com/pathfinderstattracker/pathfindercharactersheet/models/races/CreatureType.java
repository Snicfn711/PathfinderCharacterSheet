package com.pathfinderstattracker.pathfindercharactersheet.models.races;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */
import java.io.Serializable;

public class CreatureType implements ICreatureType, Serializable
{
    private String Type;
    private String SubType;
    //public List<Ability> Abilities;
    //Todo:Eventually we'll have to add creature type abilities (like dragons breath weapons, undead immunities, etc

    //region Getters and Setters
    public String getType()
    {
        return Type;
    }

    public void setType(String type)
    {
        Type = type;
    }

    public String getSubType()
    {
        return SubType;
    }

    public void setSubType(String subType)
    {
        SubType = subType;
    }
    //endregion

    public CreatureType()
    {
        //Default Constructor
    }

    public CreatureType(String type, String subType)
    {
        setType(type);
        setSubType(subType);
    }

    @Override
    public String toString()
    {
        return Type + " " + SubType;
    }
}
