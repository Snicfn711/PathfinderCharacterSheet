package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Armor implements IArmor
{
    public double Cost;
    public int armorBonus;
    public int magicBonus;
    public Integer maximumDexBonus;
    public Integer armorCheckPenalty;
    public Integer arcaneSpellFailureChance;
    public Integer maxSpeed;
    public ArmorWeightCategoryEnum weightCategory;
    public double weightAtMediumSize;
    public SizeCategoryEnum armorSize;
    public boolean isMagic;
}
