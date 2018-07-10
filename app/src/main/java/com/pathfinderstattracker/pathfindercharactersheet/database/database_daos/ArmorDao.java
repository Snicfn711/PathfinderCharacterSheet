package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;

@Dao
public interface ArmorDao
{
    @Insert
    void insertArmor(ArmorEntity armorEntity);
}
