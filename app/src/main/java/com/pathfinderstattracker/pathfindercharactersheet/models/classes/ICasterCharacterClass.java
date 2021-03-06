package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface ICasterCharacterClass extends ICharacterClass
{
    AbilityScoreEnum CastingStat = AbilityScoreEnum.INT;
    int CasterLevel = 0;
    int DifficultyClass = 0;
}
