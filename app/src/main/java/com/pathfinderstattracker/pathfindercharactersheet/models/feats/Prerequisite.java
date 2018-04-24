package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Prerequisite implements IPrerequisite
{
    private int CharacterLevel;
    private List<IClassPrerequisite> ClassPrerequisite;
    private int CasterLevel;
    private IAbilityScore AbilityScorePrerequisite;
    private List<IAbility> AbilityPrerequisite;
    private List<IFeat> FeatPrerequisite;
    private IRace RacePrerequisite;

    //region Getters and Setters
    public int getCharacterLevel()
    {
        return CharacterLevel;
    }

    public void setCharacterLevel(int characterLevel)
    {
        CharacterLevel = characterLevel;
    }

    public List<IClassPrerequisite> getClassPrerequisite()
    {
        return ClassPrerequisite;
    }

    public void setClassPrerequisite(List<IClassPrerequisite> classPrerequisite)
    {
        ClassPrerequisite = classPrerequisite;
    }

    public int getCasterLevel()
    {
        return CasterLevel;
    }

    public void setCasterLevel(int casterLevel)
    {
        CasterLevel = casterLevel;
    }

    public IAbilityScore getAbilityScorePrerequisite()
    {
        return AbilityScorePrerequisite;
    }

    public void setAbilityScorePrerequisite(IAbilityScore abilityScorePrerequisite)
    {
        AbilityScorePrerequisite = abilityScorePrerequisite;
    }

    public List<IAbility> getAbilityPrerequisite()
    {
        return AbilityPrerequisite;
    }

    public void setAbilityPrerequisite(List<IAbility> abilityPrerequisite)
    {
        AbilityPrerequisite = abilityPrerequisite;
    }

    public List<IFeat> getFeatPrerequisite()
    {
        return FeatPrerequisite;
    }

    public void setFeatPrerequisite(List<IFeat> featPrerequisite)
    {
        FeatPrerequisite = featPrerequisite;
    }

    public IRace getRacePrerequisite()
    {
        return RacePrerequisite;
    }

    public void setRacePrerequisite(IRace racePrerequisite)
    {
        RacePrerequisite = racePrerequisite;
    }
    //endregion


    public Prerequisite()
    {
        //Default Constructor
    }

    public Prerequisite(int characterLevel, List<IClassPrerequisite> classPrerequisite, int casterLevel, IAbilityScore abilityScorePrerequisite, List<IAbility> abilityPrerequisite, List<IFeat> featPrerequisite, IRace racePrerequisite)
    {
        setCharacterLevel(characterLevel);
        setClassPrerequisite(classPrerequisite);
        setCasterLevel(casterLevel);
        setAbilityScorePrerequisite(abilityScorePrerequisite);
        setAbilityPrerequisite(abilityPrerequisite);
        setFeatPrerequisite(featPrerequisite);
        setRacePrerequisite(racePrerequisite);
    }
}
