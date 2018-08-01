package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityTypeEnumConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityTypeEnum;

/**
 * Created by Stephen Hagen on 4/25/2018.
 */
@Entity
@TypeConverters(AbilityTypeEnumConverter.class)
public class AbilityEntity
{
    @PrimaryKey
    private int abilityID;

    @ColumnInfo(name = "ability_name")
    private String abilityName;
    @ColumnInfo(name = "ability_type")
    private AbilityTypeEnum abilityType;
    @ColumnInfo(name = "effect_text")
    private String effectText;
    @ColumnInfo(name = "short_description")
    private String shortDescription;
    @ColumnInfo(name = "spell_copied")
    private int spellCopied;
    @ColumnInfo(name = "bonuses")
    private int bonuses;
    @ColumnInfo(name = "penalties")
    private int penalties;

    //region Getters and Setters
    public int getAbilityID()
    {
        return abilityID;
    }

    public void setAbilityID(int abilityID)
    {
        this.abilityID = abilityID;
    }

    public String getAbilityName()
    {
        return abilityName;
    }

    public void setAbilityName(String abilityName)
    {
        this.abilityName = abilityName;
    }

    public AbilityTypeEnum getAbilityType()
    {
        return abilityType;
    }

    public void setAbilityType(AbilityTypeEnum abilityType)
    {
        this.abilityType = abilityType;
    }

    public String getEffectText()
    {
        return effectText;
    }

    public void setEffectText(String effectText)
    {
        this.effectText = effectText;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public int getSpellCopied()
    {
        return spellCopied;
    }

    public void setSpellCopied(int spellCopied)
    {
        this.spellCopied = spellCopied;
    }

    public int getBonuses()
    {
        return bonuses;
    }

    public void setBonuses(int bonuses)
    {
        this.bonuses = bonuses;
    }

    public int getPenalties()
    {
        return penalties;
    }

    public void setPenalties(int penalties)
    {
        this.penalties = penalties;
    }
    //endregion
}
