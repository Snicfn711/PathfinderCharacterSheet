package com.pathfinderstattracker.pathfindercharactersheet.models;

import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/2/2018.
 */

public class Ability implements IAbility
{
    private String name;
    private AbilityTypeEnum abilityType;
    private String effectText;
    private String shortDescription;
    private ISpell spellCopied;
    private List<IBonus> bonuses;
    private List<IPenalty> penalties;

    //region Getters and Setters
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public AbilityTypeEnum getAbilityType()
    {
        return abilityType;
    }

    @Override
    public void setAbilityType(AbilityTypeEnum abilityType)
    {
        this.abilityType = abilityType;
    }

    @Override
    public String getEffectText()
    {
        return effectText;
    }

    @Override
    public void setEffectText(String effectText)
    {
        this.effectText = effectText;
    }

    @Override
    public ISpell getSpellCopied()
    {
        return spellCopied;
    }

    @Override
    public void setSpellCopied(ISpell spellCopied)
    {
        this.spellCopied = spellCopied;
    }

    @Override
    public List<IBonus> getBonuses()
    {
        return bonuses;
    }

    @Override
    public void setBonuses(List<IBonus> bonuses)
    {
        this.bonuses = bonuses;
    }

    @Override
    public List<IPenalty> getPenalties()
    {
        return penalties;
    }

    @Override
    public void setPenalties(List<IPenalty> penalties)
    {
        this.penalties = penalties;
    }

    @Override
    public String getShortDescription(){return shortDescription;}
    @Override
    public void setShortDescription(String shortDescription){this.shortDescription = shortDescription;}
    //endregion


    public Ability()
    {
        //Default Constructor
    }

    public Ability(String name, AbilityTypeEnum abilityType, String effectText, ISpell spellCopied, List<IBonus> bonuses, List<IPenalty> penalties, String shortDescription)
    {
        setName(name);
        setAbilityType(abilityType);
        setEffectText(effectText);
        setSpellCopied(spellCopied);
        setBonuses(bonuses);
        setPenalties(penalties);
        setShortDescription(shortDescription);
    }
}
