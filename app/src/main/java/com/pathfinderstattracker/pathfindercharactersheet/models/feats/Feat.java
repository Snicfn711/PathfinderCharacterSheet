package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Feat implements IFeat
{
    private List<IPrerequisite> Prerequisites;
    private String EffectText;
    private List<IAbility> Abilities;
    private List<IBonus> Bonuses;
    private List<IPenalty> Penalties;

    //region Getters and Setters
    public List<IPrerequisite> getPrerequisites()
    {
        return Prerequisites;
    }

    public void setPrerequisites(List<IPrerequisite> prerequisites)
    {
        Prerequisites = prerequisites;
    }

    public String getEffectText()
    {
        return EffectText;
    }

    public void setEffectText(String effectText)
    {
        EffectText = effectText;
    }

    public List<IAbility> getAbilities()
    {
        return Abilities;
    }

    public void setAbilities(List<IAbility> abilities)
    {
        Abilities = abilities;
    }

    public List<IBonus> getBonuses()
    {
        return Bonuses;
    }

    public void setBonuses(List<IBonus> bonuses)
    {
        Bonuses = bonuses;
    }

    public List<IPenalty> getPenalties()
    {
        return Penalties;
    }

    public void setPenalties(List<IPenalty> penalties)
    {
        Penalties = penalties;
    }
    //endregion

    public Feat()
    {
        //Default Constructor
    }

    public Feat(List<IPrerequisite> prerequisites, String effectText, List<IAbility> abilities, List<IBonus> bonuses, List<IPenalty> penalties)
    {
        setPrerequisites(prerequisites);
        setEffectText(effectText);
        setAbilities(abilities);
        setBonuses(bonuses);
        setPenalties(penalties);
    }
}
