package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;

@Dao
public interface PlayerSkillsDao
{
    @Insert
    void InsertPlayerSkill(PlayerSkillsEntity playerSkillsEntity);
}
