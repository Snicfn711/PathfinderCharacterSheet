package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IAbilityScore
{
    AbilityScoreEnum Stat = null;
    int Amount = 0;

    void setStat(AbilityScoreEnum stat);
    AbilityScoreEnum getStat();
    void setAmount(int amount);
    int getAmount();
    int calculateModifier();

}
