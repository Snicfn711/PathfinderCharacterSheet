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
    private double ExperiencePoints;
    private int CharacterLevel;
    private int ConcentrationCheck;
    private AlignmentEnum Alignment;
    private int TotalBaseAttackBonus;
    private IRace CharacterRace;
    private IHitPoints TotalHitPoints;
    private int TotalAC;
    private IFeat[] Feats;
    private IArmorItem[] EquippedArmor;
    private IDamageReduction DR;
    private String[] LanguagesKnown;
    private IAbilityScore[] AbilityScores;
    private ICombatManeuver CombatManeuverStats;
    private int SpellResistance;
    private int Initiative;
    private int FortitudeSave;
    private int ReflexSave;
    private int WillSave;

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

    @Override
    public void setHitPoints(IHitPoints hitPoints)
    {
        TotalHitPoints = hitPoints;
    }

    @Override
    public IHitPoints getHitPoints()
    {
        return TotalHitPoints;
    }

    public void setCharacterRace(IRace characterRace)
    {
        CharacterRace = characterRace;
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

    public IArmorItem[] getEquippedArmor()
    {
        return EquippedArmor;
    }

    public void setEquippedArmor(IArmorItem[] equippedArmor)
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

    private int CalculateModifier(IAbilityScore stat)
    {
        return (stat.getAmount() - 10)/2;
    }

    public int CalculateTouchAC()
    {
        int armorBonus = 0;
        int naturalArmorBonus = 0;
        int shieldBonus = 0;
        for(IArmorItem x:EquippedArmor)
        {
            switch(x.getArmorType())
            {
                case Armor:
                    armorBonus = x.getValue();
                    break;
                case NaturalArmor:
                    naturalArmorBonus = x.getValue();
                    break;
                case Shield:
                    shieldBonus = x.getValue();
                    break;
            }
            //Since we don't care about the other armor types, we'll leave out a default case
        }
        return TotalAC - armorBonus - naturalArmorBonus - shieldBonus;
    }

    public int CalculateFlatFootedAC()
    {
        int dodgeBonus = 0;
        int dexterityBonus = 0;
        for(IArmorItem x:EquippedArmor)
        {
            switch(x.getArmorType())
            {
                case Dodge:
                    dodgeBonus = x.getValue();
                    break;
            }
            //Since we don't care about the other armor types, we'll leave out a default case
        }
        for(IAbilityScore x:AbilityScores)
        {
            switch (x.getStat())
            {
                case DEX:
                    dexterityBonus = CalculateModifier(x);
                    break;
            }
            //Again, we don't care about other stats
        }
        return TotalAC - dodgeBonus - dexterityBonus;
    }
}
