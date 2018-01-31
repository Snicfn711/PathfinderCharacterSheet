package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Prerequisite implements IPrerequisite
{
    public int CharacterLevel;
    public IClassPrerequisite[] ClassPrerequisite;
    public int CasterLevel;
    public IAbilityScore AbilityScorePrerequisite;
    public IAbility[] AbilityPrerequisite;
    public IFeat[] FeatPrerequisite;
    public IRace RacePrerequisite;
}
