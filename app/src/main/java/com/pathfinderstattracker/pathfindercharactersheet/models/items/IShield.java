package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IShield extends IProtection
{
    int getShieldBonus();
    void setShieldBonus(int shieldBonus);
    ShieldWeightCategoryEnum getWeightCategory();
    void setWeightCategory(ShieldWeightCategoryEnum weightCategory);
    double getCurrentWeight();
}
