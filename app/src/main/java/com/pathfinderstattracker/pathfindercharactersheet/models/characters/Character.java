package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class Character implements ICharacter
{
    public double ExperiencePoints;
    public int CharacterLevel;
    public int ConcentrationCheck;
    public AlignmentEnum Alignment;
    public int TotalBaseAttackBonus;
    public IRace CharacterRace;
    public IHitPoints TotalHitPoints;
    public int TotalAC;
    public IFeat[] Feats;
    public IArmorItems[] EquippedArmor;
    public IDamageReduction DR;
    public String[] LanguagesKnown;
    public IAbilityScore[] AbilityScores;
    public ICombatManeuver CombatManeuverStats;
    public int SpellResistance;
    public int Initiative;
    public int FortitudeSave;
    public int ReflexSave;
    public int WillSave;
}
