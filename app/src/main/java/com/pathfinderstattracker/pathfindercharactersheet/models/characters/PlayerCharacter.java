package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class PlayerCharacter implements IPlayerCharacter
{
    double ExperiencePoints;
    int CharacterLevel;
    int ConcentrationCheck;
    AlignmentEnum Alignment;
    int TotalBaseAttackBonus;
    IRace CharacterRace;
    IHitPoints TotalHitPoints;
    int TotalAC;
    IFeat[] Feats;
    IArmorItems[] EquippedArmor;
    IDamageReduction DR;
    String[] LanguagesKnown;
    IAbilityScore[] AbilityScores;
    ICombatManeuver CombatManeuverStats;
    int SpellResistance;
    int Initiative;
    int FortitudeSave;
    int ReflexSave;
    int WillSave;

    public double getExperiencePoints()
    {
        return ExperiencePoints;
    }

    public void setExperiencePoints(double experiencePoints)
    {
        ExperiencePoints = experiencePoints;
    }

    public int getCharacterLevel()
    {
        return CharacterLevel;
    }

    public void setCharacterLevel(int characterLevel)
    {
        CharacterLevel = characterLevel;
    }

    public int getConcentrationCheck()
    {
        return ConcentrationCheck;
    }

    public void setConcentrationCheck(int concentrationCheck)
    {
        ConcentrationCheck = concentrationCheck;
    }

    public AlignmentEnum getAlignment()
    {
        return Alignment;
    }

    public void setAlignment(AlignmentEnum alignment)
    {
        Alignment = alignment;
    }

    public int getTotalBaseAttackBonus()
    {
        return TotalBaseAttackBonus;
    }

    public void setTotalBaseAttackBonus(int totalBaseAttackBonus)
    {
        TotalBaseAttackBonus = totalBaseAttackBonus;
    }

    public IRace getCharacterRace()
    {
        return CharacterRace;
    }

    public void setCharacterRace(IRace characterRace)
    {
        CharacterRace = characterRace;
    }

    public IHitPoints getTotalHitPoints()
    {
        return TotalHitPoints;
    }

    public void setTotalHitPoints(IHitPoints totalHitPoints)
    {
        TotalHitPoints = totalHitPoints;
    }

    public int getTotalAC()
    {
        return TotalAC;
    }

    public void setTotalAC(int totalAC)
    {
        TotalAC = totalAC;
    }

    public IFeat[] getFeats()
    {
        return Feats;
    }

    public void setFeats(IFeat[] feats)
    {
        Feats = feats;
    }

    public IArmorItems[] getEquippedArmor()
    {
        return EquippedArmor;
    }

    public void setEquippedArmor(IArmorItems[] equippedArmor)
    {
        EquippedArmor = equippedArmor;
    }

    public IDamageReduction getDR()
    {
        return DR;
    }

    public void setDR(IDamageReduction DR)
    {
        this.DR = DR;
    }

    public String[] getLanguagesKnown()
    {
        return LanguagesKnown;
    }

    public void setLanguagesKnown(String[] languagesKnown)
    {
        LanguagesKnown = languagesKnown;
    }

    public IAbilityScore[] getAbilityScores()
    {
        return AbilityScores;
    }

    public void setAbilityScores(IAbilityScore[] abilityScores)
    {
        AbilityScores = abilityScores;
    }

    public ICombatManeuver getCombatManeuverStats()
    {
        return CombatManeuverStats;
    }

    public void setCombatManeuverStats(ICombatManeuver combatManeuverStats)
    {
        CombatManeuverStats = combatManeuverStats;
    }

    public int getSpellResistance()
    {
        return SpellResistance;
    }

    public void setSpellResistance(int spellResistance)
    {
        SpellResistance = spellResistance;
    }

    public int getInitiative()
    {
        return Initiative;
    }

    public void setInitiative(int initiative)
    {
        Initiative = initiative;
    }

    public int getFortitudeSave()
    {
        return FortitudeSave;
    }

    public void setFortitudeSave(int fortitudeSave)
    {
        FortitudeSave = fortitudeSave;
    }

    public int getReflexSave()
    {
        return ReflexSave;
    }

    public void setReflexSave(int reflexSave)
    {
        ReflexSave = reflexSave;
    }

    public int getWillSave()
    {
        return WillSave;
    }

    public void setWillSave(int willSave)
    {
        WillSave = willSave;
    }



    public PlayerCharacter()
    {
        //Default Constructor
    }

}
