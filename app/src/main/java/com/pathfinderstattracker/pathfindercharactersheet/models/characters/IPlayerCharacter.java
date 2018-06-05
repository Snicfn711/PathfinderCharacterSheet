package com.pathfinderstattracker.pathfindercharactersheet.models.characters;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by Stephen Hagen on 1/10/2018.
 */

public interface IPlayerCharacter extends Serializable
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
    void setCharacterAlignment(AlignmentEnum characterAlignment);
    AlignmentEnum getCharacterAlignment();
    void setTotalBaseAttackBonus(int totalBaseAttackBonus);
    int getTotalBaseAttackBonus();
    void setCharacterRace(IRace race);
    IRace getCharacterRace();
    void setTotalHitPoints(IHitPoints totalHitPoints);
    IHitPoints getTotalHitPoints();
    void setTotalAC(int totalAC);
    int getTotalAC();
    int getTouchAC();
    int getFlatFootedAC();
    void setFeats(List<IFeat> feats);
    List<IFeat> getFeats();
    void setEquipment(List<IEquipment> equipment);
    List<IEquipment> getEquipment();
    void setDamageReduction(IDamageReduction dr);
    IDamageReduction getDamageReduction();
    void setLanguagesKnown(List<String> languagesKnown);
    List<String> getLanguagesKnown();
    void setAbilityScores(List<IAbilityScore> scores);
    List<IAbilityScore> getAbilityScores();
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
