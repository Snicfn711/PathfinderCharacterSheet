package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IArmor extends IProtection
{
    int armorBonus = 0;
    int magicBonus = 0;
    Integer maxSpeed = null;
    ArmorWeightCategoryEnum weightCategory = ArmorWeightCategoryEnum.Medium;
}
