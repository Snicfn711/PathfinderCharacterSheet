package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.os.AsyncTask;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public void requestPlayerNamesAndIDs(PathfinderRepositoryListener callingActivity)
    {
        getPlayerCharacterNamesAndIDsAsyncTask task = new getPlayerCharacterNamesAndIDsAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerCharacterByID(UUID playerCharacterID, PathfinderRepositoryListener callingActivity)
    {
        getPlayerCharacterByIDAsyncTask task = new getPlayerCharacterByIDAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void updatePlayerCharacterAbilityScores(UUID playerCharacterID, List<IAbilityScore> updatedScores)
    {
        new updatePlayerCharacterAbilityScoresAsyncTask(playerCharacterDao).execute(playerCharacterID, updatedScores);
    }

    //region Async Tasks
    private static class updatePlayerCharacterNameAsyncTask extends AsyncTask<Object, Void, Void>
    {
       private PlayerCharacterDao asyncPlayerCharacterDao;
       updatePlayerCharacterNameAsyncTask(PlayerCharacterDao dao) {asyncPlayerCharacterDao = dao;}
        @Override
        protected Void doInBackground(final Object... params)
        {
            String updatedName = (String) params[0];
            UUID playerCharacterName = (UUID)params[1];
            asyncPlayerCharacterDao.updatePlayerCharacterName(playerCharacterName, updatedName);
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

    private static class getPlayerCharacterByIDAsyncTask extends AsyncTask<UUID, Void, IPlayerCharacter>
    {
        private PathfinderRepositoryListener delegate = null;
        private PlayerCharacterDao asyncPlayerCharacterDao;

        getPlayerCharacterByIDAsyncTask(PlayerCharacterDao dao){asyncPlayerCharacterDao = dao;}

        @Override
        protected IPlayerCharacter doInBackground(UUID... uuids)
        {
            PlayerCharacterEntity entityToConvert = asyncPlayerCharacterDao.getPlayerCharacterByID(uuids[0]);
            IPlayerCharacter characterToReturn = DatabaseEntityObjectConverter.ConverterPlayerCharacterEntityToPlayerCharacterObject(entityToConvert);
            return characterToReturn;
        }

        @Override
        protected void onPostExecute(IPlayerCharacter characterToReturn)
        {
            delegate.findCharacterProcessFinished(characterToReturn);
        }
    }
    private static class getPlayerCharacterNamesAndIDsAsyncTask extends  AsyncTask<Void, Void, List<PlayerCharacterNameAndIDEntity>>
    {
        private  PlayerCharacterDao asyncPlayerCharacterDao;
        private PathfinderRepositoryListener delegate = null;

        getPlayerCharacterNamesAndIDsAsyncTask(PlayerCharacterDao dao)
        {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected List<PlayerCharacterNameAndIDEntity> doInBackground(Void... voids)
        {
            return asyncPlayerCharacterDao.getListOfCharacterNames();
        }

        protected void onPostExecute(List<PlayerCharacterNameAndIDEntity> result)
        {
            delegate.getCharacterNamesAndIDsProcessFinished(result);
        }
    }

    private static class updatePlayerCharacterAbilityScoresAsyncTask extends AsyncTask<Object, Void, Void>
    {
        private PlayerCharacterDao asyncPlayerCharacterDao;
        updatePlayerCharacterAbilityScoresAsyncTask(PlayerCharacterDao dao) {asyncPlayerCharacterDao = dao;}
        @Override
        protected Void doInBackground(final Object... params)
        {
            UUID playerCharacterID = (UUID)params[0];
            List<AbilityScore> updatedAbilityScores = (ArrayList<AbilityScore>)params[1];
            asyncPlayerCharacterDao.updatePlayerCharacterAbilityScores(playerCharacterID, updatedAbilityScores);
            return null;
        }
    }
    //endregion
}
