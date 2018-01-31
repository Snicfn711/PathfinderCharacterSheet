package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/2/2018.
 */

public class Ability implements IAbility
{
    public String Name;
    public AbilityTypeEnum Type;
    public String EffectText;
    public String SpellCopied; //This needs to be changed to a spell object once it exists
    public IBonus[] Bonuses;
    public IPenalty[] Penalties;
}
