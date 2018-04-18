package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Armor extends AbsItem implements IArmor
{
    private int acBonus;
    private int magicBonus;
    private Integer maximumDexBonus;
    private Integer armorCheckPenalty;
    private Integer arcaneSpellFailureChance;
    private Integer maxSpeed;
    private ArmorWeightCategoryEnum weightCategory;
    private SizeCategoryEnum armorSize;
    private boolean isMagic;
    private List<IArmorEnchantment> enchantments;

    //region Getters and Setters
    @Override
    public int getACBonus()
    {
        return acBonus;
    }

    @Override
    public void setACBonus(int acBonus)
    {
        this.acBonus = acBonus;
    }

    @Override
    public int getMagicBonus()
    {
        return magicBonus;
    }

    @Override
    public void setMagicBonus(int magicBonus)
    {
        this.magicBonus = magicBonus;
    }

    @Override
    public int getMaxSpeed()
    {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public ArmorWeightCategoryEnum getWeightCategory()
    {
        //This weight category refers to Light, Medium, Heavy categories, not weight in lbs
        return weightCategory;
    }

    @Override
    public void setWeightCategory(ArmorWeightCategoryEnum weightCategory)
    {
        this.weightCategory = weightCategory;
    }

    @Override
    public int getMaximumDexBonus()
    {
        return maximumDexBonus;
    }

    @Override
    public void setMaximumDexBonus(int maximumDexBonus)
    {
        this.maximumDexBonus = maximumDexBonus;
    }

    @Override
    public int getArmorCheckPenalty()
    {
        return armorCheckPenalty;
    }

    @Override
    public void setArmorCheckPenalty(int armorCheckPenalty)
    {
        this.armorCheckPenalty = armorCheckPenalty;
    }

    @Override
    public int getArcanceSpellFailureChance()
    {
        return arcaneSpellFailureChance;
    }

    @Override
    public void setArcaneSpellFailureChance(int arcaneSpellFailureChance)
    {
        this.arcaneSpellFailureChance = arcaneSpellFailureChance;
    }

    @Override
    public SizeCategoryEnum getSizeCategory()
    {
        return armorSize;
    }

    @Override
    public void setSizeCategory(SizeCategoryEnum sizeCategory)
    {
        this.armorSize = sizeCategory;
    }

    @Override
    public boolean isMagic()
    {
        return isMagic;
    }

    @Override
    public void setIsMagic(boolean isMagic)
    {
        this.isMagic = isMagic;
    }

    public List<IArmorEnchantment> getEnchantments()
    {
        return enchantments;
    }

    public void setEnchantments(List<IArmorEnchantment> enchantments)
    {
        this.enchantments = enchantments;
    }

    @Override
    public ArmorTypesEnum getArmorType()
    {
        //We're only doing this to allow for implementing custom items later. For now though, no shield should be providing anything other than an armor bonus.
        return ArmorTypesEnum.Armor;
    }

    @Override
    public void setArmorType(ArmorTypesEnum armorType)
    {
        //Do nothing, see getArmorType for why
    }
    //endregion

    public Armor()
    {
        //Default constructor
    }

    public Armor(String name, double cost, int acBonus, int magicBonus, Integer maximumDexBonus, Integer armorCheckPenalty, Integer arcaneSpellFailureChance, Integer maxSpeed, ArmorWeightCategoryEnum weightCategory, double weightAtMediumSize, SizeCategoryEnum armorSize, boolean isMagic, List<IArmorEnchantment> enchantments)
    {
        setName(name);
        setCost(cost);
        setACBonus(acBonus);
        setMagicBonus(magicBonus);
        setMaximumDexBonus(maximumDexBonus);
        setArmorCheckPenalty(armorCheckPenalty);
        setArcaneSpellFailureChance(arcaneSpellFailureChance);
        setMaxSpeed(maxSpeed);
        setWeightCategory(weightCategory);
        setWeightAtMediumSize(weightAtMediumSize);
        setSizeCategory(armorSize);
        setIsMagic(isMagic);
        setEnchantments(enchantments);
    }

    public double getCurrentWeight()
    {
        if(armorSize == SizeCategoryEnum.Small)
        {
            return weight * .5;
        }
        else if(armorSize == SizeCategoryEnum.Large)
        {
            return weight* 2;
        }
        return weight;
    }


}
