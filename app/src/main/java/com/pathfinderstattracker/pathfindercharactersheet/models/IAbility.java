package com.pathfinderstattracker.pathfindercharactersheet.models;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

import java.util.List;

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
    List<IBonus> getBonuses();
    void setBonuses(List<IBonus> bonuses);
    List<IPenalty> getPenalties();
    void setPenalties(List<IPenalty> penalties);
    String getShortDescription();
    void setShortDescription(String shortDescription);
}
