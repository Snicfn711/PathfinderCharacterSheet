package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Shield implements IShield
{
    public double cost;
    public int shieldBonus;
    public Integer maximumDexBonus;
    public Integer armorCheckPenalty;
    public int arcaneSpellFailureChance;
    public double weightAtMediumSize;
    public ShieldWeightCategoryEnum weightCategory;
    public SizeCategoryEnum armorSize;
    public boolean isMagic;
    public int magicBonnus;
}
