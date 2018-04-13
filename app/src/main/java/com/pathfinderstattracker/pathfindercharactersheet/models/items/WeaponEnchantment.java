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
    private AbilityScoreEnum checkedAbilityScore;
    private ISkill checkedSkill;
    private AlignmentEnum requiredAlignment;
    private WeaponDamageTypeEnum requiredDamageType;
    private List<WeaponTagEnum> requiredTags;
    private Damage addedDamage;
    private String damageDiceCondition; //"vs Evil", "vs Fire Subtype" etc
    private int conditionalEnhancementBonus;
    private String enhancementBonusCondition;
    private int conditionalAttackBonus;
    private String attackBonusCondition;
    private int enchantmentCharges;
    private IFeat featAbilityForBonusCharges;
    private int numberOfFeatAbilityBonusCharges;
    private IAbility classAbilityForBonusCharges;
    private int numberOfClassAbilityBonusCharges;
    private String requiredWeaponName;
    private int bonusToCMB;
    private String conditionForCMBBonus;
    private int bonusToCMD;
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
    private int rangeMultiplier;
    private int rangeModifier;//This is for when a flat number of feet is added to a weapons range (like with Thrown)
    private int misfireDecrease;
    private List<IWeaponEnchantment> restrictedWeaponEnchantments;
    private IFeat addedFeat;
    private ISense addedSense;
    private boolean damagesWielder;
    //region Getters and Setters
    @Override
    public AbilityScoreEnum getCheckedAbilityScore()
    {
        return null;
    }

    @Override
    public void setCheckedAbilityScore(AbilityScoreEnum abilityScore)
    {

    }

    @Override
    public ISkill getCheckedSkill()
    {
        return null;
    }

    @Override
    public void setCheckedSkill(ISkill checkedSkill)
    {

    }

    @Override
    public AlignmentEnum getRequiredAlignment()
    {
        return null;
    }

    @Override
    public void setRequiredAlignment(AlignmentEnum requiredAlignment)
    {

    }

    @Override
    public WeaponDamageTypeEnum getRequiredDamageType()
    {
        return null;
    }

    @Override
    public void setRequiredDamageType(WeaponDamageTypeEnum requiredDamageType)
    {

    }

    @Override
    public List<WeaponTagEnum> getRequiredTags()
    {
        return null;
    }

    @Override
    public void setRequiredTags(List<WeaponTagEnum> weaponTags)
    {

    }

    @Override
    public Damage getDamageDice()
    {
        return null;
    }

    @Override
    public void setDamageDice(Damage damageDice)
    {

    }

    @Override
    public String getDamageCondition()
    {
        return null;
    }

    @Override
    public void setDamageCondition(String damageCondition)
    {

    }

    @Override
    public int getConditionalEnhancementBonus()
    {
        return 0;
    }

    @Override
    public void setConditionalEnhancementBonus(int conditionalEnhancementBonus)
    {

    }

    @Override
    public String getEnhancementBonusCondition()
    {
        return null;
    }

    @Override
    public void setEnhancementBonusCondition(String enhancementCondition)
    {

    }

    @Override
    public int getConditionalAttackBonus()
    {
        return 0;
    }

    @Override
    public void setConditionalAttackBonus(int conditionalAttackBonus)
    {

    }

    @Override
    public String getAttackBonusCondition()
    {
        return null;
    }

    @Override
    public void setAttackBonusCondition(String atackBonusCondition)
    {

    }

    @Override
    public int getEnchantmentCharges()
    {
        return 0;
    }

    @Override
    public void setEnchantmentCharges(Integer enchantmentCharges)
    {

    }

    @Override
    public IFeat getFeatAbilityForBonusCharges()
    {
        return null;
    }

    @Override
    public void setFeatAbilityForBonusCharges(IFeat featForBonusCharges)
    {

    }

    @Override
    public int getNumberOfFeatAbilityBonusCharges()
    {
        return 0;
    }

    @Override
    public void setNumberOfFeatAbilityBonusCharges(Integer numberOfFeatAbilityBonusCharges)
    {

    }

    @Override
    public IAbility getClassAbilityForBonusCharges()
    {
        return null;
    }

    @Override
    public void setClassAbilityForBonusCharges(IAbility abilityForBonusCharges)
    {

    }

    @Override
    public int getNumberOfClassAbilityBonusCharges()
    {
        return 0;
    }

    @Override
    public void setNumberOfClassAbilityBonusCharges(Integer numberOfFeatAbilityBonusCharges)
    {

    }

    @Override
    public String getRequiredWeaponName()
    {
        return null;
    }

    @Override
    public void setRequiredWeaponName(String requiredWeaponName)
    {

    }

    @Override
    public int getCMDBonus()
    {
        return 0;
    }

    @Override
    public void setCMDBonus(int cmdBonus)
    {

    }

    @Override
    public String getCMDBonusCondition()
    {
        return null;
    }

    @Override
    public void setCMDBonusCondition(String cmdBonusCondition)
    {

    }

    @Override
    public int getCMBBonus()
    {
        return 0;
    }

    @Override
    public void setCMBBonus(int cmbBonus)
    {

    }

    @Override
    public String getCMBBonusCondition()
    {
        return null;
    }

    @Override
    public void setCMBBonusCondition(String cmbBonusCondition)
    {

    }

    @Override
    public String getEnchantmentConditionsText()
    {
        return null;
    }

    @Override
    public void setEnchantmentConditionsText(String enchantmentConditionsText)
    {

    }

    @Override
    public String getEnchantmentText()
    {
        return null;
    }

    @Override
    public void setEnchantmentText(String enchantmentText)
    {

    }

    @Override
    public ISkill getAdditionalSkillCheck()
    {
        return null;
    }

    @Override
    public void setAdditionalSkillCheck(ISkill additionalSkillCheck)
    {

    }

    @Override
    public boolean allowsAdditionalCMBCheck()
    {
        return false;
    }

    @Override
    public void setAllowsAdditionalCMBCheck(boolean allowsAdditionalCMBCheck)
    {

    }

    @Override
    public String getSaveForBonus()
    {
        return null;
    }

    @Override
    public void setSaveForBonus(String saveForBonus)
    {

    }

    @Override
    public String getConditionForBonusToSave()
    {
        return null;
    }

    @Override
    public void setConditionForBonusToSave(String conditionForBonusToSave)
    {

    }

    @Override
    public boolean changesSize()
    {
        return false;
    }

    @Override
    public void setChangesSize(boolean changesSize)
    {

    }

    @Override
    public ISkill getSkillForBonus()
    {
        return null;
    }

    @Override
    public void setSkillForBonus(ISkill skillForBonus)
    {

    }

    @Override
    public String getConditionForSkillBonus()
    {
        return null;
    }

    @Override
    public void setConditionForSkillbonus(String conditionForSkillbonus)
    {

    }

    @Override
    public boolean changesDamageDiceSize()
    {
        return false;
    }

    @Override
    public void setChangesDamageDiceSize(boolean changesDamageDiceSize)
    {

    }

    @Override
    public boolean changesCriticalRange()
    {
        return false;
    }

    @Override
    public void setChangesCriticalRange(boolean changesCriticalRange)
    {

    }

    @Override
    public IAbility getAbilityForIncreasedDC()
    {
        return null;
    }

    @Override
    public void setAbilityForIncreasedDC(IAbility abilityForIncreasedDC)
    {

    }

    @Override
    public int getRangeMultiplier()
    {
        return 0;
    }

    @Override
    public void setRangeMultiplier(int rangeMultiplier)
    {

    }

    @Override
    public int getRangeModifier()
    {
        return 0;
    }

    @Override
    public void setRangeModifier(int rangeModifier)
    {

    }

    @Override
    public int getMisfireDecrease()
    {
        return 0;
    }

    @Override
    public void setMisfireDecrease(int misfireDecrease)
    {

    }

    @Override
    public List<IWeaponEnchantment> getRestrictedWeaponEnchantments()
    {
        return null;
    }

    @Override
    public void setRestrictedWeaponEnchantments(List<IWeaponEnchantment> restrictedWeaponEnchantments)
    {

    }

    @Override
    public IFeat getAddedFeat()
    {
        return null;
    }

    @Override
    public void setAddedFeat(IFeat addedFeat)
    {

    }

    @Override
    public ISense getAddedSenses()
    {
        return null;
    }

    @Override
    public void setAddedSenses(ISense addedSenses)
    {

    }

    @Override
    public boolean doesDamageToWielder()
    {
        return false;
    }

    @Override
    public void setDoesDamageToWielder(boolean doesDamageToWielder)
    {

    }
    //endregion

    public WeaponEnchantment()
    {
        //Do nothing
    }
}
