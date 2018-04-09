package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IShield extends IProtection
{
    ShieldWeightCategoryEnum getWeightCategory();
    void setWeightCategory(ShieldWeightCategoryEnum weightCategory);
}
