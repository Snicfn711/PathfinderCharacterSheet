package com.pathfinderstattracker.pathfindercharactersheet.models.items;

import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;

import java.util.List;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IWeapon extends IEquipment
{
    WeaponFamilyEnum getFamily();
    void setFamily(WeaponFamilyEnum family);
    int getRange();
    void setRange(int range);
    List<WeaponTagEnum> getWeaponTags();
    void setWeaponTags(List<WeaponTagEnum> weaponTags);
    WeaponWeightClassEnum getWeightClass();
    void setWeightClass(WeaponWeightClassEnum weightClass);
    double getCost();
    void setCost(double cost);
    List<Damage> getDamage();
    void setDamage(List<Damage> damage);
    int getCriticalMultiplier();
    void setCriticalMultiplier(int criticalMultiplier);
    int getCriticalRange();
    void setCriticalRange(int criticalRange);
    List<WeaponDamageTypeEnum> getDamageType();
    void setDamageType(List<WeaponDamageTypeEnum> damageType);
    String getMaterial();
    void setMaterial(String material);
    boolean isMasterwork();
    void setMasterwork(boolean masterwork);
    int getRequiredStrength();
    void setRequiredStrength(int requiredStrength);
    List<IWeaponEnchantment> getEnchantments();
    int calculateCriticalRange();
    String returnCriticalString();
    String returnDamageTypes();
    String returnDamageDice();
}
