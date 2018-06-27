package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.UUID;

@Dao
@TypeConverters({UUIDConverter.class})
public interface PlayerSkillsDao
{
    @Insert
    void InsertPlayerSkill(PlayerSkillsEntity playerSkillsEntity);
    @Query("SELECT * FROM player_skills " +
           "WHERE playerCharacterID = :playerCharacterID " +
           "AND skillID = :skillID")
    PlayerSkillsEntity GetPlayerSkillEntity(UUID playerCharacterID, UUID skillID);
    @Update
    void UpdatePlayerSkillsEntity(PlayerSkillsEntity playerSkillEntityToUpdate);
}
