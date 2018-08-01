package com.pathfinderstattracker.pathfindercharactersheet.database.database_entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Stephen Hagen on 5/1/2018.
 */
@Entity
public class ClassPrerequisiteEntity
{
    @PrimaryKey
    private int classPrerequisiteID;
    @ColumnInfo(name = "characterClassID")
    private int characterClassID;//Todo: We'll have to create a character class entity for this to join to at some point
    @ColumnInfo(name = "required_class_level")
    private int requiredClassLevel;

    //region Getters and Setters
    public int getClassPrerequisiteID()
    {
        return classPrerequisiteID;
    }

    public void setClassPrerequisiteID(int classPrerequisiteID)
    {
        this.classPrerequisiteID = classPrerequisiteID;
    }

    public int getCharacterClassID()
    {
        return characterClassID;
    }

    public void setCharacterClassID(int characterClassID)
    {
        this.characterClassID = characterClassID;
    }

    public int getRequiredClassLevel()
    {
        return requiredClassLevel;
    }

    public void setRequiredClassLevel(int requiredClassLevel)
    {
        this.requiredClassLevel = requiredClassLevel;
    }
    //endregion
}
