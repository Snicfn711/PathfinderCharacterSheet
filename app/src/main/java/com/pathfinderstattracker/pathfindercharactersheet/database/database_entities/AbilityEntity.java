package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/25/2018.
 */
@Entity
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
    private ISpell spellCopied;
    @ColumnInfo(name = "bonuses")
    private List<IBonus> bonuses;
    @ColumnInfo(name = "penalties")
    private List<IPenalty> penalties;

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

    public ISpell getSpellCopied()
    {
        return spellCopied;
    }

    public void setSpellCopied(ISpell spellCopied)
    {
        this.spellCopied = spellCopied;
    }

    public List<IBonus> getBonuses()
    {
        return bonuses;
    }

    public void setBonuses(List<IBonus> bonuses)
    {
        this.bonuses = bonuses;
    }

    public List<IPenalty> getPenalties()
    {
        return penalties;
    }

    public void setPenalties(List<IPenalty> penalties)
    {
        this.penalties = penalties;
    }
    //endregion
}
