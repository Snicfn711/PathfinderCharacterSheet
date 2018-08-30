package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.List;
import java.util.UUID;

@Dao
@TypeConverters({UUIDConverter.class})

public interface PlayerArmorDao
{
    //Unfortunately we're stuck relying on this strategy for inserting duplicate objects into inventory.
    //As it stands duplicate objects are given a higher numerInInventory value and then forced into the database, overwriting the old value
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertPlayerArmor(PlayerArmorEntity playerArmorEntity);
    @Query("SELECT * FROM armor " +
           "INNER JOIN player_armor  ON armor.armorID = player_armor.armorID " +
           "WHERE player_armor.playerCharacterID = :playerCharacterID")
    List<ArmorEntity> GetListOfArmorEntitiesForPlayer(UUID playerCharacterID);
    @Query("SELECT * FROM player_armor " +
           "WHERE playerCharacterID = :playerCharacterID")
    List<PlayerArmorEntity> GetListOfPlayerArmorEntities(UUID playerCharacterID);
    @Update
    void UpdatePlayerArmorEntity(PlayerArmorEntity playerArmorEntityToUpdate);
}
