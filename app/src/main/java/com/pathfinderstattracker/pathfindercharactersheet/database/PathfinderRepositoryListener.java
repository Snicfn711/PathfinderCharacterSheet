package com.pathfinderstattracker.pathfindercharactersheet.database;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;

import java.util.List;

public interface PathfinderRepositoryListener
{
    void findCharacterProcessFinished(IPlayerCharacter playerCharacter);
    void getCharacterNamesAndIDsProcessFinished(List<PlayerCharacterNameAndIDEntity> playerCharacterNamesAndIDs);
    void updateCharacterFinished(PlayerCharacter playerCharacter);
    void getUnformattedSkillsTaskFinished(List<ISkill> result);
    void getPlayerSkillEntityTaskFinished(PlayerSkillsEntity result);
}
