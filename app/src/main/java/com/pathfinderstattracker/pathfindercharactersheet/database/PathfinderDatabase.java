package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.ArmorDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerArmorDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerSkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.SkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.WeaponTagEnumListConverter;

import java.io.File;

/**
 * Created by Stephen Hagen on 4/19/2018.
 */

@Database(entities = {SkillEntity.class,
                      PlayerCharacterEntity.class,
                      PlayerSkillsEntity.class,
                      ArmorEntity.class,
                      PlayerArmorEntity.class},
                      version = 1)
@TypeConverters(WeaponTagEnumListConverter.class)
public abstract class PathfinderDatabase extends RoomDatabase
{
    private static PathfinderDatabase INSTANCE;

    public abstract PlayerCharacterDao PlayerCharacterDao();
    public abstract PlayerSkillsDao PlayerSkillsDao();
    public abstract SkillsDao SkillsDao();
    public abstract ArmorDao ArmorDao();
    public abstract PlayerArmorDao PlayerArmorDao();

    public static PathfinderDatabase getDatabase(Context context)
    {
        if(INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PathfinderDatabase.class, "pathfinder_database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }

    public boolean doesDatabaseExist(Context context)
    {
        File dbFile = context.getDatabasePath("pathfinder_database");
        return dbFile.exists();
    }
}
