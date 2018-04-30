package com.pathfinderstattracker.pathfindercharactersheet.models;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IAbilityScoreChange
{
    AbilityScoreEnum getStatChanged();
    void setStatChanged(AbilityScoreEnum statChanged);
    int getAmountChanged();
    void setAmountChanged(int amountChanged);
}
