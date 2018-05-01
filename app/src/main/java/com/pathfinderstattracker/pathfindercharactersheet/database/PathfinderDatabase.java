package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.WeaponEnchantmentDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.AbilityEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.FeatAbilityListEntityClass;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.FeatEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.FeatPrerequisiteListEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.MovementEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PrerequisiteEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.RaceEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.RaceSenseListEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.RaceSkillListEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SenseEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SpellEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.WeaponEnchantmentEntity;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Database(entities = {WeaponEnchantmentEntity.class,
                      SkillEntity.class,
                      FeatEntity.class,
                      AbilityEntity.class,
                      SenseEntity.class,
                      PrerequisiteEntity.class,
                      FeatPrerequisiteListEntity.class,
                      FeatAbilityListEntityClass.class,
                      RaceEntity.class,
                      RaceSkillListEntity.class,
                      RaceSenseListEntity.class,
                      MovementEntity.class,
                      SpellEntity.class}, version = 1)
public abstract class PathfinderDatabase extends RoomDatabase
{
}
