package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreListConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;

import java.util.UUID;
import java.util.List;

@Dao
@TypeConverters({UUIDConverter.class,
                 AbilityScoreConverter.class})
public interface PlayerCharacterDao
{
    @Insert
    public void insertPlayerCharacter(PlayerCharacterEntity character);
    @Query("SELECT * FROM player_characters " +
           "WHERE playerCharacterID = :playerCharacterIDtoFind")
    PlayerCharacterEntity getPlayerCharacterByID(UUID playerCharacterIDtoFind);
    @Update
    void updatePlayerCharacter(PlayerCharacterEntity character);
    @Query("SELECT character_name, playerCharacterID " +
           "FROM player_characters")
    List<PlayerCharacterNameAndIDEntity> getListOfCharacterNames();
}
