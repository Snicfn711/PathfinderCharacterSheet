package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IClassPrerequisite;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IFeat;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IRace;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/27/2018.
 */
@Entity
@TypeConverters(AbilityScoreConverter.class)
public class PrerequisiteEntity
{
    @PrimaryKey
    private int prerequisiteID;

    @ColumnInfo(name = "character_level")
    private int CharacterLevel;
    @ColumnInfo(name = "class_prerequisite")
    private List<IClassPrerequisite> ClassPrerequisite; //This is for feats the require a certain class level to be taken (Like Fighter 8)
    @ColumnInfo(name = "caster_level")
    private int CasterLevel;
    @ColumnInfo(name = "ability_score_prerequisite")
    private IAbilityScore AbilityScorePrerequisite;
    @ColumnInfo(name = "ability_prerequisite")
    private int AbilityPrerequisite;
    @ColumnInfo(name = "feat_prerequisite")
    private int FeatPrerequisite;//Todo: Feats have prerequisites, and prerequisites can have a list of feats, something's fishy
    @ColumnInfo(name = "race_prerequisite")
    private Integer RacePrerequisite;

    //region Getters and Setters
    public int getPrerequisiteID()
    {
        return prerequisiteID;
    }

    public void setPrerequisiteID(int prerequisiteID)
    {
        this.prerequisiteID = prerequisiteID;
    }

    public int getCharacterLevel()
    {
        return CharacterLevel;
    }

    public void setCharacterLevel(int characterLevel)
    {
        CharacterLevel = characterLevel;
    }

    public List<IClassPrerequisite> getClassPrerequisite()
    {
        return ClassPrerequisite;
    }

    public void setClassPrerequisite(List<IClassPrerequisite> classPrerequisite)
    {
        ClassPrerequisite = classPrerequisite;
    }

    public int getCasterLevel()
    {
        return CasterLevel;
    }

    public void setCasterLevel(int casterLevel)
    {
        CasterLevel = casterLevel;
    }

    public IAbilityScore getAbilityScorePrerequisite()
    {
        return AbilityScorePrerequisite;
    }

    public void setAbilityScorePrerequisite(IAbilityScore abilityScorePrerequisite)
    {
        AbilityScorePrerequisite = abilityScorePrerequisite;
    }

    public int getAbilityPrerequisite()
    {
        return AbilityPrerequisite;
    }

    public void setAbilityPrerequisite(int abilityPrerequisite)
    {
        AbilityPrerequisite = abilityPrerequisite;
    }

    public int getFeatPrerequisite()
    {
        return FeatPrerequisite;
    }

    public void setFeatPrerequisite(int featPrerequisite)
    {
        FeatPrerequisite = featPrerequisite;
    }

    public Integer getRacePrerequisite()
    {
        return RacePrerequisite;
    }

    public void setRacePrerequisite(Integer racePrerequisite)
    {
        RacePrerequisite = racePrerequisite;
    }
    //endregion
}
