package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IArmor extends IProtection
{
    int getArmorBonus();
    void setArmorBonus(int armorBonus);
    int getMaxSpeed();
    void setMaxSpeed(int maxSpeed);
    ArmorWeightCategoryEnum getWeightCategory();
    void setWeightCategory(ArmorWeightCategoryEnum weightCategory);
    double getCurrentWeight();
}
