package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWondrousItems;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class PlayerCharacter implements IPlayerCharacter
{
    private UUID playerCharacterID;
    private String characterName;
    private double ExperiencePoints;
    private int CharacterLevel;
    private int ConcentrationCheck;
    private AlignmentEnum Alignment;
    private int TotalBaseAttackBonus;
    private IRace CharacterRace;
    private IHitPoints TotalHitPoints;
    private int TotalAC;
    private List<IFeat> Feats;
    private List<IEquipment> Equipment;
    private IDamageReduction DR;
    private List<String> LanguagesKnown;
    private List<IAbilityScore> AbilityScores;
    private ICombatManeuver CombatManeuverStats;
    private int SpellResistance;
    private int Initiative;
    private int FortitudeSave;
    private int ReflexSave;
    private int WillSave;
    private List<IItem> Inventory;

    @Override
    public void setPlayerCharacterID(UUID playerCharacterID)
    {
        this.playerCharacterID = playerCharacterID;
    }

    @Override
    public UUID getPlayerCharacterID()
    {
        return playerCharacterID;
    }

    @Override
    public void setPlayerCharacterName(String name)
    {
        this.characterName = name;
    }

    @Override
    public String getPlayerCharacterName() {
        return characterName;
    }

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

    public List<IFeat> getFeats()
    {
        return Feats;
    }

    public void setFeats(List<IFeat> feats)
    {
        Feats = feats;
    }

    public List<IEquipment> getEquipment()
    {
        return Equipment;
    }

    public void setEquipment(List<IEquipment> equippedArmor)
    {
        Equipment = equippedArmor;
    }

    public IDamageReduction getDR()
    {
        return DR;
    }

    public void setDR(IDamageReduction DR)
    {
        this.DR = DR;
    }

    public List<String> getLanguagesKnown()
    {
        return LanguagesKnown;
    }

    public void setLanguagesKnown(List<String> languagesKnown)
    {
        LanguagesKnown = languagesKnown;
    }

    public List<IAbilityScore> getAbilityScores()
    {
        return AbilityScores;
    }

    public void setAbilityScores(List<IAbilityScore> abilityScores)
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
    public List<IItem> getInventory(){return Inventory;}
    public void setInventory(List<IItem> inventory){Inventory = inventory;}



    public PlayerCharacter()
    {
        //Default Constructor
    }

    public int CalculateTouchAC()
    {
        int armorBonus = 0;
        int naturalArmorBonus = 0;
        int shieldBonus = 0;
        for(IEquipment x:Equipment)
        {
            if(x instanceof IProtection)
            {
                switch (((IProtection) x).getArmorType())
                {
                    //None of these armor types stack, so we'll have to check that we're removing only the largest value
                    //This of course assumes only the largest value armor is equipped, which we'll have to enforce
                    case Armor:
                        int tempArmorBonus = ((IProtection) x).getACBonus();
                        if(armorBonus == 0 || armorBonus < tempArmorBonus)
                        {
                            armorBonus = tempArmorBonus;
                        }
                        break;
                    case NaturalArmor:
                        int tempNaturalArmorBonus = ((IProtection) x).getACBonus();
                        if(naturalArmorBonus == 0 || naturalArmorBonus < tempNaturalArmorBonus)
                        {
                            naturalArmorBonus = tempNaturalArmorBonus;
                        }
                        break;
                    case Shield:
                        int tempShieldBonus = ((IProtection) x).getACBonus();
                        if(shieldBonus == 0 || shieldBonus < tempShieldBonus)
                        {
                            shieldBonus = tempShieldBonus;
                        }
                        break;
                }
                //Since we don't care about the other armor types, we'll leave out a default case
            }
            else if(x instanceof IWondrousItems)
            {
                switch (((IWondrousItems) x).getArmorType())
                {
                    case Armor:
                        armorBonus = ((IWondrousItems) x).getACBonus();
                        break;
                    case NaturalArmor:
                        naturalArmorBonus = ((IWondrousItems) x).getACBonus();
                        break;
                    case Shield:
                        shieldBonus = ((IWondrousItems) x).getACBonus();
                        break;
                }
                //Since we don't care about the other armor types, we'll leave out a default case
            }
        }
        return TotalAC - armorBonus - naturalArmorBonus - shieldBonus;
    }

    public int CalculateFlatFootedAC()
    {
        int dodgeBonus = 0;
        int dexterityBonus = 0;
        for(IEquipment x:Equipment)
        {
            if(x instanceof IProtection)
            {
                switch (((IProtection) x).getArmorType())
                {
                    case Dodge:
                        //Dodge bonuses to AC stack, so we'll have to count the total dodge bonus present
                        dodgeBonus += ((IProtection) x).getACBonus();
                        break;
                }
            }
            else if(x instanceof IWondrousItems)
            {
                switch (((IWondrousItems) x).getArmorType())
                {
                    case Dodge:
                        dodgeBonus += ((IWondrousItems) x).getACBonus();
                        break;
                }
            }
            //Since we don't care about the other armor types, we'll leave out a default case
        }
        for(IAbilityScore x:AbilityScores)
        {
            switch (x.getStat())
            {
                case DEX:
                    dexterityBonus = x.calculateModifier();
                    break;
            }
            //Again, we don't care about other stats
        }
        return TotalAC - dodgeBonus - dexterityBonus;
    }
}
