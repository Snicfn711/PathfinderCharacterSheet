package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class MartialCharacterClass implements IMartialCharacterClass
{
    public int ClassLevel = 0;
    public String ClassName = null;
    public int BaseAttackBonus = 0;
    public int HitDiceSize = 0;
    public ISkill[] Skills = null;
    public IArmor[] ArmorProficiency = null;
    public IShield[] ShieldProficiency = null;
    public IWeapon[] WeaponProficiency = null;
    public boolean IsFortitudeSaveGood = false;
    public boolean IsWillSaveGood = false;
    public boolean IsReflexSaveGood = false;
    public IClassAbility[] Abilities = null;
}
