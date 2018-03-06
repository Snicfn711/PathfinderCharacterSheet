package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IShield extends IProtection
{
    int shieldBonus = 0;
    int magicBonus=0;
    ShieldWeightCategoryEnum weightCategory = ShieldWeightCategoryEnum.Light;
}
