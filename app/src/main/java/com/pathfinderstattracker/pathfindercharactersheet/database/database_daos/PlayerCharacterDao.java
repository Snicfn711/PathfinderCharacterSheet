package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreConcreteConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.AbilityScoreInterfaceConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Dao
@TypeConverters({UUIDConverter.class,
                 AbilityScoreConcreteConverter.class})
public interface PlayerCharacterDao
{
    @Insert
    public void insertPlayerCharacter(PlayerCharacterEntity character);
    @Query("SELECT * FROM player_characters " +
           "WHERE playerCharacterID = :playerCharacterIDtoFind")
    PlayerCharacterEntity getPlayerCharacterByID(UUID playerCharacterIDtoFind);
    @Query("UPDATE player_characters "+
           "SET ability_scores = :playerCharacterAbilityScores "+
           "WHERE playerCharacterID = :characterIDToUpdate")
    void updatePlayerCharacterAbilityScores(UUID characterIDToUpdate, List<AbilityScore> playerCharacterAbilityScores);
    @Query("UPDATE player_characters "+
           "SET character_name = :playerCharacterName " +
           "WHERE playerCharacterID = :characterIDToUpdate")
    void updatePlayerCharacterName(UUID characterIDToUpdate, String playerCharacterName);
    @Query("SELECT character_name, playerCharacterID " +
           "FROM player_characters")
    List<PlayerCharacterNameAndIDEntity> getListOfCharacterNames();
}
