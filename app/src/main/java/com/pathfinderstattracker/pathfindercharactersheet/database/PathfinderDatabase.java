package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.WeaponEnchantmentDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.AbilityEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.FeatEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.WeaponEnchantmentEntity;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Database(entities = {WeaponEnchantmentEntity.class, SkillEntity.class, FeatEntity.class, AbilityEntity.class}, version = 1)
public abstract class PathfinderDatabase extends RoomDatabase
{
    public abstract WeaponEnchantmentDao weaponEnchantmentDao();
}
