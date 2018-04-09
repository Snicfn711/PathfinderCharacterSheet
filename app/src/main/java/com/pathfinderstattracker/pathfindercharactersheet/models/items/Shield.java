package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public class Shield extends AbsItem implements IShield
{
    private int acBonus;
    private Integer maximumDexBonus;
    private Integer armorCheckPenalty;
    private int arcaneSpellFailureChance;
    private ShieldWeightCategoryEnum weightCategory;
    private SizeCategoryEnum armorSize;
    private boolean isMagic;
    private int magicBonus;
    private boolean isMasterwork;
    private List<IAbility> abilities;
    private ArmorTypesEnum armorType;

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
    public List<IAbility> getAbilities()
    {
        return abilities;
    }

    @Override
    public void setAbilities(List<IAbility> abilities)
    {
        this.abilities = abilities;
    }

    @Override
    public ArmorTypesEnum getArmorType()
    {
        //We're only doing this to allow for implementing custom items later. For now though, no shield should be providing anything other than a shield bonus.
        return ArmorTypesEnum.Shield;
    }

    @Override
    public void setArmorType(ArmorTypesEnum armorType)
    {
        //Do nothing, see getArmorType for explanation.
    }
    //endregion

    public Shield()
    {
        //Default constructor
    }

    public Shield(String name, double cost, int acBonus, Integer maximumDexBonus, Integer armorCheckPenalty, int arcaneSpellFailureChance, double weightAtMediumSize, ShieldWeightCategoryEnum weightCategory, SizeCategoryEnum armorSize, boolean isMagic, int magicBonus, boolean isMasterwork, List<IAbility> abilities)
    {
        setName(name);
        setCost(cost);
        setACBonus(acBonus);
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
        StringBuilder abilitiesString = new StringBuilder();
        if(abilities != null && abilities.size() > 1) {
            for (IAbility ability : abilities) {
                abilitiesString.append(ability.getName()).append(" ");
            }
            return abilitiesString.toString();
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
            return weight * .5;
        }
        else if(armorSize == SizeCategoryEnum.Large)
        {
            return weight * 2;
        }
        return weight;
    }


}
