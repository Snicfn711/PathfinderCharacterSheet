package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class SpontaneousCasterCharacterClass implements ISpontaneousCasterCharacterClass
{
    public ISpell[] SpellsKnown;
    public ISpellSlot[] SpellSlots;
    public AbilityScoreEnum CastingStat;
    public int CasterLevel;
    public int DifficultyClass;
    public int ClassLevel;
    public String ClassName;
    public int BaseAttackBonus;
    public int HitDiceSize;
    public ISkill[] Skills;
    public IArmor[] ArmorProficiency;
    public IShield[] ShieldProficiency;
    public IWeapon[] WeaponProficiency;
    public boolean IsFortitudeSaveGood;
    public boolean IsWillSaveGood;
    public boolean IsReflexSaveGood;
    public IClassAbility[] Abilities;
}
