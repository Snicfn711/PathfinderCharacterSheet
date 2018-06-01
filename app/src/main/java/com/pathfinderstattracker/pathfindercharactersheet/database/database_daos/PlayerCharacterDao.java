package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.UUID;

@Dao
@TypeConverters(UUIDConverter.class)
public interface PlayerCharacterDao
{
    @Insert
    public void insertPlayerCharacter(PlayerCharacterEntity character);
    @Query("SELECT * FROM player_characters " +
    "WHERE playerCharacterID = :playerCharacterIDtoFind")
    PlayerCharacterEntity getPlayerCharacterByID(UUID playerCharacterIDtoFind);
}
