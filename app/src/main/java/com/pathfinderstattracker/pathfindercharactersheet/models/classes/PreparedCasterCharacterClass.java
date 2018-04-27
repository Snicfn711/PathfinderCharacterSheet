package com.pathfinderstattracker.pathfindercharactersheet.models.classes;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;

import java.util.List;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class PreparedCasterCharacterClass extends CharacterClass implements IPreparedCasterCharacterClass
{
    public AbilityScoreEnum CastingStat;
    public int CasterLevel;
    public int DifficultyClass;
}
