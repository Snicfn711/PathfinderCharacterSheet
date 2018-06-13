package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AlignmentEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.CombatManeuverConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.DamageReductionConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.HitPointsConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.StringListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.AlignmentEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.DamageReduction;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ICombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IDamageReduction;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "player_characters")
@TypeConverters({AlignmentEnumConverter.class,
                 HitPointsConverter.class,
                 DamageReductionConverter.class,
                 StringListConverter.class,
                 UUIDConverter.class,
                 StringListConverter.class,
                 AbilityScoreListConverter.class,
                 CombatManeuverConverter.class})
public class PlayerCharacterEntity
{
    @PrimaryKey
    @NonNull
    private UUID playerCharacterID;
    @ColumnInfo(name="character_name")
    private String playerCharacterName;
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
    private List<IAbilityScore> abilityScores;
    @ColumnInfo(name="combat_Maneuver_stats")
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
    @NonNull
    public UUID getPlayerCharacterID() {
        return playerCharacterID;
    }

    @NonNull
    public void setPlayerCharacterID(UUID playerCharacterID) {
        this.playerCharacterID = playerCharacterID;
    }

    public String getPlayerCharacterName() {
        return playerCharacterName;
    }

    public void setPlayerCharacterName(String playerCharacterName) {
        this.playerCharacterName = playerCharacterName;
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

    public List<IAbilityScore> getAbilityScores() {
        return abilityScores;
    }

    public void setAbilityScores(List<IAbilityScore> abilityScores) {
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


    private PlayerCharacterEntity()
    {
        setPlayerCharacterName("");
        setCharacterLevel(1);
        setConcentrationCheck(0);
        setCharacterAlignment(AlignmentEnum.TrueNeutral);
        setTotalBaseAttackBonus(0);
        setTotalHitPoints(new HitPoints(0,0));
        setTotalAC(0);
        setDamageReduction(new DamageReduction(0,"",""));
        setLanguagesKnown(new ArrayList<String>(Arrays.asList("Common")));
        setAbilityScores(new ArrayList<IAbilityScore>(Arrays.asList(new AbilityScore(AbilityScoreEnum.STR,10),
                                                                    new AbilityScore(AbilityScoreEnum.DEX, 10),
                                                                    new AbilityScore(AbilityScoreEnum.CON, 10),
                                                                    new AbilityScore(AbilityScoreEnum.INT, 10),
                                                                    new AbilityScore(AbilityScoreEnum.WIS, 10),
                                                                    new AbilityScore(AbilityScoreEnum.CHA, 10))));
        setCombatManeuverStats(new CombatManeuver(0,10));
        setSpellResistance(0);
        setFortitudeSave(0);
        setReflexSave(0);
        setWillSave(0);
    }

    public PlayerCharacterEntity(UUID playerCharacterID)
    {
        this();
        setPlayerCharacterID(playerCharacterID);
    }
}
