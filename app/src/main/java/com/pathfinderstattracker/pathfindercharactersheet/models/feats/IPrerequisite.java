package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IPrerequisite
{
    int CharacterLevel = 0;
    IClassPrerequisite ClassPrerequisite = null;
    int CasterLevel = 0;
    IAbilityScore[] AbilityScorePrerequisite = null;
    IAbility[] AbilityPrerequisite = null;
    IFeat[] FeatPrerequisite = null;
    IRace RacePrerequisite = null;
}
