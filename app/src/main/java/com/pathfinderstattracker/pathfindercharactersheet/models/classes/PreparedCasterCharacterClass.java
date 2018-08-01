package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class PreparedCasterCharacterClass extends CharacterClass implements IPreparedCasterCharacterClass
{
    public AbilityScoreEnum CastingStat;
    public int CasterLevel;
    public int DifficultyClass;
}
