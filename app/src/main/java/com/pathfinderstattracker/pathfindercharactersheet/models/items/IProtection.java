package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import java.io.Serializable;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IProtection extends IEquipment, Serializable
{
    int getACBonus();
    void setACBonus(int acBonus);
    //The max dex bonus can be as low as 0 (no dex bonus to AC) or infinite. In the second case, we'll use null(there is no maximum)
    Integer getMaximumDexBonus();
    void setMaximumDexBonus(Integer maximumDexBonus);
    //While the max dex bonus sets an upper limit, armor check penalty and arcan spell failure chance are simple subtractions. They can safely default to 0
    int getArmorCheckPenalty();
    void setArmorCheckPenalty(int armorCheckPenalty);
    int getArcaneSpellFailureChance();
    void setArcaneSpellFailureChance(int arcaneSpellFailureChance);
    double getCurrentWeight();
    ArmorTypesEnum getArmorType();
    void setArmorType(ArmorTypesEnum armorType);
}
