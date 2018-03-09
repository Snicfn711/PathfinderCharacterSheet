package com.pathfinderstattracker.pathfindercharactersheet.models;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

/**
 * Created by Stephen Hagen on 1/2/2018.
 */

public interface IAbility
{
    String getName();
    void setName(String name);
    AbilityTypeEnum getAbilityType();
    void setAbilityType(AbilityTypeEnum abilityType);
    String getEffectText();
    void setEffectText(String effectText);
    ISpell getSpellCopied();
    void setSpellCopied(ISpell spellCopied);
    IBonus[] getBonuses();
    void setBonuses(IBonus[] bonuses);
    IPenalty[] getPenalties();
    void setPenalties(IPenalty[] penalties);
}
