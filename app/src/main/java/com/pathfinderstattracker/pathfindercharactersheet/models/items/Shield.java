package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Shield extends Item implements IShield
{
    private String name;
    private double cost;
    private int shieldBonus;
    private Integer maximumDexBonus;
    private Integer armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private double weightAtMediumSize;
    private ShieldWeightCategoryEnum weightCategory;
    private SizeCategoryEnum armorSize;
    private boolean isMagic;
    private int magicBonus;
    private boolean isMasterwork;
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
    public void setWeightAtMediumSize(double weight)
    {
        weightAtMediumSize = weight;
    }

    @Override
    public int getShieldBonus()
    {
        return shieldBonus;
    }

    @Override
    public void setShieldBonus(int shieldBonus)
    {
        this.shieldBonus = shieldBonus;
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
    public ShieldWeightCategoryEnum getWeightCategory()
    {
        return weightCategory;
    }

    @Override
    public void setWeightCategory(ShieldWeightCategoryEnum weightCategory)
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
    public void setArmorCheckPenalty(int checkPenalty)
    {
        this.armorCheckPenalty = checkPenalty;
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
        //In this case, Size Category refers to character size (small, medium, large, etc.)
        //rather than weight category (Light, Medium, Heavy)
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

    public boolean isMasterwork(){return isMasterwork;}

    public void setIsMasterwork(boolean isMasterwork){this.isMasterwork = isMasterwork;}

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

    public Shield()
    {
        //Default constructor
    }

    public Shield(String name, double cost, int shieldBonus, Integer maximumDexBonus, Integer armorCheckPenalty, int arcaneSpellFailureChance, double weightAtMediumSize, ShieldWeightCategoryEnum weightCategory, SizeCategoryEnum armorSize, boolean isMagic, int magicBonus, boolean isMasterwork, Ability[] abilities)
    {
        setName(name);
        setCost(cost);
        setShieldBonus(shieldBonus);
        setMaximumDexBonus(maximumDexBonus);
        setArmorCheckPenalty(armorCheckPenalty);
        setArcaneSpellFailureChance(arcaneSpellFailureChance);
        setWeightAtMediumSize(weightAtMediumSize);
        setWeightCategory(weightCategory);
        setSizeCategory(armorSize);
        setIsMagic(isMagic);
        setMagicBonus(magicBonus);
        setIsMasterwork(isMasterwork);
        setAbilities(abilities);
    }

    public String createAbilitiesString()
    {
        String abilitiesString = new String();
        if(abilities != null && abilities.length > 1) {
            for (IAbility ability : abilities) {
                abilitiesString += ability.getName() + " ";
            }
            return abilitiesString;
        }
        else
        {
            return "None";
        }
    }

    public double getCurrentWeight()
    {
        if(armorSize == SizeCategoryEnum.Small)
        {
            return weightAtMediumSize * .5;
        }
        else if(armorSize == SizeCategoryEnum.Large)
        {
            return weightAtMediumSize * 2;
        }
        return weightAtMediumSize;
    }
}
