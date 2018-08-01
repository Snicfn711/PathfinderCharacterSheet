package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ICharacterClass
{
    //region Getters and Setters
    int getClassLevel();
    void setClassLevel(int classLevel);
    String getClassName();
    void setClassName(String className);
    int getBaseAttackBonus();
    void setBaseAttackBonus(int baseAttackBonus);
    int getHitDiceSize();
    void setHitDiceSize(int hitDiceSize);
    List<ISkill> getSkills();
    void setSkills(List<ISkill> skills);
    List<IArmor> getArmorProficiency();
    void setArmorProficiency(List<IArmor> armorProficiency);
    List<IShield> getShieldProficiency();
    void setShieldProficiency(List<IShield> shieldProficiency);
    List<IWeapon> getWeaponProficiency();
    void setWeaponProficiency(List<IWeapon> weaponProficiency);
    boolean isFortitudeSaveGood();
    void setFortitudeSaveGood(boolean fortitudeSaveGood);
    boolean isWillSaveGood();
    void setWillSaveGood(boolean willSaveGood);
    boolean isReflexSaveGood();
    void setReflexSaveGood(boolean reflexSaveGood);
    List<IClassAbility> getAbilities();
    void setAbilities(List<IClassAbility> abilities);
    ClassResource getClassResource();
    void setClassResource(ClassResource classResource);
    //endregion

}
