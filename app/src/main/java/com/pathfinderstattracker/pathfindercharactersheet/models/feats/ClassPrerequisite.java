package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.classes.ICharacterClass;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public class ClassPrerequisite implements IClassPrerequisite
{
    private ICharacterClass Class;
    private int ClassLevel;

    //region Getters and Setters
    public ICharacterClass getCharacterClass()
    {
        return Class;
    }

    public void setClass(ICharacterClass characterClass)
    {
        Class = characterClass;
    }

    public int getClassLevel()
    {
        return ClassLevel;
    }

    public void setClassLevel(int classLevel)
    {
        ClassLevel = classLevel;
    }
    //endregion

    public ClassPrerequisite()
    {
        //Default Constructor
    }

    public ClassPrerequisite(ICharacterClass characterClass, int classLevel)
    {
        setClass(characterClass);
        setClassLevel(classLevel);
    }
}
