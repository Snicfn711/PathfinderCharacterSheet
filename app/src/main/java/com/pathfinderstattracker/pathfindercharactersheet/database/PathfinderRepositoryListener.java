package com.pathfinderstattracker.pathfindercharactersheet.database;

import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;

public interface PathfinderRepositoryListener
{
    void findCharacterProcessFinished(IPlayerCharacter playerCharacter);
}
