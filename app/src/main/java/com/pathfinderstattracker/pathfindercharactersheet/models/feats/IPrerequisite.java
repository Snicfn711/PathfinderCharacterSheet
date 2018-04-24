package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IPrerequisite
{
    int getCharacterLevel();
    void setCharacterLevel(int characterLevel);
    List<IClassPrerequisite> getClassPrerequisite();
    void setClassPrerequisite(List<IClassPrerequisite> classPrerequisite);
    int getCasterLevel();
    void setCasterLevel(int casterLevel);
    IAbilityScore getAbilityScorePrerequisite();
    void setAbilityScorePrerequisite(IAbilityScore abilityScorePrerequisite);
    List<IAbility> getAbilityPrerequisite();
    void setAbilityPrerequisite(List<IAbility> abilityPrerequisite);
    List<IFeat> getFeatPrerequisite();
    void setFeatPrerequisite(List<IFeat> featPrerequisite);
    IRace getRacePrerequisite();
    void setRacePrerequisite(IRace racePrerequisite);
}
