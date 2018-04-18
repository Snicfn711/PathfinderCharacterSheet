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
    int getGoldCost();
    void setGoldCost(int goldCost);
}
