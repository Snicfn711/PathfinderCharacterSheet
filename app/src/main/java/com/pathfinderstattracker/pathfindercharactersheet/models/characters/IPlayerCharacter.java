package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IPlayerCharacter
{
    void setPlayerCharacterID(UUID playerCharacterID);
    UUID getPlayerCharacterID();
    void setPlayerCharacterName(String name);
    String getPlayerCharacterName();
    void setExperiencePoints(double experiencePoints);
    double getExperiencePoints();
    void setCharacterLevel(int characterLevel);
    int getCharacterLevel();
    void setConcentrationCheck(int concentrationCheck);
    int getConcentrationCheck();
    void setAlignment(AlignmentEnum alignment);
    AlignmentEnum getAlignment();
    void setTotalBaseAttackBonus(int totalBaseAttackBonus);
    int getTotalBaseAttackBonus();
    void setCharacterRace(IRace race);
    IRace getCharacterRace();
    void setHitPoints(IHitPoints hitPoints);
    IHitPoints getHitPoints();
    void setTotalAC(int totalAC);
    int getTotalAC();
    void setFeats(List<IFeat> feats);
    List<IFeat> getFeats();
    void setEquipment(List<IEquipment> equipment);
    List<IEquipment> getEquipment();
    void setDR(IDamageReduction dr);
    IDamageReduction getDR();
    void setLanguagesKnown(List<String> languagesKnown);
    List<String> getLanguagesKnown();
    void setAbilityScores(IAbilityScore[] scores);
    IAbilityScore[] getAbilityScores();
    void setCombatManeuverStats(ICombatManeuver combatManeuverStats);
    ICombatManeuver getCombatManeuverStats();
    void setSpellResistance(int spellResistance);
    int getSpellResistance();
    void setInitiative(int initiative);
    int getInitiative();
    void setFortitudeSave(int fortitudeSave);
    int getFortitudeSave();
    void setReflexSave(int reflexSave);
    int getReflexSave();
    void setWillSave(int willSave);
    int getWillSave();

}
