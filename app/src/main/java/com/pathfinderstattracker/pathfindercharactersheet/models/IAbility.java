package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/2/2018.
 */

public interface IAbility
{
    String Name = null;
    AbilityTypeEnum Type = AbilityTypeEnum.ExtraOrdinary;
    String EffectText = null;
    String SpellCopied = null; //This needs to be changed to a spell object once those are implemented
    IBonus[] Bonuses = null;
    IPenalty[] Penalties = null;
}
