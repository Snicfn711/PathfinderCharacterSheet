package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IArmorItem
{
    void setName(String name);
    String getName();
    void setArmorType(ArmorTypesEnum armorType);
    ArmorTypesEnum getArmorType();
    void setValue(int value);
    int getValue();
}
