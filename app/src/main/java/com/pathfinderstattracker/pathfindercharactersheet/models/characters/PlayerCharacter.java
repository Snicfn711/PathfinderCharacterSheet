package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWondrousItems;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public class PlayerCharacter implements IPlayerCharacter, Serializable
{
    private UUID playerCharacterID;
    private String characterName;
    private double ExperiencePoints;
    private int CharacterLevel;
    private int ConcentrationCheck;
    private AlignmentEnum characterAlignment;
    private int TotalBaseAttackBonus;
    private IRace CharacterRace;
    private IHitPoints TotalHitPoints;
    private int TotalAC;
    private int FlatFootedAC;
    private int TouchAC;
    private List<IFeat> Feats;
    private List<IEquipment> Equipment;
    private IDamageReduction damageReduction;
    private List<String> LanguagesKnown;
    private List<IAbilityScore> AbilityScores;
    private ICombatManeuver CombatManeuverStats;
    private int SpellResistance;
    private int Initiative;
    private int FortitudeSave;
    private int ReflexSave;
    private int WillSave;
    private List<IItem> Inventory;

    //region Getters and Setters
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

    public AlignmentEnum getCharacterAlignment()
    {
        return characterAlignment;
    }

    public void setCharacterAlignment(AlignmentEnum characterAlignment)
    {
        this.characterAlignment = characterAlignment;
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
    public void setTotalHitPoints(IHitPoints hitPoints)
    {
        TotalHitPoints = hitPoints;
    }

    @Override
    public IHitPoints getTotalHitPoints()
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
    public int getFlatFootedAC(){return FlatFootedAC;}
    public void setFlatFootedAC(int flatFootedAC)
    {
        FlatFootedAC = flatFootedAC;
    }
    public int getTouchAC(){return TouchAC;}
    public void setTouchAC(int touchAC){TouchAC = touchAC;}

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

    public IDamageReduction getDamageReduction()
    {
        return damageReduction;
    }

    public void setDamageReduction(IDamageReduction damageReduction)
    {
        this.damageReduction = damageReduction;
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
        //Since it calls all of the  calculates, setAbilityScores needs to be called last when creating a new player character
        AbilityScores = abilityScores;
        CalculateFortitudeSave();
        CalculateReflexSave();
        CalculateWillSave();
        CalculateInitiative();
        CalculateFlatFootedAC();
        CalculateTouchAC();
        CalculateTotalAC();
        CalculateHitPoints();
        CalculateCombatManeuvers();
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


    //endregion

    public PlayerCharacter()
    {
        //Default Constructor
    }

    public static IPlayerCharacter CreateDefaultPlayerCharacterWithID(UUID newPlayerCharacterID)
    {
        IPlayerCharacter CreatedPlayerCharacter = new PlayerCharacter();
        CreatedPlayerCharacter.setPlayerCharacterID(newPlayerCharacterID);
        CreatedPlayerCharacter.setPlayerCharacterName("");
        CreatedPlayerCharacter.setCharacterLevel(1);
        CreatedPlayerCharacter.setConcentrationCheck(0);
        CreatedPlayerCharacter.setCharacterAlignment(AlignmentEnum.TrueNeutral);
        CreatedPlayerCharacter.setTotalBaseAttackBonus(0);
        CreatedPlayerCharacter.setTotalHitPoints(new HitPoints(0,0));
        CreatedPlayerCharacter.setTotalAC(10);
        CreatedPlayerCharacter.setDamageReduction(new DamageReduction(0,"",""));
        CreatedPlayerCharacter.setLanguagesKnown(new ArrayList<String>(Arrays.asList("Common")));
        CreatedPlayerCharacter.setCombatManeuverStats(new CombatManeuver(0,10));
        CreatedPlayerCharacter.setSpellResistance(0);
        CreatedPlayerCharacter.setFortitudeSave(0);
        CreatedPlayerCharacter.setReflexSave(0);
        CreatedPlayerCharacter.setWillSave(0);
        //If we don't create an empty equipment list for our default player character, CalculateTouchAC and CalculateFlatFootedAC will
        //return null references.
        CreatedPlayerCharacter.setEquipment(new ArrayList<IEquipment>());
        CreatedPlayerCharacter.setAbilityScores(new ArrayList<IAbilityScore>(Arrays.asList(new AbilityScore(AbilityScoreEnum.STR,10),
                                                                                           new AbilityScore(AbilityScoreEnum.DEX, 10),
                                                                                           new AbilityScore(AbilityScoreEnum.CON, 10),
                                                                                           new AbilityScore(AbilityScoreEnum.INT, 10),
                                                                                           new AbilityScore(AbilityScoreEnum.WIS, 10),
                                                                                           new AbilityScore(AbilityScoreEnum.CHA, 10))));
        return CreatedPlayerCharacter;
    }

    private void CalculateTotalAC()
    {
        int armorBonus = 0;
        int naturalArmorBonus = 0;
        int shieldBonus = 0;
        int dodgeBonus = 0;
        int dexterityBonus = 0;

        if(Equipment != null)
        {
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
                        case Dodge:
                            //Dodge bonuses to AC stack, so we'll have to count the total dodge bonus present
                            dodgeBonus += ((IProtection) x).getACBonus();
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
                        case Dodge:
                            dodgeBonus += ((IWondrousItems) x).getACBonus();
                            break;
                    }
                }
            }
        }
        for(IAbilityScore x:AbilityScores)
        {
            switch (x.getStat()) {
                case DEX:
                    dexterityBonus = x.calculateModifier();
                    break;
            }
        }
            //Again, we don't care about other stats
        TotalAC = 10 + armorBonus + naturalArmorBonus + shieldBonus + dodgeBonus + dexterityBonus;
    }

    private void CalculateTouchAC()
    {
        int armorBonus = 0;
        int naturalArmorBonus = 0;
        int shieldBonus = 0;
        if(Equipment != null)
        {
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
        }
        TouchAC = TotalAC - armorBonus - naturalArmorBonus - shieldBonus;
    }

    private void CalculateFlatFootedAC()
    {
        int dodgeBonus = 0;
        int dexterityBonus = 0;
        if(Equipment != null)
        {
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
        FlatFootedAC = TotalAC - dodgeBonus - dexterityBonus;
    }

    private void CalculateFortitudeSave()
    {
        int equipmentModifier = 0;
        int abilityScoreModifier = 0;
        int featModifer = 0;
        if(Equipment != null)
        {
            //TODO:Come back and actually check out what we get from equipment once we've fleshed it out
        }
        if(Feats != null)
        {
            //TODO:Come back and actually check out what we get from feats once we've fleshed it out
        }
        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for con to contribute to fort saves. There may be feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.CON)
                {
                    abilityScoreModifier += score.calculateModifier();
                }
            }
        }
        FortitudeSave = equipmentModifier + featModifer + abilityScoreModifier;
    }

    private void CalculateReflexSave()
    {
        int equipmentModifier = 0;
        int abilityScoreModifier = 0;
        int featModifer = 0;
        if(Equipment != null)
        {
            //TODO:Come back and actually check out what we get from equipment once we've fleshed it out
        }
        if(Feats != null)
        {
            //TODO:Come back and actually check out what we get from feats once we've fleshed it out
        }
        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for con to contribute to fort saves. There may be feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.DEX)
                {
                    abilityScoreModifier += score.calculateModifier();
                }
            }
        }
        ReflexSave = equipmentModifier + featModifer + abilityScoreModifier;
    }

    private void CalculateWillSave()
    {
        int equipmentModifier = 0;
        int abilityScoreModifier = 0;
        int featModifer = 0;
        if(Equipment != null)
        {
            //TODO:Come back and actually check out what we get from equipment once we've fleshed it out
        }
        if(Feats != null)
        {
            //TODO:Come back and actually check out what we get from feats once we've fleshed it out
        }
        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for con to contribute to fort saves. There may be feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.WIS)
                {
                    abilityScoreModifier += score.calculateModifier();
                }
            }
        }
        WillSave = equipmentModifier + featModifer + abilityScoreModifier;
    }

    private void CalculateInitiative()
    {
        int equipmentModifier = 0;
        int abilityScoreModifier = 0;
        int featModifer = 0;
        if(Equipment != null)
        {
            //TODO:Come back and actually check out what we get from equipment once we've fleshed it out
        }
        if(Feats != null)
        {
            //TODO:Come back and actually check out what we get from feats once we've fleshed it out
        }
        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for dex to contribute to initiative. There are feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.DEX)
                {
                    abilityScoreModifier += score.calculateModifier();
                }
            }
        }
        Initiative = equipmentModifier + featModifer + abilityScoreModifier;
    }

    private void CalculateHitPoints()
    {
        int abilityScoreModifier = 0;
        int currentHitPoints = TotalHitPoints.getValue();

        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for dex to contribute to initiative. There are feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.CON)
                {
                    abilityScoreModifier += score.calculateModifier();
                }
            }
        }

        TotalHitPoints.setValue(currentHitPoints += abilityScoreModifier);
    }

    private void CalculateCombatManeuvers()
    {
        int dexterityModifier = 0;
        int strengthModifier = 0;
        if(AbilityScores != null)
        {
            for(IAbilityScore score : AbilityScores)
            {
                //The default is for dex to contribute to initiative. There are feats/items that change that though
                //This works for now.
                if(score.getStat() == AbilityScoreEnum.DEX)
                {
                    dexterityModifier += score.calculateModifier();
                }
                if(score.getStat() == AbilityScoreEnum.STR)
                {
                    strengthModifier += score.calculateModifier();
                }
            }
        }
        CombatManeuverStats.setCombatManeuverDefense(10 + TotalBaseAttackBonus + strengthModifier + dexterityModifier);
        CombatManeuverStats.setCombatManeuverCheck(TotalBaseAttackBonus + strengthModifier);
    }
}
