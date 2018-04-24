package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ICharacterClass
{
    int ClassLevel = 0;
    String ClassName = null;
    int BaseAttackBonus = 0;
    int HitDiceSize = 0;
    ISkill[] Skills = null;
    IArmor[] ArmorProficiency = null;
    IShield[] ShieldProficiency = null;
    IWeapon[] WeaponProficiency = null;
    boolean IsFortitudeSaveGood = false;
    boolean IsWillSaveGood = false;
    boolean IsReflexSaveGood = false;
    IClassAbility[] Abilities = null;
}
