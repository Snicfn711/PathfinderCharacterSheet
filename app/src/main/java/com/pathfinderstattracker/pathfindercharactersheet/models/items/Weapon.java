package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/27/2017.
 */

public class Weapon extends AbsItem implements IWeapon
{
    private WeaponFamilyEnum family;
    private int range;
    private List<WeaponTagEnum> weaponTags;
    private WeaponWeightClassEnum weightClass;
    private List<Damage> damage;
    private int criticalMultiplier;
    private int criticalRange; //Rather than being an actual range like 19-20, this is instead the number of critical values, so the default is 1, 19-20 is 2, 18-20 is 3, etc
    private List<WeaponDamageTypeEnum> damageType;
    private String material;
    private boolean masterwork;
    private boolean isMagic;
    private int magicBonus;
    private SizeCategoryEnum sizeCategory;
    private int requiredStrength;
    private List<IWeaponEnchantment> enchantments;

    //region Getters and Setters
    @Override
    public WeaponFamilyEnum getFamily()
    {
        return family;
    }

    @Override
    public void setFamily(WeaponFamilyEnum family)
    {
        this.family = family;
    }

    @Override
    public int getRange()
    {
        return range;
    }

    @Override
    public void setRange(int range)
    {
        this.range = range;
    }

    @Override
    public List<WeaponTagEnum> getWeaponTags()
    {
        return weaponTags;
    }

    @Override
    public void setWeaponTags(List<WeaponTagEnum> weaponTags)
    {
        this.weaponTags = weaponTags;
    }

    @Override
    public WeaponWeightClassEnum getWeightClass()
    {
        return weightClass;
    }

    @Override
    public void setWeightClass(WeaponWeightClassEnum weightClass)
    {
        this.weightClass = weightClass;
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
    public List<IAbility> getAbilities()
    {
        return null;
    }

    @Override
    public void setAbilities(List<IAbility> abilities)
    {
        //Todo:This abilities field may have been a mistake. We'll have to come back and figure out what to do with it. At least for weapons
    }

    @Override
    public List<Damage> getDamage()
    {
        return damage;
    }

    @Override
    public void setDamage(List<Damage> damage)
    {
        //Todo: We may want to reexamine how we add damage, since most weapons only start with 1 type (change to an addDamageType(WeaponDamageTypeEnum) method instead?)
        this.damage = damage;
    }

    @Override
    public int getCriticalMultiplier()
    {
        return criticalMultiplier;
    }

    @Override
    public void setCriticalMultiplier(int criticalMultiplier)
    {
        this.criticalMultiplier = criticalMultiplier;
    }

    @Override
    public int getCriticalRange()
    {
        return criticalRange;
    }

    @Override
    public void setCriticalRange(int criticalRange)
    {
        this.criticalRange = criticalRange;
    }

    @Override
    public List<WeaponDamageTypeEnum> getDamageType()
    {
        return damageType;
    }

    @Override
    public void setDamageType(List<WeaponDamageTypeEnum> damageType)
    {
        //Todo: We may want to reexamine how we add damage types, since most weapons only have 1 type (change to an addDamageType(WeaponDamageTypeEnum) method instead?)
        this.damageType = damageType;
    }

    @Override
    public String getMaterial()
    {
        return material;
    }

    @Override
    public void setMaterial(String material)
    {
        this.material = material;
    }

    @Override
    public boolean isMasterwork()
    {
        return masterwork;
    }

    @Override
    public void setMasterwork(boolean masterwork)
    {
        this.masterwork = masterwork;
    }

    @Override
    public SizeCategoryEnum getSizeCategory()
    {
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
        return isMagic;
    }

    @Override
    public void setIsMagic(boolean isMagic)
    {
        this.isMagic = isMagic;
    }

    public int getRequiredStrength()
    {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength)
    {
        this.requiredStrength = requiredStrength;
    }

    public List<IWeaponEnchantment> getEnchantments()
    {
        return enchantments;
    }
    public void setEnchantments(List<IWeaponEnchantment> enchantments)
    {
        this.enchantments = enchantments;
    }

    //endregion


    public Weapon()
    {
        //Default constructor
    }

    public Weapon(String name, WeaponFamilyEnum family, int range, List<WeaponTagEnum> weaponTags, WeaponWeightClassEnum weightClass, double cost, List<Damage> damage, int criticalMultiplier, int criticalRange, List<WeaponDamageTypeEnum> damageType, String material, boolean masterwork, boolean isMagic, int magicBonus, SizeCategoryEnum sizeCategory, double weightAtMediumSize, int requiredStrength, List<IWeaponEnchantment> enchantments)
    {
        setName(name);
        setFamily(family);
        setRange(range);
        setWeightClass(weightClass);
        setCost(cost);
        setDamage(damage);
        setCriticalMultiplier(criticalMultiplier);
        setCriticalRange(criticalRange);
        setDamageType(damageType);
        setMaterial(material);
        setMasterwork(masterwork);
        setIsMagic(isMagic);
        setMagicBonus(magicBonus);
        setSizeCategory(sizeCategory);
        setWeightAtMediumSize(weightAtMediumSize);
        setRequiredStrength(requiredStrength);
        setEnchantments(enchantments);
        setWeaponTags(weaponTags);
    }

    public String createAbilitiesString()
    {
        StringBuilder enchantmentString = new StringBuilder("");
        if(enchantments != null && enchantments.size() > 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    public int calculateCriticalRange()
    {
        return 20 - criticalRange;
    }

    public String returnCriticalString()
    {
        String criticalString = "";
        int criticalRange = calculateCriticalRange();
        if(criticalRange < 20)
        {
            criticalString = Integer.toString(criticalRange) + "-20/x" + Integer.toString(criticalMultiplier);
        }
        else
        {
            criticalString = "20/x" + Integer.toString(criticalMultiplier);
        }
        return criticalString;
    }

    public String returnDamageTypes()
    {
        //As written, this can crash the program if a weapon doesn't have any damage types
        //However, UNDER NO CIRCUMSTANCES should a weapon not have a weapon type, so we're leaving this as is
        StringBuilder damageTypesString = new StringBuilder("");
        for(WeaponDamageTypeEnum damageType : damageType)
        {
            damageTypesString.append(damageType.toString()).append(", ");
        }
        damageTypesString = new StringBuilder(damageTypesString.substring(0, damageTypesString.length() - 2));
        return damageTypesString.toString();
    }

    public String returnDamageDice()
    {
        //Similar to returnDamageTypes, this will crash if a weapon has no damage dice
        //Again however, there should be NO CIRCUMSTANCES where that's the case
       StringBuilder damageDiceString = new StringBuilder("");
       for(Damage damageDice : damage)
       {
           damageDiceString.append(Integer.toString(damageDice.numberOfDice)).append("d").append(Integer.toString(damageDice.sizeOfDice)).append("+");
       }
       damageDiceString = new StringBuilder(damageDiceString.substring(0, damageDiceString.length() - 1));
       return damageDiceString.toString();
    }
}
