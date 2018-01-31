package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class Feat implements IFeat
{
    public IPrerequisite[] Prerequisites;
    public String EffectText;
    public IAbility[] Abilities;
    public IBonus[] Bonuses;
    public IPenalty[] Penalties;
}
