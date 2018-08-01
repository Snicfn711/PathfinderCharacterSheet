package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class SpontaneousCasterCharacterClass extends CharacterClass implements ISpontaneousCasterCharacterClass
{
    public List<ISpell> SpellsKnown;
    public List<ISpellSlot> SpellSlots;
    public AbilityScoreEnum CastingStat;
    public int CasterLevel;
    public int DifficultyClass;
}
