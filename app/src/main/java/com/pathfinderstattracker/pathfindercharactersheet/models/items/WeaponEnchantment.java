package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.ISense;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/13/2018.
 */

public class WeaponEnchantment implements IWeaponEnchantment
{
    private String name;
    private AbilityScoreEnum checkedAbilityScore;
    private ISkill checkedSkill;
    private AlignmentEnum requiredAlignment;
    private WeaponDamageTypeEnum requiredDamageType;
    private List<WeaponTagEnum> requiredTags;
    private Damage addedDamage;
    private String addedDamageType;//Fire, Ice, Necrotic, etc.
    private String damageDiceCondition; //"vs Evil", "vs Fire Subtype" etc
    private int conditionalEnhancementBonus = 0;
    private String enhancementBonusCondition;
    private int conditionalAttackBonus = 0;
    private String attackBonusCondition;
    private int enchantmentCharges = 0;
    private IFeat featAbilityForBonusCharges;
    private int numberOfFeatAbilityBonusCharges = 0;
    private IAbility classAbilityForBonusCharges;
    private int numberOfClassAbilityBonusCharges = 0;
    private String requiredWeaponName;
    private int bonusToCMB = 0;
    private String conditionForCMBBonus;
    private int bonusToCMD = 0;
    private String conditionForCMDBonus;
    private String enchantmentConditions;//This is for short descriptions that don't change numbers anywhere else, like "Ignores armor and shield bonuses", or "Affects incorporeal creatures"
    private String enchantmentFullText;//This is useful for the full text of enchantments, but also for enchantments that aren't anything but text, like Called
    private ISkill additionalSkillCheck;
    private boolean allowsAdditionalCMBCheck;
    private String saveForBonus;
    private String conditionForBonusToSave;
    private boolean changesSize;
    private ISkill skillForBonus;
    private String conditionForBonusToSkill;
    private boolean changesDamageDiceSize;
    private boolean changesCriticalRange;//The only ability that does this, Keen, only ever doubles the critical range, so we don't need to worry about tracking the size of the change
    private IAbility abilityForIncreasedDC;
    private int rangeMultiplier = 1;
    private int rangeModifier = 0;//This is for when a flat number of feet is added to a weapons range (like with Thrown)
    private int misfireDecrease = 0;
    private List<IWeaponEnchantment> restrictedWeaponEnchantments;
    private IFeat addedFeat;
    private ISense addedSense;
    private boolean damagesWielder;
    //region Getters and Setters
    @Override
    public String getName(){return name;}
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public AbilityScoreEnum getCheckedAbilityScore()
    {
        return checkedAbilityScore;
    }

    @Override
    public void setCheckedAbilityScore(AbilityScoreEnum abilityScore)
    {
        checkedAbilityScore = abilityScore;
    }

    @Override
    public ISkill getCheckedSkill()
    {
        return checkedSkill;
    }

    @Override
    public void setCheckedSkill(ISkill checkedSkill)
    {
        this.checkedSkill = checkedSkill;
    }

    @Override
    public AlignmentEnum getRequiredAlignment()
    {
        return requiredAlignment;
    }

    @Override
    public void setRequiredAlignment(AlignmentEnum requiredAlignment)
    {
        this.requiredAlignment = requiredAlignment;
    }

    @Override
    public WeaponDamageTypeEnum getRequiredDamageType()
    {
        return requiredDamageType;
    }

    @Override
    public void setRequiredDamageType(WeaponDamageTypeEnum requiredDamageType)
    {
        this.requiredDamageType =requiredDamageType;
    }

    @Override
    public List<WeaponTagEnum> getRequiredTags()
    {
        return requiredTags;
    }

    @Override
    public void setRequiredTags(List<WeaponTagEnum> weaponTags)
    {
        this.requiredTags = weaponTags;
    }

    @Override
    public Damage getDamageDice()
    {
        return addedDamage;
    }

    @Override
    public void setDamageDice(Damage damageDice)
    {
        addedDamage = damageDice;
    }

    @Override
    public String getAddedDamageType(){return addedDamageType;}

    @Override
    public void setAddedDamageType(String addedDamageType)
    {
        this.addedDamageType = addedDamageType;
    }

    @Override
    public String getDamageCondition()
    {
        return damageDiceCondition;
    }

    @Override
    public void setDamageCondition(String damageCondition)
    {
        damageDiceCondition = damageCondition;
    }

    @Override
    public int getConditionalEnhancementBonus()
    {
        return conditionalEnhancementBonus;
    }

    @Override
    public void setConditionalEnhancementBonus(int conditionalEnhancementBonus)
    {
        this.conditionalEnhancementBonus = conditionalEnhancementBonus;
    }

    @Override
    public String getEnhancementBonusCondition()
    {
        return enhancementBonusCondition;
    }

    @Override
    public void setEnhancementBonusCondition(String enhancementCondition)
    {
        enhancementBonusCondition = enhancementCondition;
    }

    @Override
    public int getConditionalAttackBonus()
    {
        return conditionalAttackBonus;
    }

    @Override
    public void setConditionalAttackBonus(int conditionalAttackBonus)
    {
        conditionalAttackBonus = conditionalAttackBonus;
    }

    @Override
    public String getAttackBonusCondition()
    {
        return attackBonusCondition;
    }

    @Override
    public void setAttackBonusCondition(String atackBonusCondition)
    {
        this.attackBonusCondition = attackBonusCondition;
    }

    @Override
    public int getEnchantmentCharges()
    {
        return enchantmentCharges;
    }

    @Override
    public void setEnchantmentCharges(int enchantmentCharges)
    {
        this.enchantmentCharges = enchantmentCharges;
    }

    @Override
    public IFeat getFeatAbilityForBonusCharges()
    {
        return featAbilityForBonusCharges;
    }

    @Override
    public void setFeatAbilityForBonusCharges(IFeat featAbilityForBonusCharges)
    {
        this.featAbilityForBonusCharges = featAbilityForBonusCharges;
    }

    @Override
    public int getNumberOfFeatAbilityBonusCharges()
    {
        return numberOfFeatAbilityBonusCharges;
    }

    @Override
    public void setNumberOfFeatAbilityBonusCharges(int numberOfFeatAbilityBonusCharges)
    {
        this.numberOfFeatAbilityBonusCharges = numberOfFeatAbilityBonusCharges;
    }

    @Override
    public IAbility getClassAbilityForBonusCharges()
    {
        return classAbilityForBonusCharges;
    }

    @Override
    public void setClassAbilityForBonusCharges(IAbility classAbilityForBonusCharges)
    {
        this.classAbilityForBonusCharges = classAbilityForBonusCharges;
    }

    @Override
    public int getNumberOfClassAbilityBonusCharges()
    {
        return numberOfClassAbilityBonusCharges;
    }

    @Override
    public void setNumberOfClassAbilityBonusCharges(int numberOfClassAbilityBonusCharges)
    {
        this.numberOfClassAbilityBonusCharges = numberOfClassAbilityBonusCharges;
    }

    @Override
    public String getRequiredWeaponName()
    {
        return requiredWeaponName;
    }

    @Override
    public void setRequiredWeaponName(String requiredWeaponName)
    {
        this.requiredWeaponName = requiredWeaponName;
    }

    @Override
    public int getCMDBonus()
    {
        return bonusToCMD;
    }

    @Override
    public void setCMDBonus(int cmdBonus)
    {
        bonusToCMD = cmdBonus;
    }

    @Override
    public String getCMDBonusCondition()
    {
        return conditionForCMDBonus;
    }

    @Override
    public void setCMDBonusCondition(String cmdBonusCondition)
    {
        conditionForCMDBonus = cmdBonusCondition;
    }

    @Override
    public int getCMBBonus()
    {
        return bonusToCMB;
    }

    @Override
    public void setCMBBonus(int cmbBonus)
    {
        bonusToCMB = cmbBonus;
    }

    @Override
    public String getCMBBonusCondition()
    {
        return conditionForCMBBonus;
    }

    @Override
    public void setCMBBonusCondition(String cmbBonusCondition)
    {
        conditionForCMBBonus = cmbBonusCondition;
    }

    @Override
    public String getEnchantmentConditionsText()
    {
        return enchantmentConditions;
    }

    @Override
    public void setEnchantmentConditionsText(String enchantmentConditionsText)
    {
        enchantmentConditions = enchantmentConditionsText;
    }

    @Override
    public String getEnchantmentText()
    {
        return enchantmentFullText;
    }

    @Override
    public void setEnchantmentText(String enchantmentFullText)
    {
        this.enchantmentFullText = enchantmentFullText;
    }

    @Override
    public ISkill getAdditionalSkillCheck()
    {
        return additionalSkillCheck;
    }

    @Override
    public void setAdditionalSkillCheck(ISkill additionalSkillCheck)
    {
        this.additionalSkillCheck = additionalSkillCheck;
    }

    @Override
    public boolean allowsAdditionalCMBCheck()
    {
        return allowsAdditionalCMBCheck;
    }

    @Override
    public void setAllowsAdditionalCMBCheck(boolean allowsAdditionalCMBCheck)
    {
        this.allowsAdditionalCMBCheck = allowsAdditionalCMBCheck;
    }

    @Override
    public String getSaveForBonus()
    {
        return saveForBonus;
    }

    @Override
    public void setSaveForBonus(String saveForBonus)
    {
        this.saveForBonus = saveForBonus;
    }

    @Override
    public String getConditionForBonusToSave()
    {
        return conditionForBonusToSave;
    }

    @Override
    public void setConditionForBonusToSave(String conditionForBonusToSave)
    {
        this.conditionForBonusToSave = conditionForBonusToSave;
    }

    @Override
    public boolean changesSize()
    {
        return changesSize;
    }

    @Override
    public void setChangesSize(boolean changesSize)
    {
        this.changesSize = changesSize;
    }

    @Override
    public ISkill getSkillForBonus()
    {
        return skillForBonus;
    }

    @Override
    public void setSkillForBonus(ISkill skillForBonus)
    {
        this.skillForBonus = skillForBonus;
    }

    @Override
    public String getConditionForSkillBonus()
    {
        return conditionForBonusToSkill;
    }

    @Override
    public void setConditionForSkillbonus(String conditionForSkillbonus)
    {
        this.conditionForBonusToSkill = conditionForSkillbonus;
    }

    @Override
    public boolean changesDamageDiceSize()
    {
        return changesDamageDiceSize;
    }

    @Override
    public void setChangesDamageDiceSize(boolean changesDamageDiceSize)
    {
        this.changesDamageDiceSize = changesDamageDiceSize;
    }

    @Override
    public boolean changesCriticalRange()
    {
        return changesCriticalRange;
    }

    @Override
    public void setChangesCriticalRange(boolean changesCriticalRange)
    {
        this.changesCriticalRange = changesCriticalRange;
    }

    @Override
    public IAbility getAbilityForIncreasedDC()
    {
        return abilityForIncreasedDC;
    }

    @Override
    public void setAbilityForIncreasedDC(IAbility abilityForIncreasedDC)
    {
        this.abilityForIncreasedDC = abilityForIncreasedDC;
    }

    @Override
    public int getRangeMultiplier()
    {
        return rangeMultiplier;
    }

    @Override
    public void setRangeMultiplier(int rangeMultiplier)
    {
        this.rangeMultiplier = rangeMultiplier;
    }

    @Override
    public int getRangeModifier()
    {
        return rangeModifier;
    }

    @Override
    public void setRangeModifier(int rangeModifier)
    {
        this.rangeModifier = rangeModifier;
    }

    @Override
    public int getMisfireDecrease()
    {
        return misfireDecrease;
    }

    @Override
    public void setMisfireDecrease(int misfireDecrease)
    {
        this.misfireDecrease = misfireDecrease;
    }

    @Override
    public List<IWeaponEnchantment> getRestrictedWeaponEnchantments()
    {
        return restrictedWeaponEnchantments;
    }

    @Override
    public void setRestrictedWeaponEnchantments(List<IWeaponEnchantment> restrictedWeaponEnchantments)
    {
        this.restrictedWeaponEnchantments = restrictedWeaponEnchantments;
    }

    @Override
    public IFeat getAddedFeat()
    {
        return addedFeat;
    }

    @Override
    public void setAddedFeat(IFeat addedFeat)
    {
        this.addedFeat = addedFeat;
    }

    @Override
    public ISense getAddedSenses()
    {
        return addedSense;
    }

    @Override
    public void setAddedSenses(ISense addedSenses)
    {
        this.addedSense = addedSenses;
    }

    @Override
    public boolean doesDamageToWielder()
    {
        return damagesWielder;
    }

    @Override
    public void setDoesDamageToWielder(boolean doesDamageToWielder)
    {
        //We can be a little lazy here. Only one enchantment, Vicious does damage to the wielder, and it does 1d6 every time.
        damagesWielder = doesDamageToWielder;
    }
    //endregion

    public WeaponEnchantment()
    {
        //Do nothing
    }

    public WeaponEnchantment(String name, Damage addedDamage, String addedDamageType)
    {
        //This constructor is meant for the elemental enchantments(fire, frost, lightning, etc)
        setName(name);
        setDamageDice(addedDamage);
        setAddedDamageType(addedDamageType);
    }
}
