package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.ISense;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/10/2018.
 */

public interface IWeaponEnchantment
{
    AbilityScoreEnum getCheckedAbilityScore();
    void setCheckedAbilityScore(AbilityScoreEnum abilityScore);
    ISkill getCheckedSkill();
    void setCheckedSkill(ISkill checkedSkill);
    AlignmentEnum getRequiredAlignment();
    void setRequiredAlignment(AlignmentEnum requiredAlignment);
    WeaponDamageTypeEnum getRequiredDamageType();
    void setRequiredDamageType(WeaponDamageTypeEnum requiredDamageType);
    List<WeaponTagEnum> getRequiredTags();
    void setRequiredTags(List<WeaponTagEnum> weaponTags);
    Damage getDamageDice();
    void setDamageDice(Damage damageDice);
    String getDamageCondition();//Damage condition here refers to things like "vs evil", "vs creatures with the fire type", etc
    void setDamageCondition(String damageCondition);
    int getConditionalEnhancementBonus();
    void setConditionalEnhancementBonus(int conditionalEnhancementBonus);
    String getEnhancementBonusCondition();
    void setEnhancementBonusCondition(String enhancementCondition);
    int getConditionalAttackBonus();
    void setConditionalAttackBonus(int conditionalAttackBonus);
    String getAttackBonusCondition();
    void setAttackBonusCondition(String atackBonusCondition);
    int getEnchantmentCharges();
    void setEnchantmentCharges(Integer enchantmentCharges);
    IFeat getFeatAbilityForBonusCharges();
    void setFeatAbilityForBonusCharges(IFeat featForBonusCharges);
    int getNumberOfFeatAbilityBonusCharges();
    void setNumberOfFeatAbilityBonusCharges(Integer numberOfFeatAbilityBonusCharges);
    IAbility getClassAbilityForBonusCharges();
    void setClassAbilityForBonusCharges(IAbility abilityForBonusCharges);
    int getNumberOfClassAbilityBonusCharges();
    void setNumberOfClassAbilityBonusCharges(Integer numberOfFeatAbilityBonusCharges);
    String getRequiredWeaponName();
    void setRequiredWeaponName(String requiredWeaponName);
    int getCMDBonus();
    void setCMDBonus(int cmdBonus);
    String getCMDBonusCondition();
    void setCMDBonusCondition(String cmdBonusCondition);
    int getCMBBonus();
    void setCMBBonus(int cmbBonus);
    String getCMBBonusCondition();
    void setCMBBonusCondition(String cmbBonusCondition);
    String getEnchantmentConditionsText();
    void setEnchantmentConditionsText(String enchantmentConditionsText);//These are short descriptions that don't really change any numbers elsewhere in the program. Things like "Ignores armor and shield bonuses", or "Affects incorporeal creatures"
    String getEnchantmentText();
    void setEnchantmentText(String enchantmentText);//This is useful for an enchantments full text, as well as enchantments whose effect is largely or fully described in text without changing any numbers else where(i.e. Called or Glammered)
    ISkill getAdditionalSkillCheck();
    void setAdditionalSkillCheck(ISkill additionalSkillCheck);
    boolean allowsAdditionalCMBCheck();
    void setAllowsAdditionalCMBCheck(boolean allowsAdditionalCMBCheck);
    String getSaveForBonus();
    void setSaveForBonus(String saveForBonus);
    String getConditionForBonusToSave();
    void setConditionForBonusToSave(String conditionForBonusToSave);
    boolean changesSize();
    void setChangesSize(boolean changesSize);
    ISkill getSkillForBonus();
    void setSkillForBonus(ISkill skillForBonus);
    String getConditionForSkillBonus();
    void setConditionForSkillbonus(String conditionForSkillbonus);
    boolean changesDamageDiceSize();
    void setChangesDamageDiceSize(boolean changesDamageDiceSize);
    boolean changesCriticalRange();
    void setChangesCriticalRange(boolean changesCriticalRange);
    IAbility getAbilityForIncreasedDC();
    void setAbilityForIncreasedDC(IAbility abilityForIncreasedDC);//None of the enchantments that increase an ability's DC give anything other than +2, so we don't need to track that value
    int getRangeMultiplier();
    void setRangeMultiplier(int rangeMultiplier);
    int getRangeModifier();
    void setRangeModifier(int rangeModifier);//This should cover the use case for enchantments like thrown, where a range is being given to a melee weapon
    int getMisfireDecrease();
    void setMisfireDecrease(int misfireDecrease);
    List<IWeaponEnchantment> getRestrictedWeaponEnchantments();
    void setRestrictedWeaponEnchantments(List<IWeaponEnchantment> restrictedWeaponEnchantments);
    IFeat getAddedFeat();
    void setAddedFeat(IFeat addedFeat);
    ISense getAddedSenses();
    void setAddedSenses(ISense addedSenses);
    boolean doesDamageToWielder();
    void setDoesDamageToWielder(boolean doesDamageToWielder);
}
