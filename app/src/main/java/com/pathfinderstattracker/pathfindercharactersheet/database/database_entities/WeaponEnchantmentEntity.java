package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AlignmentEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponDamageTypeEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.ISense;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = SkillWeaponEnchantmentJoinTableEntity.class,
                                           parentColumns = "weapon_enchantment_id",
                                           childColumns = "uid"))
@TypeConverters({AbilityScoreEnumConverter.class, AlignmentEnumConverter.class, WeaponDamageTypeEnumConverter.class})
public class WeaponEnchantmentEntity
{
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "gold_cost")
    private double goldCost;
    @ColumnInfo(name = "enhancement_bonus_pont_cost")
    private int enhancementBonusPointCost = 0;
    @ColumnInfo(name = "enchantment_name")
    private String name;
    @ColumnInfo(name = "checked_ability_score")
    private AbilityScoreEnum checkedAbilityScore;
    @ColumnInfo(name = "checked_skill_id")
    private int checkedSkillID;
    @ColumnInfo(name = "required_alignment")
    private AlignmentEnum requiredAlignment;
    @ColumnInfo(name = "required_damage_type")
    private WeaponDamageTypeEnum requiredDamageType;
    @ColumnInfo(name = "required_tags")
    private List<WeaponTagEnum> requiredTags;
    @ColumnInfo(name = "added_damage")
    private Damage addedDamage;
    @ColumnInfo(name = "added_damage_type")
    private String addedDamageType;//Fire, Ice, Necrotic, etc.
    @ColumnInfo(name = "damage_dice_condition")
    private String damageDiceCondition; //"vs Evil", "vs Fire Subtype" etc
    @ColumnInfo(name = "conditional_enhancement_bonus")
    private int conditionalEnhancementBonus = 0;
    @ColumnInfo(name = "enhancement_bonus_condition")
    private String enhancementBonusCondition;
    @ColumnInfo(name = "conditional_attack_bonus")
    private int conditionalAttackBonus = 0;
    @ColumnInfo(name = "attack_bonus_condition")
    private String attackBonusCondition;
    @ColumnInfo(name = "enchantment_charges")
    private int enchantmentCharges = 0;
    @ColumnInfo(name = "feat_ability_for_bonus_charges")
    private IFeat featAbilityForBonusCharges;
    @ColumnInfo(name = "number_of_feat_ability_bonus_charges")
    private int numberOfFeatAbilityBonusCharges = 0;
    @ColumnInfo(name = "class_ability_for_bonus_charges")
    private IAbility classAbilityForBonusCharges;
    @ColumnInfo(name = "number_of_class_ability_bonus_charges")
    private int numberOfClassAbilityBonusCharges = 0;
    @ColumnInfo(name = "required_weapon_name")
    private String requiredWeaponName;
    @ColumnInfo(name = "bonus_to_cmb")
    private int bonusToCMB = 0;
    @ColumnInfo(name = "condition_for_cmb_bonus")
    private String conditionForCMBBonus;
    @ColumnInfo(name = "bonus_to_cmd")
    private int bonusToCMD = 0;
    @ColumnInfo(name = "condition_for_cmd_bonus")
    private String conditionForCMDBonus;
    @ColumnInfo(name = "enchantment_conditions")
    private String enchantmentConditions;//This is for short descriptions that don't change numbers anywhere else, like "Ignores armor and shield bonuses", or "Affects incorporeal creatures"
    @ColumnInfo(name = "enchantment_full_text")
    private String enchantmentFullText;//This is useful for the full text of enchantments, but also for enchantments that aren't anything but text, like Called
    @ColumnInfo(name = "additional_skill_check")
    private ISkill additionalSkillCheck;
    @ColumnInfo(name = "allows_additional_cmb_check")
    private boolean allowsAdditionalCMBCheck;
    @ColumnInfo(name = "save_for_bonus")
    private String saveForBonus;
    @ColumnInfo(name = "condition_for_bonus_to_save")
    private String conditionForBonusToSave;
    @ColumnInfo(name = "changes_size")
    private boolean changesSize;
    @ColumnInfo(name = "skill_for_bonus")
    private ISkill skillForBonus;
    @ColumnInfo(name = "condition_for_bonus_to_skill")
    private String conditionForBonusToSkill;
    @ColumnInfo(name = "changes_damage_dice_size")
    private boolean changesDamageDiceSize;
    @ColumnInfo(name = "changes_critical_range")
    private boolean changesCriticalRange;//The only ability that does this, Keen, only ever doubles the critical range, so we don't need to worry about tracking the size of the change
    @ColumnInfo(name = "ability_for_increased_dc")
    private IAbility abilityForIncreasedDC;
    @ColumnInfo(name = "range_multiplier")
    private int rangeMultiplier = 1;
    @ColumnInfo(name = "range_modifier")
    private int rangeModifier = 0;//This is for when a flat number of feet is added to a weapons range (like with Thrown)
    @ColumnInfo(name = "misfire_decrease")
    private int misfireDecrease = 0;
    @ColumnInfo(name = "restricted_weapon_enchantments")
    private List<IWeaponEnchantment> restrictedWeaponEnchantments;
    @ColumnInfo(name = "added_feat")
    private IFeat addedFeat;
    @ColumnInfo(name = "added_sense")
    private ISense addedSense;
    @ColumnInfo(name = "damages_wielder")
    private boolean damagesWielder;
    @ColumnInfo(name = "required_weight_class")
    private WeaponWeightClassEnum requiredWeightClass;
    @ColumnInfo(name = "restricted_weight_class")
    private List<WeaponWeightClassEnum> restrictedWeightClasses;

    //region Getters and Setters
    public int getUid()
    {
        return uid;
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public double getGoldCost()
    {
        return goldCost;
    }

    public void setGoldCost(double goldCost)
    {
        this.goldCost = goldCost;
    }

    public int getEnhancementBonusPointCost()
    {
        return enhancementBonusPointCost;
    }

    public void setEnhancementBonusPointCost(int enhancementBonusPointCost)
    {
        this.enhancementBonusPointCost = enhancementBonusPointCost;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AbilityScoreEnum getCheckedAbilityScore()
    {
        return checkedAbilityScore;
    }

    public void setCheckedAbilityScore(AbilityScoreEnum checkedAbilityScore)
    {
        this.checkedAbilityScore = checkedAbilityScore;
    }

    public int getCheckedSkill()
    {
        return checkedSkillID;
    }

    public void setCheckedSkill(int checkedSkillID)
    {
        this.checkedSkillID = checkedSkillID;
    }

    public AlignmentEnum getRequiredAlignment()
    {
        return requiredAlignment;
    }

    public void setRequiredAlignment(AlignmentEnum requiredAlignment)
    {
        this.requiredAlignment = requiredAlignment;
    }

    public WeaponDamageTypeEnum getRequiredDamageType()
    {
        return requiredDamageType;
    }

    public void setRequiredDamageType(WeaponDamageTypeEnum requiredDamageType)
    {
        this.requiredDamageType = requiredDamageType;
    }

    public List<WeaponTagEnum> getRequiredTags()
    {
        return requiredTags;
    }

    public void setRequiredTags(List<WeaponTagEnum> requiredTags)
    {
        this.requiredTags = requiredTags;
    }

    public Damage getAddedDamage()
    {
        return addedDamage;
    }

    public void setAddedDamage(Damage addedDamage)
    {
        this.addedDamage = addedDamage;
    }

    public String getAddedDamageType()
    {
        return addedDamageType;
    }

    public void setAddedDamageType(String addedDamageType)
    {
        this.addedDamageType = addedDamageType;
    }

    public String getDamageDiceCondition()
    {
        return damageDiceCondition;
    }

    public void setDamageDiceCondition(String damageDiceCondition)
    {
        this.damageDiceCondition = damageDiceCondition;
    }

    public int getConditionalEnhancementBonus()
    {
        return conditionalEnhancementBonus;
    }

    public void setConditionalEnhancementBonus(int conditionalEnhancementBonus)
    {
        this.conditionalEnhancementBonus = conditionalEnhancementBonus;
    }

    public String getEnhancementBonusCondition()
    {
        return enhancementBonusCondition;
    }

    public void setEnhancementBonusCondition(String enhancementBonusCondition)
    {
        this.enhancementBonusCondition = enhancementBonusCondition;
    }

    public int getConditionalAttackBonus()
    {
        return conditionalAttackBonus;
    }

    public void setConditionalAttackBonus(int conditionalAttackBonus)
    {
        this.conditionalAttackBonus = conditionalAttackBonus;
    }

    public String getAttackBonusCondition()
    {
        return attackBonusCondition;
    }

    public void setAttackBonusCondition(String attackBonusCondition)
    {
        this.attackBonusCondition = attackBonusCondition;
    }

    public int getEnchantmentCharges()
    {
        return enchantmentCharges;
    }

    public void setEnchantmentCharges(int enchantmentCharges)
    {
        this.enchantmentCharges = enchantmentCharges;
    }

    public IFeat getFeatAbilityForBonusCharges()
    {
        return featAbilityForBonusCharges;
    }

    public void setFeatAbilityForBonusCharges(IFeat featAbilityForBonusCharges)
    {
        this.featAbilityForBonusCharges = featAbilityForBonusCharges;
    }

    public int getNumberOfFeatAbilityBonusCharges()
    {
        return numberOfFeatAbilityBonusCharges;
    }

    public void setNumberOfFeatAbilityBonusCharges(int numberOfFeatAbilityBonusCharges)
    {
        this.numberOfFeatAbilityBonusCharges = numberOfFeatAbilityBonusCharges;
    }

    public IAbility getClassAbilityForBonusCharges()
    {
        return classAbilityForBonusCharges;
    }

    public void setClassAbilityForBonusCharges(IAbility classAbilityForBonusCharges)
    {
        this.classAbilityForBonusCharges = classAbilityForBonusCharges;
    }

    public int getNumberOfClassAbilityBonusCharges()
    {
        return numberOfClassAbilityBonusCharges;
    }

    public void setNumberOfClassAbilityBonusCharges(int numberOfClassAbilityBonusCharges)
    {
        this.numberOfClassAbilityBonusCharges = numberOfClassAbilityBonusCharges;
    }

    public String getRequiredWeaponName()
    {
        return requiredWeaponName;
    }

    public void setRequiredWeaponName(String requiredWeaponName)
    {
        this.requiredWeaponName = requiredWeaponName;
    }

    public int getBonusToCMB()
    {
        return bonusToCMB;
    }

    public void setBonusToCMB(int bonusToCMB)
    {
        this.bonusToCMB = bonusToCMB;
    }

    public String getConditionForCMBBonus()
    {
        return conditionForCMBBonus;
    }

    public void setConditionForCMBBonus(String conditionForCMBBonus)
    {
        this.conditionForCMBBonus = conditionForCMBBonus;
    }

    public int getBonusToCMD()
    {
        return bonusToCMD;
    }

    public void setBonusToCMD(int bonusToCMD)
    {
        this.bonusToCMD = bonusToCMD;
    }

    public String getConditionForCMDBonus()
    {
        return conditionForCMDBonus;
    }

    public void setConditionForCMDBonus(String conditionForCMDBonus)
    {
        this.conditionForCMDBonus = conditionForCMDBonus;
    }

    public String getEnchantmentConditions()
    {
        return enchantmentConditions;
    }

    public void setEnchantmentConditions(String enchantmentConditions)
    {
        this.enchantmentConditions = enchantmentConditions;
    }

    public String getEnchantmentFullText()
    {
        return enchantmentFullText;
    }

    public void setEnchantmentFullText(String enchantmentFullText)
    {
        this.enchantmentFullText = enchantmentFullText;
    }

    public ISkill getAdditionalSkillCheck()
    {
        return additionalSkillCheck;
    }

    public void setAdditionalSkillCheck(ISkill additionalSkillCheck)
    {
        this.additionalSkillCheck = additionalSkillCheck;
    }

    public boolean isAllowsAdditionalCMBCheck()
    {
        return allowsAdditionalCMBCheck;
    }

    public void setAllowsAdditionalCMBCheck(boolean allowsAdditionalCMBCheck)
    {
        this.allowsAdditionalCMBCheck = allowsAdditionalCMBCheck;
    }

    public String getSaveForBonus()
    {
        return saveForBonus;
    }

    public void setSaveForBonus(String saveForBonus)
    {
        this.saveForBonus = saveForBonus;
    }

    public String getConditionForBonusToSave()
    {
        return conditionForBonusToSave;
    }

    public void setConditionForBonusToSave(String conditionForBonusToSave)
    {
        this.conditionForBonusToSave = conditionForBonusToSave;
    }

    public boolean isChangesSize()
    {
        return changesSize;
    }

    public void setChangesSize(boolean changesSize)
    {
        this.changesSize = changesSize;
    }

    public ISkill getSkillForBonus()
    {
        return skillForBonus;
    }

    public void setSkillForBonus(ISkill skillForBonus)
    {
        this.skillForBonus = skillForBonus;
    }

    public String getConditionForBonusToSkill()
    {
        return conditionForBonusToSkill;
    }

    public void setConditionForBonusToSkill(String conditionForBonusToSkill)
    {
        this.conditionForBonusToSkill = conditionForBonusToSkill;
    }

    public boolean isChangesDamageDiceSize()
    {
        return changesDamageDiceSize;
    }

    public void setChangesDamageDiceSize(boolean changesDamageDiceSize)
    {
        this.changesDamageDiceSize = changesDamageDiceSize;
    }

    public boolean isChangesCriticalRange()
    {
        return changesCriticalRange;
    }

    public void setChangesCriticalRange(boolean changesCriticalRange)
    {
        this.changesCriticalRange = changesCriticalRange;
    }

    public IAbility getAbilityForIncreasedDC()
    {
        return abilityForIncreasedDC;
    }

    public void setAbilityForIncreasedDC(IAbility abilityForIncreasedDC)
    {
        this.abilityForIncreasedDC = abilityForIncreasedDC;
    }

    public int getRangeMultiplier()
    {
        return rangeMultiplier;
    }

    public void setRangeMultiplier(int rangeMultiplier)
    {
        this.rangeMultiplier = rangeMultiplier;
    }

    public int getRangeModifier()
    {
        return rangeModifier;
    }

    public void setRangeModifier(int rangeModifier)
    {
        this.rangeModifier = rangeModifier;
    }

    public int getMisfireDecrease()
    {
        return misfireDecrease;
    }

    public void setMisfireDecrease(int misfireDecrease)
    {
        this.misfireDecrease = misfireDecrease;
    }

    public List<IWeaponEnchantment> getRestrictedWeaponEnchantments()
    {
        return restrictedWeaponEnchantments;
    }

    public void setRestrictedWeaponEnchantments(List<IWeaponEnchantment> restrictedWeaponEnchantments)
    {
        this.restrictedWeaponEnchantments = restrictedWeaponEnchantments;
    }

    public IFeat getAddedFeat()
    {
        return addedFeat;
    }

    public void setAddedFeat(IFeat addedFeat)
    {
        this.addedFeat = addedFeat;
    }

    public ISense getAddedSense()
    {
        return addedSense;
    }

    public void setAddedSense(ISense addedSense)
    {
        this.addedSense = addedSense;
    }

    public boolean isDamagesWielder()
    {
        return damagesWielder;
    }

    public void setDamagesWielder(boolean damagesWielder)
    {
        this.damagesWielder = damagesWielder;
    }

    public WeaponWeightClassEnum getRequiredWeightClass()
    {
        return requiredWeightClass;
    }

    public void setRequiredWeightClass(WeaponWeightClassEnum requiredWeightClass)
    {
        this.requiredWeightClass = requiredWeightClass;
    }

    public List<WeaponWeightClassEnum> getRestrictedWeightClasses()
    {
        return restrictedWeightClasses;
    }

    public void setRestrictedWeightClasses(List<WeaponWeightClassEnum> restrictedWeightClasses)
    {
        this.restrictedWeightClasses = restrictedWeightClasses;
    }
    //endregion
}
