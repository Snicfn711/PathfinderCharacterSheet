package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IProtection extends IEquipment
{
    int getACBonus();
    void setACBonus(int acBonus);
    int getMaximumDexBonus();
    void setMaximumDexBonus(int maximumDexBonus);
    int getArmorCheckPenalty();
    void setArmorCheckPenalty(int armorCheckPenalty);
    int getArcanceSpellFailureChance();
    void setArcaneSpellFailureChance(int arcaneSpellFailureChance);
    double getCurrentWeight();
    ArmorTypesEnum getArmorType();
    void setArmorType(ArmorTypesEnum armorType);
}
