package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/4/2018.
 */

public class WondrousItems extends AbsItem implements IWondrousItems
{

    private ArcaneAura aura;
    private BodySlotsEnum bodySlot;
    private List<IAbility> abilities;
    private Integer casterLevel;
    private ArmorTypesEnum armorType;
    private Integer acBonus;
    private SizeCategoryEnum sizeCategory;
    private boolean isFragile;

    //region Getters and Setters
    public ArcaneAura getAura()
    {
        return aura;
    }

    public void setAura(ArcaneAura aura)
    {
        this.aura = aura;
    }

    public BodySlotsEnum getBodySlot()
    {
        return bodySlot;
    }

    public void setBodySlot(BodySlotsEnum bodySlot)
    {
        this.bodySlot = bodySlot;
    }

    @Override
    public SizeCategoryEnum getSizeCategory()
    {
        //Wondrous items automatically resize to the wearer
        return sizeCategory;
    }

    @Override
    public void setSizeCategory(SizeCategoryEnum sizeCategory)
    {
        this.sizeCategory = sizeCategory;
    }

    @Override
    public boolean isMagic()
    {
        //Wondrous items are by definition magic, so this should always return true
        return true;
        //We're inheriting this from IEquipment. Yes it's a code smell
    }

    @Override
    public void setIsMagic(boolean isMagic)
    {
        //Do nothing. See the isMagic method for why
    }

    @Override
    public int getMagicBonus()
    {
        //Wondrous items don't increment the same way that equipment does
        return 0;
    }

    @Override
    public void setMagicBonus(int magicBonus)
    {
        //Do nothing
    }

    public List<IAbility> getAbilities()
    {
        return abilities;
    }

    public void setAbilities(List<IAbility> abilities)
    {
        this.abilities = abilities;
    }

    public Integer getCasterLevel()
    {
        return casterLevel;
    }

    public void setCasterLevel(Integer casterLevel)
    {
        this.casterLevel = casterLevel;
    }

    public ArmorTypesEnum getArmorType(){return armorType;}
    public void setArmorType(ArmorTypesEnum armorType){this.armorType = armorType;}
    public Integer getACBonus(){return  acBonus;}
    public void setACBonus(Integer acBonus){this.acBonus = acBonus;}
    public boolean isFragile(){return isFragile;}
    public void setIsFragile(boolean isFragile){this.isFragile = isFragile;}
    //endregion

    public WondrousItems()
    {
        //Default constructor
    }

    public WondrousItems(String name, double cost, double weightAtMediumSize, ArcaneAura aura, BodySlotsEnum bodySlot, List<IAbility> abilities, Integer casterLevel, ArmorTypesEnum armorType, Integer acBonus)
    {
        setName(name);
        setCost(cost);
        setWeightAtMediumSize(weightAtMediumSize);
        setAura(aura);
        setBodySlot(bodySlot);
        setAbilities(abilities);
        setCasterLevel(casterLevel);
        setArmorType(armorType);
        setACBonus(acBonus);
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
}
