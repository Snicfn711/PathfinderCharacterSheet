package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AlignmentEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.DamageConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponDamageTypeEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponTagEnumListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponWeightClassEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponWeightClassEnumListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponTagEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Entity(tableName = "weapon_enchantments",
/*        foreignKeys = {@ForeignKey(entity = SkillEntity.class,
                                   parentColumns = "skillID",
                                   childColumns = "checked_skillID"),
                       @ForeignKey(entity = SkillEntity.class,
                                   parentColumns = "skillID",
                                   childColumns = "skillID_for_additional_check"),
                       @ForeignKey(entity = SkillEntity.class,
                                   parentColumns = "skillID",
                                   childColumns = "skillID_for_bonus"),
                       @ForeignKey(entity = FeatEntity.class,
                                   parentColumns = "featID",
                                   childColumns = "featID_for_bonus_charges"),
                       @ForeignKey(entity = FeatEntity.class,
                                   parentColumns = "featID",
                                   childColumns = "added_featID"),
                       @ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "class_abilityID_for_bonus_charges"),
                       @ForeignKey(entity = AbilityEntity.class,
                                   parentColumns = "abilityID",
                                   childColumns = "abilityID_for_increased_dc"),
                       @ForeignKey(entity = SenseEntity.class,
                                   parentColumns = "senseID",
                                   childColumns = "added_senseID")},*/
        indices = {@Index("checked_skillID"),
                   @Index("skillID_for_additional_check"),
                   @Index("skillID_for_bonus"),
                   @Index("featID_for_bonus_charges"),
                   @Index("added_featID"),
                   @Index("class_abilityID_for_bonus_charges"),
                   @Index("abilityID_for_increased_dc"),
                   @Index("added_senseID")})
@TypeConverters({AbilityScoreEnumConverter.class,
                 AlignmentEnumConverter.class,
                 WeaponDamageTypeEnumConverter.class,
                 DamageConverter.class,
                 WeaponTagEnumListConverter.class,
                 WeaponWeightClassEnumConverter.class,
                 WeaponWeightClassEnumListConverter.class})
public class WeaponEnchantmentEntity
{
    @PrimaryKey
    private int weaponEnchantmentID;

    @ColumnInfo(name = "gold_cost")
    private double goldCost;
    @ColumnInfo(name = "enhancement_bonus_pont_cost")
    private int enhancementBonusPointCost;
    @ColumnInfo(name = "enchantment_name")
    private String name;
    @ColumnInfo(name = "checked_ability_score")
    private AbilityScoreEnum checkedAbilityScore;
    @ColumnInfo(name = "checked_skillID")
    private int checkedSkillID;
    @ColumnInfo(name = "required_alignment")
    private AlignmentEnum requiredAlignment;
    @ColumnInfo(name = "required_damage_type")
    private WeaponDamageTypeEnum requiredDamageType;
    @ColumnInfo(name = "required_tags")
    public List<WeaponTagEnum> requiredTags;
    @ColumnInfo(name = "added_damage")
    private Damage addedDamage;
    @ColumnInfo(name = "added_damage_type")
    private String addedDamageType;//Fire, Ice, Necrotic, etc.
    @ColumnInfo(name = "damage_dice_condition")
    private String damageDiceCondition; //"vs Evil", "vs Fire Subtype" etc
    @ColumnInfo(name = "conditional_enhancement_bonus")
    private int conditionalEnhancementBonus;
    @ColumnInfo(name = "enhancement_bonus_condition")
    private String enhancementBonusCondition;
    @ColumnInfo(name = "conditional_attack_bonus")
    private int conditionalAttackBonus;
    @ColumnInfo(name = "attack_bonus_condition")
    private String attackBonusCondition;
    @ColumnInfo(name = "enchantment_charges")
    private int enchantmentCharges;
    @ColumnInfo(name = "featID_for_bonus_charges")
    private int featAbilityForBonusCharges;
    @ColumnInfo(name = "number_of_feat_ability_bonus_charges")
    private int numberOfFeatAbilityBonusCharges;
    @ColumnInfo(name = "class_abilityID_for_bonus_charges")
    private int classAbilityForBonusCharges;
    @ColumnInfo(name = "number_of_class_ability_bonus_charges")
    private int numberOfClassAbilityBonusCharges;
    @ColumnInfo(name = "required_weapon_name")
    private String requiredWeaponName;
    @ColumnInfo(name = "bonus_to_cmb")
    private int bonusToCMB;
    @ColumnInfo(name = "condition_for_cmb_bonus")
    private String conditionForCMBBonus;
    @ColumnInfo(name = "bonus_to_cmd")
    private int bonusToCMD;
    @ColumnInfo(name = "condition_for_cmd_bonus")
    private String conditionForCMDBonus;
    @ColumnInfo(name = "enchantment_conditions")
    private String enchantmentConditions;//This is for short descriptions that don't change numbers anywhere else, like "Ignores armor and shield bonuses", or "Affects incorporeal creatures"
    @ColumnInfo(name = "enchantment_full_text")
    private String enchantmentFullText;//This is useful for the full text of enchantments, but also for enchantments that aren't anything but text, like Called
    @ColumnInfo(name = "skillID_for_additional_check")
    private int additionalSkillCheck;
    @ColumnInfo(name = "allows_additional_cmb_check")
    private boolean allowsAdditionalCMBCheck;
    @ColumnInfo(name = "save_for_bonus")
    private String saveForBonus;
    @ColumnInfo(name = "condition_for_bonus_to_save")
    private String conditionForBonusToSave;
    @ColumnInfo(name = "changes_size")
    private boolean changesSize;
    @ColumnInfo(name = "skillID_for_bonus")
    private int skillForBonus;
    @ColumnInfo(name = "condition_for_bonus_to_skill")
    private String conditionForBonusToSkill;
    @ColumnInfo(name = "changes_damage_dice_size")
    private boolean changesDamageDiceSize;
    @ColumnInfo(name = "changes_critical_range")
    private boolean changesCriticalRange;//The only enchantment that does this, Keen, only ever doubles the critical range, so we don't need to worry about tracking the size of the change
    @ColumnInfo(name = "abilityID_for_increased_dc")
    private int abilityForIncreasedDC;
    @ColumnInfo(name = "range_multiplier")
    private int rangeMultiplier;
    @ColumnInfo(name = "range_modifier")
    private int rangeModifier;//This is for when a flat number of feet is added to a weapons range (like with Thrown)
    @ColumnInfo(name = "misfire_decrease")
    private int misfireDecrease;
    @ColumnInfo(name = "weapon_enchantmentID_being_restricted")
    private int weaponEnchantmentIDBeingRestricted;
    @ColumnInfo(name = "added_featID")
    private int addedFeat;
    @ColumnInfo(name = "added_senseID")
    private int addedSense;
    @ColumnInfo(name = "damages_wielder")
    private boolean damagesWielder;
    @ColumnInfo(name = "required_weight_class")
    private WeaponWeightClassEnum requiredWeightClass;
    @ColumnInfo(name = "restricted_weight_class")
    private List<WeaponWeightClassEnum> restrictedWeightClasses;

    //region Getters and Setters
    public int getWeaponEnchantmentID()
    {
        return weaponEnchantmentID;
    }

    public void setWeaponEnchantmentID(int weaponEnchantmentID)
    {
        this.weaponEnchantmentID = weaponEnchantmentID;
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

    public int getCheckedSkillID()
    {
        return checkedSkillID;
    }

    public void setCheckedSkillID(int checkedSkillID)
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

    public int getFeatAbilityForBonusCharges()
    {
        return featAbilityForBonusCharges;
    }

    public void setFeatAbilityForBonusCharges(int featAbilityForBonusCharges)
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

    public int getClassAbilityForBonusCharges()
    {
        return classAbilityForBonusCharges;
    }

    public void setClassAbilityForBonusCharges(int classAbilityForBonusCharges)
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

    public int getAdditionalSkillCheck()
    {
        return additionalSkillCheck;
    }

    public void setAdditionalSkillCheck(int additionalSkillCheck)
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

    public int getSkillForBonus()
    {
        return skillForBonus;
    }

    public void setSkillForBonus(int skillForBonus)
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

    public int getAbilityForIncreasedDC()
    {
        return abilityForIncreasedDC;
    }

    public void setAbilityForIncreasedDC(int abilityForIncreasedDC)
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

    public int getWeaponEnchantmentIDBeingRestricted()
    {
        return weaponEnchantmentIDBeingRestricted;
    }

    public void setWeaponEnchantmentIDBeingRestricted(int weaponEnchantmentIDBeingRestricted)
    {
        this.weaponEnchantmentIDBeingRestricted = weaponEnchantmentIDBeingRestricted;
    }

    public int getAddedFeat()
    {
        return addedFeat;
    }

    public void setAddedFeat(int addedFeat)
    {
        this.addedFeat = addedFeat;
    }

    public int getAddedSense()
    {
        return addedSense;
    }

    public void setAddedSense(int addedSense)
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


    public WeaponEnchantmentEntity()
    {
        //Default Constructor
    }

    public WeaponEnchantmentEntity(IWeaponEnchantment enchantmentToConvert)
    {
        setGoldCost(enchantmentToConvert.getGoldCost());
        setEnhancementBonusPointCost(enchantmentToConvert.getEnhancementBonusPointCost());
        setName(enchantmentToConvert.getName());
        setCheckedAbilityScore(enchantmentToConvert.getCheckedAbilityScore());
        setCheckedSkillID(0);//Todo: Properly implement once we implement a skill table
        setRequiredAlignment(enchantmentToConvert.getRequiredAlignment());
        setRequiredDamageType(enchantmentToConvert.getRequiredDamageType());
        setRequiredTags(enchantmentToConvert.getRequiredTags());
        setAddedDamage(enchantmentToConvert.getDamageDice());
        setAddedDamageType(enchantmentToConvert.getAddedDamageType());//Fire, Ice, Necrotic, etc.
        setDamageDiceCondition(enchantmentToConvert.getDamageCondition());//"vs Evil", "vs Fire Subtype" etc
        setConditionalEnhancementBonus(enchantmentToConvert.getConditionalEnhancementBonus());
        setEnchantmentConditions(enchantmentToConvert.getEnchantmentConditionsText());
        setConditionalAttackBonus(enchantmentToConvert.getConditionalAttackBonus());
        setAttackBonusCondition(enchantmentToConvert.getAttackBonusCondition());
        setEnchantmentCharges(enchantmentToConvert.getEnchantmentCharges());
        setFeatAbilityForBonusCharges(0);//Todo: Properly implement once we get feat abilities figured out
        setNumberOfFeatAbilityBonusCharges(enchantmentToConvert.getNumberOfFeatAbilityBonusCharges());
        setClassAbilityForBonusCharges(0);//Todo: Properly implement once we get class abilities figured out
        setNumberOfClassAbilityBonusCharges(enchantmentToConvert.getNumberOfClassAbilityBonusCharges());
        setRequiredWeaponName(enchantmentToConvert.getRequiredWeaponName());
        setBonusToCMB(enchantmentToConvert.getCMBBonus());
        setConditionForCMBBonus(enchantmentToConvert.getCMBBonusCondition());
        setBonusToCMD(enchantmentToConvert.getCMDBonus());
        setConditionForCMDBonus(enchantmentToConvert.getCMDBonusCondition());
        setEnchantmentConditions(enchantmentToConvert.getEnchantmentConditionsText());//This is for short descriptions that don't change numbers anywhere else, like "Ignores armor and shield bonuses", or "Affects incorporeal creatures"
        setEnchantmentFullText(enchantmentToConvert.getEnchantmentText());//This is useful for the full text of enchantments, but also for enchantments that aren't anything but text, like Called
        setAdditionalSkillCheck(0);//Todo: Properly implement once we have skills figured out
        setAllowsAdditionalCMBCheck(enchantmentToConvert.allowsAdditionalCMBCheck());
        setSaveForBonus(enchantmentToConvert.getSaveForBonus());
        setConditionForBonusToSave(enchantmentToConvert.getConditionForBonusToSave());
        setChangesSize(enchantmentToConvert.changesSize());
        setSkillForBonus(0);//Todo: Properly implement once we have skills figured out
        setConditionForBonusToSkill(enchantmentToConvert.getConditionForSkillBonus());
        setChangesDamageDiceSize(enchantmentToConvert.changesDamageDiceSize());
        setChangesCriticalRange(enchantmentToConvert.changesCriticalRange());//The only enchantment that does this, Keen, only ever doubles the critical range, so we don't need to worry about tracking the size of the change
        setAbilityForIncreasedDC(0);//Todo: Properly implement once we have abilities figured out
        setRangeModifier(enchantmentToConvert.getRangeModifier());//This is for when a flat number of feet is added to a weapons range (like with Thrown)
        setRangeMultiplier(enchantmentToConvert.getRangeMultiplier());
        setMisfireDecrease(enchantmentToConvert.getMisfireDecrease());
        setWeaponEnchantmentIDBeingRestricted(0);//Todo:Our M-M relations need to be fixed before we can implement this
        setAddedFeat(0);//Todo: See above
        setAddedSense(0);//Todo: yup
        setDamagesWielder(enchantmentToConvert.doesDamageToWielder());
        setRequiredWeightClass(enchantmentToConvert.getRequiredWeightClass());
        setRestrictedWeightClasses(enchantmentToConvert.getRestrictedWeightClasses());

    }
}
