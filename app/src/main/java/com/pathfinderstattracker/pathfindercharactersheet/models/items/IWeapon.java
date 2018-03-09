package com.pathfinderstattracker.pathfindercharactersheet.models.items;

/**
 * Created by Stephen Hagen on 12/26/2017.
 */

public interface IWeapon extends IEquipment
{
    WeaponFamilyEnum getFamily();
    void setFamily(WeaponFamilyEnum family);
    int getRange();
    void setRange(int range);
    boolean hasReach();
    void setReach(boolean hasReach);
    boolean isThrown();
    void setThrown(boolean isThrown);
    boolean isDoubleheaded();
    void setDoubleheaded(boolean isDoubleheaded);
    boolean usesProjectile();
    void setProjectile(boolean usesProjectile);
    WeaponWeightClassEnum getWeightClass();
    void setWeightClass(WeaponWeightClassEnum weightClass);
    boolean isImprovised();
    void setImprovised(boolean isImprovised);
    double getCost();
    void setCost(double cost);
    Damage getDamage();
    void setDamage(Damage damage);
    int getCriticalMultiplier();
    void setCriticalMultiplier(int criticalMultiplier);
    int getCriticalRange();
    void setCriticalRange(int criticalRange);
    boolean canBrace();
    void setBrace(boolean brace);
    WeaponDamageTypeEnum[] getDamageType();
    void setDamageType(WeaponDamageTypeEnum[] damageType);
    boolean canDisarm();
    void setDisarm(boolean disarm);
    boolean isMonk();
    void setMonk(boolean monk);
    boolean canTrip();
    void setTrip(boolean trip);
    boolean isNonLethal();
    void setNonLethal(boolean nonLethal);
    String getMaterial();
    void setMaterial(String material);
    boolean isMasterwork();
    void setMasterwork(boolean masterwork);
    int getRequiredStrength();
    void setRequiredStrength(int requiredStrength);

}
