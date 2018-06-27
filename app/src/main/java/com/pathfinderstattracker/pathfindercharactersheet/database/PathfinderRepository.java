package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.app.FragmentManager;
import android.os.AsyncTask;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerSkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.SkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PathfinderRepository
{
    private PlayerCharacterDao playerCharacterDao;
    private SkillsDao skillsDao;
    private PlayerSkillsDao playerSkillsDao;

    public PathfinderRepository(Application application)
    {
        PathfinderDatabase database = PathfinderDatabase.getDatabase(application);
        if(!database.doesDatabaseExist(application.getApplicationContext()))
        {
            DatabaseInitializer.populateAsync(database);
        }
        playerCharacterDao = database.PlayerCharacterDao();
        skillsDao = database.SkillsDao();
        playerSkillsDao = database.PlayerSkillsDao();
    }

    //region Synchronous Methods
    public void insertNewPlayerCharacter(IPlayerCharacter playerCharacter)
    {
        PlayerCharacterEntity EntityToInsert = DatabaseEntityObjectConverter.ConvertPlayerCharacterObjectToPlayerCharacterEntity(playerCharacter);
        new insertPlayerCharacterAsyncTask(playerCharacterDao).execute(EntityToInsert);
    }

    public void initializePlayerSkill(IPlayerCharacter characterToInitialize)
    {
        initializePlayerSkillsAsyncTask task = new initializePlayerSkillsAsyncTask(playerSkillsDao, skillsDao);
        task.execute(characterToInitialize.getPlayerCharacterID());
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

    public void updatePlayerCharacter(PlayerCharacterEntity character, PathfinderRepositoryListener callingActivity)
    {
        updatePlayerCharacterAsyncTask task = new updatePlayerCharacterAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(character);
    }

    public void requestSkills(PathfinderRepositoryListener callingActivity)
    {
        getUnformattedSkillsAsyncTask task = new getUnformattedSkillsAsyncTask(skillsDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerSkillEntity(PathfinderRepositoryListener callingActivity, UUID playerCharacterID, UUID skillID)
    {
       getPlayerSkillEntityAsyncTask task = new getPlayerSkillEntityAsyncTask(playerSkillsDao);
       task.delegate = callingActivity;
       task.execute(playerCharacterID, skillID);
    }

    public void updatePlayerSkillEntity(PlayerSkillsEntity playerSkillsEntity)
    {

    }

    //endregion

    //region Async Tasks
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

    private static class initializePlayerSkillsAsyncTask extends AsyncTask<UUID, Void, Void>
    {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private SkillsDao asyncSkillsDao;

        initializePlayerSkillsAsyncTask(PlayerSkillsDao playerSkillsDao, SkillsDao skillsDao)
        {
            asyncPlayerSkillsDao = playerSkillsDao;
            asyncSkillsDao = skillsDao;
        }

        @Override
        protected Void doInBackground(UUID... params)
        {
            getUnformattedSkillsAsyncTask task = new getUnformattedSkillsAsyncTask(asyncSkillsDao);
            try
            {
                List<ISkill> skillsList = task.execute().get();
                for(ISkill skill : skillsList)
                {
                    PlayerSkillsEntity temp = new PlayerSkillsEntity();
                    temp.setPlayerID(params[0]);
                    temp.setSkillID(skill.getSkillID());
                    temp.setLevelUpPointsInvested(0);
                    temp.setFavoredClassPointsInvested(0);
                    asyncPlayerSkillsDao.InsertPlayerSkill(temp);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
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
            return DatabaseEntityObjectConverter.ConverterPlayerCharacterEntityToPlayerCharacterObject(entityToConvert);
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

    private static class updatePlayerCharacterAsyncTask extends AsyncTask<PlayerCharacterEntity, Void, PlayerCharacterEntity>
    {
        private PlayerCharacterDao asyncPlayerCharacterDao;
        private PathfinderRepositoryListener delegate = null;

        updatePlayerCharacterAsyncTask(PlayerCharacterDao dao) {asyncPlayerCharacterDao = dao;}

        @Override
        protected PlayerCharacterEntity doInBackground(final PlayerCharacterEntity... params)
        {
            asyncPlayerCharacterDao.updatePlayerCharacter(params[0]);
            return params[0];
        }

        protected  void onPostExecute(PlayerCharacterEntity result)
        {
            delegate.updateCharacterFinished((PlayerCharacter)DatabaseEntityObjectConverter.ConverterPlayerCharacterEntityToPlayerCharacterObject(result));
        }
    }

    private static class getUnformattedSkillsAsyncTask extends AsyncTask<Void, Void, List<ISkill>>
    {
        private SkillsDao asyncSkillsDao;
        private PathfinderRepositoryListener delegate = null;
        getUnformattedSkillsAsyncTask(SkillsDao dao){asyncSkillsDao = dao;}

        @Override
        protected List<ISkill> doInBackground(Void...voids)
        {
            List<SkillEntity> skillsToConvert = asyncSkillsDao.getUneditedSkillsList();
            List<ISkill> skillsToReturn = new ArrayList<ISkill>();
            for(SkillEntity skillEntity : skillsToConvert)
            {
                skillsToReturn.add(DatabaseEntityObjectConverter.ConvertSkillEntityToSkillObject(skillEntity));
            }
            return skillsToReturn;
        }

        protected  void onPostExecute(List<ISkill> result)
        {
            delegate.getUnformattedSkillsTaskFinished(result);
        }
    }

    private static class getPlayerSkillEntityAsyncTask extends AsyncTask<UUID, Void, PlayerSkillsEntity>
    {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private PathfinderRepositoryListener delegate = null;

        getPlayerSkillEntityAsyncTask(PlayerSkillsDao dao){asyncPlayerSkillsDao = dao;}

        @Override
        protected PlayerSkillsEntity doInBackground(UUID... params)
        {
            return asyncPlayerSkillsDao.GetPlayerSkillEntity(params[0], params[1]);
        }

        protected  void onPostExecute(PlayerSkillsEntity result)
        {
            delegate.getPlayerSkillEntityTaskFinished(result);
        }
    }

    private static class updatePlayerSkillEntityAsyncTask extends AsyncTask<PlayerSkillsEntity, Void, Void>
    {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private PathfinderRepositoryListener delegate = null;

        updatePlayerSkillEntityAsyncTask(PlayerSkillsDao dao){asyncPlayerSkillsDao = dao;}

        @Override
        protected Void doInBackground(PlayerSkillsEntity... params)
        {
            asyncPlayerSkillsDao.UpdatePlayerSkillsEntity(params[0]);
            return null;
        }
    }
    //endregion
}
