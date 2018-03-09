package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Armor implements IArmor
{
    private String name;
    private double cost;
    private int armorBonus;
    private int magicBonus;
    private Integer maximumDexBonus;
    private Integer armorCheckPenalty;
    private Integer arcaneSpellFailureChance;
    private Integer maxSpeed;
    private ArmorWeightCategoryEnum weightCategory;
    private double weightAtMediumSize;
    private SizeCategoryEnum armorSize;
    private boolean isMagic;
    private Ability[] abilities;

    //region Getters and Setters
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public double getCost()
    {
        return cost;
    }

    @Override
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    @Override
    public double getWeightAtMediumSize()
    {
        return weightAtMediumSize;
    }

    @Override
    public void setWeightAtMediumSize(double weightAtMediumSize)
    {
        this.weightAtMediumSize = weightAtMediumSize;
    }

    @Override
    public int getArmorBonus()
    {
        return armorBonus;
    }

    @Override
    public void setArmorBonus(int armorBonus)
    {
        this.armorBonus = armorBonus;
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

    @Override
    public Ability[] getAbilities()
    {
        return abilities;
    }

    @Override
    public void setAbilities(Ability[] abilities)
    {
        this.abilities = abilities;
    }

    //endregion

    public Armor()
    {
        //Default constructor
    }

    public Armor(String name, double cost, int armorBonus, int magicBonus, Integer maximumDexBonus, Integer armorCheckPenalty, Integer arcaneSpellFailureChance, Integer maxSpeed, ArmorWeightCategoryEnum weightCategory, double weightAtMediumSize, SizeCategoryEnum armorSize, boolean isMagic, Ability[] abilities)
    {
        setName(name);
        setCost(cost);
        setArmorBonus(armorBonus);
        setMagicBonus(magicBonus);
        setMaximumDexBonus(maximumDexBonus);
        setArmorCheckPenalty(armorCheckPenalty);
        setArcaneSpellFailureChance(arcaneSpellFailureChance);
        setMaxSpeed(maxSpeed);
        setWeightCategory(weightCategory);
        setWeightAtMediumSize(weightAtMediumSize);
        setSizeCategory(armorSize);
        setIsMagic(isMagic);
        setAbilities(abilities);
    }

    public String createAbilitiesString()
    {
        String abilitiesString = new String();
        for(IAbility ability:abilities)
        {
            abilitiesString += ability.getName() + " ";
        }
        return abilitiesString;
    }
}
