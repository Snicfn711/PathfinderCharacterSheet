package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */
@Deprecated
//Rather than tracking armor items separately, we'll just track a list of equipped items for a character
public class ArmorItem implements IArmorItem
{
    private String Name;
    private ArmorTypesEnum ArmorType;
    private int Value;

    @Override
    public void setName(String name)
    {
        Name = name;
    }

    @Override
    public String getName()
    {
        return Name;
    }

    @Override
    public void setArmorType(ArmorTypesEnum armorType)
    {
        ArmorType = armorType;
    }

    @Override
    public ArmorTypesEnum getArmorType()
    {
        return ArmorType;
    }

    @Override
    public void setValue(int value)
    {
        Value = value;
    }

    @Override
    public int getValue()
    {
        return Value;
    }

    public ArmorItem()
    {
        //Default Constructor
    }

    public ArmorItem(String name, ArmorTypesEnum armorType, int value)
    {
        setName(name);
        setArmorType(armorType);
        setValue(value);
    }
}
