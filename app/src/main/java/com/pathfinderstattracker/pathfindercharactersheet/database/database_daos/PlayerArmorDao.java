package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.List;
import java.util.UUID;

@Dao
@TypeConverters({UUIDConverter.class})

public interface PlayerArmorDao
{
    @Insert
    void InsertPlayerArmor(PlayerArmorEntity playerArmorEntity);
    @Query("SELECT * FROM player_armor " +
           "WHERE playerCharacterID = :playerCharacterID")
    List<PlayerArmorEntity> GetPlayerArmorEntity(UUID playerCharacterID);
    @Update
    void UpdatePlayerArmorEntity(PlayerArmorEntity playerArmorEntityToUpdate);
}
