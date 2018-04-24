package com.pathfinderstattracker.pathfindercharactersheet.models.feats;

import com.pathfinderstattracker.pathfindercharactersheet.models.classes.ICharacterClass;

/**
 * Created by Stephen Hagen on 1/5/2018.
 */

public interface IClassPrerequisite
{
    ICharacterClass getCharacterClass();
    void setClass(ICharacterClass characterClass);
    int getClassLevel();
    void setClassLevel(int classLevel);
}
