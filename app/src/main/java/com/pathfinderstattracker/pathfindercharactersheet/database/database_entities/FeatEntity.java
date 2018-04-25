package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IBonus;
import com.pathfinderstattracker.pathfindercharactersheet.models.IPenalty;
import com.pathfinderstattracker.pathfindercharactersheet.models.feats.IPrerequisite;

import java.util.List;

/**
 * Created by Stephen Hagen on 4/24/2018.
 */
@Entity()
public class FeatEntity
{
    @PrimaryKey
    private int featID;

    @ColumnInfo(name = "prerequisites")
    private List<IPrerequisite> Prerequisites;
    @ColumnInfo(name = "effect_text")
    private String EffectText;
    @ColumnInfo(name = "abilities")
    private List<IAbility> Abilities;
    @ColumnInfo(name = "bonuses")
    private List<IBonus> Bonuses = null;
    @ColumnInfo(name = "penalties")
    private List<IPenalty> Penalties = null;

    //region Getters and Setters
    public int getFeatID()
    {
        return featID;
    }

    public void setFeatID(int featID)
    {
        this.featID = featID;
    }

    public List<IPrerequisite> getPrerequisites()
    {
        return Prerequisites;
    }

    public void setPrerequisites(List<IPrerequisite> prerequisites)
    {
        Prerequisites = prerequisites;
    }

    public String getEffectText()
    {
        return EffectText;
    }

    public void setEffectText(String effectText)
    {
        EffectText = effectText;
    }

    public List<IAbility> getAbilities()
    {
        return Abilities;
    }

    public void setAbilities(List<IAbility> abilities)
    {
        Abilities = abilities;
    }

    public List<IBonus> getBonuses()
    {
        return Bonuses;
    }

    public void setBonuses(List<IBonus> bonuses)
    {
        Bonuses = bonuses;
    }

    public List<IPenalty> getPenalties()
    {
        return Penalties;
    }

    public void setPenalties(List<IPenalty> penalties)
    {
        Penalties = penalties;
    }
    //endregion
}
