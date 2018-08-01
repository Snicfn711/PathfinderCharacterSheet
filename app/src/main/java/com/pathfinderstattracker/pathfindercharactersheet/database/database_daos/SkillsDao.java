package com.pathfinderstattracker.pathfindercharactersheet.database.database_daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;

import java.util.List;

@Dao
public interface SkillsDao
{
    @Insert
    void insertSkill(SkillEntity skillToInsert);
    @Query("SELECT * FROM skills ")
    List<SkillEntity> getUneditedSkillsList();

}
