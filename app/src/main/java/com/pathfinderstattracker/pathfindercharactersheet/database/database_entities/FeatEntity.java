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
    private Integer Prerequisites; //Theoretically a feat may have no prerequisites, hence the nullable integer return type
    @ColumnInfo(name = "effect_text")
    private String EffectText;
    @ColumnInfo(name = "abilities")
    private int Abilities; //Every feat should have some kind of attached ability. **CAUTION** Abilities are a bit poorly defined at the moment, so this field will likely be changed
    @ColumnInfo(name = "bonuses")
    private int Bonuses;
    @ColumnInfo(name = "penalties")
    private int Penalties;

    //region Getters and Setters
    public int getFeatID()
    {
        return featID;
    }

    public void setFeatID(int featID)
    {
        this.featID = featID;
    }

    public Integer getPrerequisites()
    {
        return Prerequisites;
    }

    public void setPrerequisites(Integer prerequisites)
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

    public int getAbilities()
    {
        return Abilities;
    }

    public void setAbilities(int abilities)
    {
        Abilities = abilities;
    }

    public int getBonuses()
    {
        return Bonuses;
    }

    public void setBonuses(int bonuses)
    {
        Bonuses = bonuses;
    }

    public int getPenalties()
    {
        return Penalties;
    }

    public void setPenalties(int penalties)
    {
        Penalties = penalties;
    }
    //endregion
}
