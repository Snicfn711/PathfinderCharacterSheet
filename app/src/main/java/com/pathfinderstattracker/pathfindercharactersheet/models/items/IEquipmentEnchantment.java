package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 4/17/2018.
 */

public interface IEquipmentEnchantment
{
    String getName();
    void setName(String name);
    int getEnhancementBonusPointCost();
    void setEnhancementBonusPointCost(int enhancementBonusPointCost);
    double getGoldCost(); //Technically no enchantment uses less than a single gold, but we're using a double for gold everywhere else, and it allows us to more easily overload our constructors
    void setGoldCost(double goldCost);
}
