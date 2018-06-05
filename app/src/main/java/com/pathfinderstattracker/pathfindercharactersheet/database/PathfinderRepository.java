package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

public class PathfinderRepository
{
    private PlayerCharacterDao playerCharacterDao;

    public PathfinderRepository(Application application)
    {
        PathfinderDatabase database = PathfinderDatabase.getDatabase(application);
        if(database == null)
        {
            DatabaseInitializer.populateAsync(database);
        }
        playerCharacterDao = database.PlayerCharacterDao();
    }

    public void insertPlayerCharacter(IPlayerCharacter playerCharacter)
    {
        PlayerCharacterEntity EntityToInsert = DatabaseEntityObjectConverter.ConvertPlayerCharacterObjectToPlayerCharacterEntity(playerCharacter);
        new insertPlayerCharacterAsyncTask(playerCharacterDao).execute(EntityToInsert);
    }



    private static class insertPlayerCharacterAsyncTask extends AsyncTask<PlayerCharacterEntity, Void, Void>
    {
        private PlayerCharacterDao asyncPlayerCharacterDao;

        insertPlayerCharacterAsyncTask(PlayerCharacterDao dao)
        {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected Void doInBackground(final PlayerCharacterEntity... params)
        {
            asyncPlayerCharacterDao.insertPlayerCharacter(params[0]);
            return null;
        }
    }
}
