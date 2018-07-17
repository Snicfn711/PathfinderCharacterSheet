package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;

import java.util.List;

@Dao
@TypeConverters({UUIDConverter.class})
public interface ArmorDao
{
    @Insert
    void insertArmor(ArmorEntity armorEntity);
    @Query("SELECT * FROM armor")
    List<ArmorEntity> getAllArmors();
}
