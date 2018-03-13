package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;

/**
 * Created by Stephen Hagen on 12/27/2017.
 */

public class Weapon implements IWeapon
{
    private String name;
    private WeaponFamilyEnum family;
    private int range;
    private boolean reach;
    private boolean thrown;
    private boolean doubleheaded;
    private boolean projectile;
    private WeaponWeightClassEnum weightClass;
    private boolean improvised;
    private double cost;
    private Damage[] damage;
    private int criticalMultiplier;
    private int criticalRange; //Rather than being an actual range like 19-20, this is instead the number of critical values, so the default is 1, 19-20 is 2, 18-20 is 3, etc
    private boolean brace;
    private WeaponDamageTypeEnum[] damageType;
    private boolean disarm;
    private boolean monk;
    private boolean trip;
    private boolean nonLethal;
    private String material;
    private boolean masterwork;
    private boolean isMagic;
    private int magicBonus;
    private SizeCategoryEnum sizeCategory;
    private double weightAtMediumSize;
    private int requiredStrength;
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
    public boolean hasReach()
    {
        return reach;
    }

    @Override
    public void setReach(boolean hasReach)
    {
        this.reach = hasReach;
    }

    @Override
    public boolean isThrown()
    {
        return thrown;
    }

    @Override
    public void setThrown(boolean isThrown)
    {
        this.thrown = isThrown;
    }

    @Override
    public boolean isDoubleheaded()
    {
        return doubleheaded;
    }

    @Override
    public void setDoubleheaded(boolean isDoubleheaded)
    {
        this.doubleheaded = doubleheaded;
    }

    @Override
    public boolean usesProjectile()
    {
        return projectile;
    }

    @Override
    public void setProjectile(boolean usesProjectile)
    {
        this.projectile = usesProjectile;
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
    public boolean isImprovised()
    {
        return improvised;
    }

    @Override
    public void setImprovised(boolean isImprovised)
    {
        this.improvised = isImprovised;
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
    public Damage[] getDamage()
    {
        return damage;
    }

    @Override
    public void setDamage(Damage[] damage)
    {
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
    public boolean canBrace()
    {
        return brace;
    }

    @Override
    public void setBrace(boolean brace)
    {
        this.brace = brace;
    }

    @Override
    public WeaponDamageTypeEnum[] getDamageType()
    {
        return damageType;
    }

    @Override
    public void setDamageType(WeaponDamageTypeEnum[] damageType)
    {
        this.damageType = damageType;
    }

    @Override
    public boolean canDisarm()
    {
        return disarm;
    }

    @Override
    public void setDisarm(boolean disarm)
    {
        this.disarm = disarm;
    }

    @Override
    public boolean isMonk()
    {
        return monk;
    }

    @Override
    public void setMonk(boolean monk)
    {
        this.monk = monk;
    }

    @Override
    public boolean canTrip()
    {
        return trip;
    }

    @Override
    public void setTrip(boolean trip)
    {
        this.trip = trip;
    }

    @Override
    public boolean isNonLethal()
    {
        return nonLethal;
    }

    @Override
    public void setNonLethal(boolean nonLethal)
    {
        this.nonLethal = nonLethal;
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

    public int getRequiredStrength()
    {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength)
    {
        this.requiredStrength = requiredStrength;
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


    public Weapon()
    {
        //Default constructor
    }

    public Weapon(String name, WeaponFamilyEnum family, int range, boolean reach, boolean thrown, boolean doubleheaded, boolean projectile, WeaponWeightClassEnum weightClass, boolean improvised, double cost, Damage[] damage, int criticalMultiplier, int criticalRange, boolean brace, WeaponDamageTypeEnum[] damageType, boolean disarm, boolean monk, boolean trip, boolean nonLethal, String material, boolean masterwork, boolean isMagic, int magicBonus, SizeCategoryEnum sizeCategory, double weightAtMediumSize, int requiredStrength, Ability[] abilities)
    {
        setName(name);
        setFamily(family);
        setRange(range);
        setReach(reach);
        setThrown(thrown);
        setDoubleheaded(doubleheaded);
        setProjectile(projectile);
        setWeightClass(weightClass);
        setImprovised(improvised);
        setCost(cost);
        setDamage(damage);
        setCriticalMultiplier(criticalMultiplier);
        setCriticalRange(criticalRange);
        setBrace(brace);
        setDamageType(damageType);
        setDisarm(disarm);
        setMonk(monk);
        setTrip(trip);
        setNonLethal(nonLethal);
        setMaterial(material);
        setMasterwork(masterwork);
        setIsMagic(isMagic);
        setMagicBonus(magicBonus);
        setSizeCategory(sizeCategory);
        setWeightAtMediumSize(weightAtMediumSize);
        setRequiredStrength(requiredStrength);
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

    public int calculateCriticalRange()
    {
        return 20 - criticalRange;
    }

    public String returnCriticalString()
    {
        String criticalString = new String();
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
        String damageTypesString = new String();
        for(WeaponDamageTypeEnum damageType : damageType)
        {
            damageTypesString += damageType.toString() + ", ";
        }
        damageTypesString = damageTypesString.substring(0, damageTypesString.length() - 2);
        return damageTypesString;
    }

    public String returnDamageDice()
    {
        //Similar to returnDamageTypes, this will crash if a weapon has no damage dice
        //Again however, there should be NO CIRCUMSTANCES where that's the case
       String damageDiceString = new String();
       for(Damage damageDice : damage)
       {
           damageDiceString += Integer.toString(damageDice.numberOfDice) + "d" + Integer.toString(damageDice.sizeOfDice) + "+";
       }
       damageDiceString = damageDiceString.substring(0, damageDiceString.length() - 1);
       return damageDiceString;
    }
}
