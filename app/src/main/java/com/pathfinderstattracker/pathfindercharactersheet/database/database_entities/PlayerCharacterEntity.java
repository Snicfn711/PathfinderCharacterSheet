package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ICombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IDamageReduction;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;

import java.util.List;
import java.util.UUID;

@Entity(tableName = "player_characters")
public class PlayerCharacterEntity
{
    @PrimaryKey
    private UUID playerCharacterID;
    @ColumnInfo(name="character_name")
    private String characterName;
    @ColumnInfo(name="character_level")
    private int characterLevel;
    @ColumnInfo(name="concentration_check")
    private int concentrationCheck;
    @ColumnInfo(name="character_alignment")
    private AlignmentEnum characterAlignment;
    @ColumnInfo(name="total_base_attack_bonus")
    private int totalBaseAttackBonus;
    @ColumnInfo(name="total_hit_points")
    private IHitPoints totalHitPoints;
    @ColumnInfo(name="total_ac")
    private int totalAC;
    @ColumnInfo(name="damage_reduction")
    private IDamageReduction damageReduction;
    @ColumnInfo(name="languages_known")
    private List<String> languagesKnown;
    @ColumnInfo(name="ability_scores")
    private IAbilityScore[] abilityScores;
    @ColumnInfo(name="combat_manuever_stats")
    private ICombatManeuver combatManeuverStats;
    @ColumnInfo(name="spell_resistance")
    private int spellResistance;
    @ColumnInfo(name="initiative")
    private int initiative;
    @ColumnInfo(name="fortitude_save")
    private int fortitudeSave;
    @ColumnInfo(name="reflex_save")
    private int reflexSave;
    @ColumnInfo(name="will_save")
    private int willSave;

    //region Getters and Setters
    public UUID getPlayerCharacterID() {
        return playerCharacterID;
    }

    public void setPlayerCharacterID(UUID playerCharacterID) {
        this.playerCharacterID = playerCharacterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public int getConcentrationCheck() {
        return concentrationCheck;
    }

    public void setConcentrationCheck(int concentrationCheck) {
        this.concentrationCheck = concentrationCheck;
    }

    public AlignmentEnum getCharacterAlignment() {
        return characterAlignment;
    }

    public void setCharacterAlignment(AlignmentEnum characterAlignment) {
        this.characterAlignment = characterAlignment;
    }

    public int getTotalBaseAttackBonus() {
        return totalBaseAttackBonus;
    }

    public void setTotalBaseAttackBonus(int totalBaseAttackBonus) {
        this.totalBaseAttackBonus = totalBaseAttackBonus;
    }

    public IHitPoints getTotalHitPoints() {
        return totalHitPoints;
    }

    public void setTotalHitPoints(IHitPoints totalHitPoints) {
        this.totalHitPoints = totalHitPoints;
    }

    public int getTotalAC() {
        return totalAC;
    }

    public void setTotalAC(int totalAC) {
        this.totalAC = totalAC;
    }

    public IDamageReduction getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(IDamageReduction damageReduction) {
        this.damageReduction = damageReduction;
    }

    public List<String> getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(List<String> languagesKnown) {
        this.languagesKnown = languagesKnown;
    }

    public IAbilityScore[] getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(IAbilityScore[] abilityScores) {
        this.abilityScores = abilityScores;
    }

    public ICombatManeuver getCombatManeuverStats() {
        return combatManeuverStats;
    }

    public void setCombatManeuverStats(ICombatManeuver combatManeuverStats) {
        this.combatManeuverStats = combatManeuverStats;
    }

    public int getSpellResistance() {
        return spellResistance;
    }

    public void setSpellResistance(int spellResistance) {
        this.spellResistance = spellResistance;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getFortitudeSave() {
        return fortitudeSave;
    }

    public void setFortitudeSave(int fortitudeSave) {
        this.fortitudeSave = fortitudeSave;
    }

    public int getReflexSave() {
        return reflexSave;
    }

    public void setReflexSave(int reflexSave) {
        this.reflexSave = reflexSave;
    }

    public int getWillSave() {
        return willSave;
    }

    public void setWillSave(int willSave) {
        this.willSave = willSave;
    }
    //endregion


    public PlayerCharacterEntity()
    {
        //Default Constructors
    }
}
