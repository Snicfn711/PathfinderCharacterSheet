package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ISpontaneousCasterCharacterClass extends ICasterCharacterClass
{
    ISpell[] SpellsKnown = null;
    ISpellSlot[] SpellSlots = null;
}
