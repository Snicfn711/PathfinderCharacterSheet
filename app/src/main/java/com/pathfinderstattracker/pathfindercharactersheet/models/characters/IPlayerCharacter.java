package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IPlayerCharacter
{
    double ExperiencePoints = 0;
    int CharacterLevel = 0;
    int ConcentrationCheck = 0;
    AlignmentEnum Alignment = AlignmentEnum.TrueNeutral;
    int TotalBaseAttackBonus = 0;
    IRace CharacterRace = null;
    IHitPoints TotalHitPoints = null;
    int TotalAC = 0;
    IFeat[] Feats = null;
    IArmorItems[] EquippedArmor = null;
    IDamageReduction DR = null;
    String[] LanguagesKnown = null;
    IAbilityScore[] AbilityScores = null;
    ICombatManeuver CombatManeuverStats = null;
    int SpellResistance = 0;
    int Initiative = 0;
    int FortitudeSave = 0;
    int ReflexSave = 0;
    int WillSave = 0;
}
