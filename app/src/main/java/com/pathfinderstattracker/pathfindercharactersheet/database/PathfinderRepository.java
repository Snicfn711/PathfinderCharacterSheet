package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

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

    public void updatePlayerCharacterName(String playerCharacterName, UUID playerCharacterID)
    {
        new updatePlayerCharacterNameAsyncTask(playerCharacterDao).execute(playerCharacterName, playerCharacterID);
    }
    public List<PlayerCharacterNameAndIDEntity> getPlayerNamesAndIDs()
    {
        return playerCharacterDao.getListOfCharacterNames();
    }

    //region Async Tasks
    private static class updatePlayerCharacterNameAsyncTask extends AsyncTask<Object, Void, Void>
    {
       private PlayerCharacterDao asyncPlayerCharacterDao;
       updatePlayerCharacterNameAsyncTask(PlayerCharacterDao dao) {asyncPlayerCharacterDao = dao;}
        @Override
        protected Void doInBackground(final Object... params)
        {
            String myStringParam = (String) params[0];
            UUID myUUIDParam = (UUID)params[1];
            asyncPlayerCharacterDao.updatePlayerCharacterName(myStringParam, myUUIDParam);
            return null;
        }
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

//    private static class getPlayerCharacterNamesAndIDsAsyncTask extends  AsyncTask<Void, Void, List<PlayerCharacterNameAndIDEntity>>
//    {
//        private  PlayerCharacterDao asyncPlayerCharacterDao;
//        PathfinderRepository caller;
//
//        getPlayerCharacterNamesAndIDsAsyncTask(PlayerCharacterDao dao, PathfinderRepository caller)
//        {
//            asyncPlayerCharacterDao = dao;
//            this.caller = caller;
//        }
//
//        @Override
//        protected List<PlayerCharacterNameAndIDEntity> doInBackground(Void... voids)
//        {
//            return asyncPlayerCharacterDao.getListOfCharacterNames();
//        }
//
//        protected void onPostExecute(List<PlayerCharacterNameAndIDEntity> result)
//        {
//            caller.onGetPlayerCharacterNamesAndIDsBackgroundTaskCompleted(result);
//        }
//    }
    //endregion
}
