package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */

public abstract class CharacterClass
{
    private int ClassLevel;
    private String ClassName;
    private int BaseAttackBonus;
    private int HitDiceSize;
    private List<ISkill> Skills;
    private List<IArmor> ArmorProficiency;
    private List<IShield> ShieldProficiency;
    private List<IWeapon> WeaponProficiency;
    private boolean IsFortitudeSaveGood;
    private boolean IsWillSaveGood;
    private boolean IsReflexSaveGood;
    private List<IClassAbility> Abilities;
    private ClassResource ClassResource;

    //region Getters and Setters
    public int getClassLevel()
    {
        return ClassLevel;
    }

    public void setClassLevel(int classLevel)
    {
        ClassLevel = classLevel;
    }

    public String getClassName()
    {
        return ClassName;
    }

    public void setClassName(String className)
    {
        ClassName = className;
    }

    public int getBaseAttackBonus()
    {
        return BaseAttackBonus;
    }

    public void setBaseAttackBonus(int baseAttackBonus)
    {
        BaseAttackBonus = baseAttackBonus;
    }

    public int getHitDiceSize()
    {
        return HitDiceSize;
    }

    public void setHitDiceSize(int hitDiceSize)
    {
        HitDiceSize = hitDiceSize;
    }

    public List<ISkill> getSkills()
    {
        return Skills;
    }

    public void setSkills(List<ISkill> skills)
    {
        Skills = skills;
    }

    public List<IArmor> getArmorProficiency()
    {
        return ArmorProficiency;
    }

    public void setArmorProficiency(List<IArmor> armorProficiency)
    {
        ArmorProficiency = armorProficiency;
    }

    public List<IShield> getShieldProficiency()
    {
        return ShieldProficiency;
    }

    public void setShieldProficiency(List<IShield> shieldProficiency)
    {
        ShieldProficiency = shieldProficiency;
    }

    public List<IWeapon> getWeaponProficiency()
    {
        return WeaponProficiency;
    }

    public void setWeaponProficiency(List<IWeapon> weaponProficiency)
    {
        WeaponProficiency = weaponProficiency;
    }

    public boolean isFortitudeSaveGood()
    {
        return IsFortitudeSaveGood;
    }

    public void setFortitudeSaveGood(boolean fortitudeSaveGood)
    {
        IsFortitudeSaveGood = fortitudeSaveGood;
    }

    public boolean isWillSaveGood()
    {
        return IsWillSaveGood;
    }

    public void setWillSaveGood(boolean willSaveGood)
    {
        IsWillSaveGood = willSaveGood;
    }

    public boolean isReflexSaveGood()
    {
        return IsReflexSaveGood;
    }

    public void setReflexSaveGood(boolean reflexSaveGood)
    {
        IsReflexSaveGood = reflexSaveGood;
    }

    public List<IClassAbility> getAbilities()
    {
        return Abilities;
    }

    public void setAbilities(List<IClassAbility> abilities)
    {
        Abilities = abilities;
    }

    public ClassResource getClassResource()
    {
        return ClassResource;
    }

    public void setClassResource(ClassResource classResource)
    {
        ClassResource = classResource;
    }
    //endregion
}
