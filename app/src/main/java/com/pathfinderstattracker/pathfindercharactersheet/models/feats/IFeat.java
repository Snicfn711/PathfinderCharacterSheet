package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IFeat
{
    IPrerequisite[] Prerequisites = null;
    String EffectText = null;
    IAbility[] Abilities = null;
    IBonus[] Bonuses = null;
    IPenalty[] Penalties = null;
}
