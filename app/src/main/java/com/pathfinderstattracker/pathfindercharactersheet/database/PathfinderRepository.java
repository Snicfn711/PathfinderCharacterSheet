package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.ArmorDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerArmorDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerSkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.SkillsDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PathfinderRepository
{
    private PlayerCharacterDao playerCharacterDao;
    private SkillsDao skillsDao;
    private PlayerSkillsDao playerSkillsDao;
    private ArmorDao armorDao;
    private PlayerArmorDao playerArmorDao;

    public PathfinderRepository(Application application) {
        PathfinderDatabase database = PathfinderDatabase.getDatabase(application);
        if (!database.doesDatabaseExist(application.getApplicationContext())) {
            DatabaseInitializer.populateAsync(database);
        }
        playerCharacterDao = database.PlayerCharacterDao();
        skillsDao = database.SkillsDao();
        playerSkillsDao = database.PlayerSkillsDao();
        armorDao = database.ArmorDao();
        playerArmorDao = database.PlayerArmorDao();
    }

    //region Synchronous Methods
    public void insertNewPlayerCharacter(IPlayerCharacter playerCharacter)
    {
        PlayerCharacterEntity EntityToInsert = DatabaseEntityObjectConverter.ConvertPlayerCharacterObjectToPlayerCharacterEntity(playerCharacter);
        new insertPlayerCharacterAsyncTask(playerCharacterDao).execute(EntityToInsert);
    }

    public void insertCustomSkill(InsertCustomSkillListener callingActivity, ISkill customSkill, UUID currentPlayerCharacterID)
    {
        insertCustomSkillAsyncTask task = new insertCustomSkillAsyncTask(playerSkillsDao);
        task.delegate = callingActivity;

        PlayerSkillsEntity playerSkillsEntityToInsert = new PlayerSkillsEntity();
        playerSkillsEntityToInsert.setPlayerID(currentPlayerCharacterID);
        playerSkillsEntityToInsert.setSkillID(customSkill.getSkillID());
        playerSkillsEntityToInsert.setSkillName(customSkill.getSkillName());
        playerSkillsEntityToInsert.setLevelUpPointsInvested(customSkill.getLevelUpPointsInvested());
        playerSkillsEntityToInsert.setFavoredClassPointsInvested(customSkill.getFavoredClassPointsInvested());
        playerSkillsEntityToInsert.setArmorCheckPenaltyApplied(customSkill.isArmorCheckPenaltyApplied());
        playerSkillsEntityToInsert.setAddedStat(customSkill.getAddedStat());

        task.execute(playerSkillsEntityToInsert);
    }

    public void insertPlayerArmorEntity(PlayerArmorEntity playerArmorEntity)
    {
        insertPlayerArmorAsyncTask task = new insertPlayerArmorAsyncTask(playerArmorDao);
        task.execute(playerArmorEntity);
    }

    public void initializePlayerSkill(InitializePlayerSkillsAsyncTaskFinishedListener callingActivity, IPlayerCharacter characterToInitialize, List<ISkill> skillsToInitialize)
    {
        initializePlayerSkillsAsyncTask task = new initializePlayerSkillsAsyncTask(playerSkillsDao);
        task.delegate = callingActivity;
        task.execute(characterToInitialize.getPlayerCharacterID(), skillsToInitialize);
    }

    public void requestPlayerNamesAndIDs(GetPlayerCharacterNamesAndIDsAsyncTaskFinishedListener callingActivity)
    {
        getPlayerCharacterNamesAndIDsAsyncTask task = new getPlayerCharacterNamesAndIDsAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerCharacterByID(UUID playerCharacterID, GetPlayerCharacterAsyncTaskFinishedListener callingActivity)
    {
        getPlayerCharacterByIDAsyncTask task = new getPlayerCharacterByIDAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void requestSkills(GetDefaultSkillsAsyncTaskFinishedListener callingActivity)
    {
        getDefaultSkillsAsyncTask task = new getDefaultSkillsAsyncTask(skillsDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerSkills(GetPlayerSkillsAsyncTaskFinishedListener callingActivity, UUID playerCharacterID)
    {
        getPlayerSkillEntityAsyncTask task = new getPlayerSkillEntityAsyncTask(playerSkillsDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void requestArmors(GetAllArmorsAsyncTaskFinishedListener callingActivity)
    {
        getAllArmorsAsyncTask task = new getAllArmorsAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestSingleArmor(UUID armorIDToGet, GetSingleArmorAsyncTaskFinishedListener callingActivity)
    {
        getSingleArmorAsyncTask task = new getSingleArmorAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute(armorIDToGet);
    }

    public void requestPlayerArmors(UUID playerCharacterID, GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener callingActivity)
    {
        getArmorEntityForPlayerCharacterAsyncTask task = new getArmorEntityForPlayerCharacterAsyncTask(playerArmorDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void updatePlayerCharacter(PlayerCharacterEntity character, UpdatePlayerCharacterAsyncTaskFinishedListener callingActivity)
    {
        updatePlayerCharacterAsyncTask task = new updatePlayerCharacterAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(character);
    }

    public void updatePlayerArmorEntity(PlayerArmorEntity playerArmorEntity, UpdatePlayerArmorAsyncTaskFinishedListener callingActivity)
    {
        updatePlayerArmorAsyncTask task = new updatePlayerArmorAsyncTask(playerArmorDao);
        task.delegate = callingActivity;
        task.execute(playerArmorEntity);
    }

    public void updateSkill(ISkill skillToUpdate, UUID currentPlayerCharacterID)
    {
        updatePlayerSkillEntityAsyncTask task = new updatePlayerSkillEntityAsyncTask(playerSkillsDao);
        
        PlayerSkillsEntity playerSkillsEntityToUpdate = new PlayerSkillsEntity();
        playerSkillsEntityToUpdate.setPlayerID(currentPlayerCharacterID);
        playerSkillsEntityToUpdate.setSkillID(skillToUpdate.getSkillID());
        playerSkillsEntityToUpdate.setSkillName(skillToUpdate.getSkillName());
        playerSkillsEntityToUpdate.setLevelUpPointsInvested(skillToUpdate.getLevelUpPointsInvested());
        playerSkillsEntityToUpdate.setFavoredClassPointsInvested(skillToUpdate.getFavoredClassPointsInvested());
        playerSkillsEntityToUpdate.setArmorCheckPenaltyApplied(skillToUpdate.isArmorCheckPenaltyApplied());
        playerSkillsEntityToUpdate.setAddedStat(skillToUpdate.getAddedStat());

        task.execute(playerSkillsEntityToUpdate);
    }

    public void deleteCustomSkill(ISkill customSkill, UUID currentPlayerCharacterID)
    {
        deletePlayerSkillEntityAsyncTask task = new deletePlayerSkillEntityAsyncTask(playerSkillsDao);

        PlayerSkillsEntity playerSkillsEntityToDelete = new PlayerSkillsEntity();
        playerSkillsEntityToDelete.setPlayerID(currentPlayerCharacterID);
        playerSkillsEntityToDelete.setSkillID(customSkill.getSkillID());
        playerSkillsEntityToDelete.setSkillName(customSkill.getSkillName());
        playerSkillsEntityToDelete.setLevelUpPointsInvested(customSkill.getLevelUpPointsInvested());
        playerSkillsEntityToDelete.setFavoredClassPointsInvested(customSkill.getFavoredClassPointsInvested());
        playerSkillsEntityToDelete.setArmorCheckPenaltyApplied(customSkill.isArmorCheckPenaltyApplied());
        playerSkillsEntityToDelete.setAddedStat(customSkill.getAddedStat());
        
        task.execute(playerSkillsEntityToDelete);
    }
    //endregion

    //region Async Tasks
    private static class insertPlayerCharacterAsyncTask extends AsyncTask<PlayerCharacterEntity, Void, Void> {
        private PlayerCharacterDao asyncPlayerCharacterDao;

        insertPlayerCharacterAsyncTask(PlayerCharacterDao dao) {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected Void doInBackground(final PlayerCharacterEntity... params) {
            asyncPlayerCharacterDao.insertPlayerCharacter(params[0]);
            return null;
        }
    }

    private static class insertCustomSkillAsyncTask extends AsyncTask<PlayerSkillsEntity, Void, ISkill>
    {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private Exception exception;
        private PlayerSkillsEntity playerSkillsEntityToAdd;
        private ISkill skillToAdd;
        private InsertCustomSkillListener delegate = null;

        insertCustomSkillAsyncTask(PlayerSkillsDao playerSkillsDao)
        {
            asyncPlayerSkillsDao = playerSkillsDao;
        }

        @Override
        protected ISkill doInBackground(PlayerSkillsEntity... params)
        {
            playerSkillsEntityToAdd = params[0];
            skillToAdd = new Skill();
            
            try
            {
                asyncPlayerSkillsDao.InsertPlayerSkill(playerSkillsEntityToAdd);
            }
            catch(SQLiteConstraintException e)
            {
                exception = e;
            }
            
            skillToAdd.setSkillID(params[0].getSkillID());
            skillToAdd.setSkillName(params[0].getSkillName());
            skillToAdd.setAddedStat(params[0].getAddedStat());
            skillToAdd.setArmorCheckPenaltyApplied(params[0].isArmorCheckPenaltyApplied());
            skillToAdd.setLevelUpPointsInvested(params[0].getLevelUpPointsInvested());
            skillToAdd.setFavoredClassPointsInvested(params[0].getFavoredClassPointsInvested());
            
            return skillToAdd;
        }

        protected void onPostExecute(ISkill customSkillToReturn)
        {
            //We're relying on the database to error out if the user tries to add a duplicate custom skill.
            //It's rudimentary since it's only checking for exact name matches, but it should work for now.
            delegate.onInsertCustomSkillAsyncTaskFinished(customSkillToReturn, exception);
        }
    }

    private static class insertPlayerArmorAsyncTask extends AsyncTask<PlayerArmorEntity, Void, Void>
    {
        private PlayerArmorDao asyncPlayerArmorDao;

        insertPlayerArmorAsyncTask(PlayerArmorDao dao){asyncPlayerArmorDao = dao;}

        @Override
        protected Void doInBackground(PlayerArmorEntity... params)
        {
            asyncPlayerArmorDao.InsertPlayerArmor(params[0]);
            return null;
        }
    }

    private static class initializePlayerSkillsAsyncTask extends AsyncTask<Object, Void, Void> {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private InitializePlayerSkillsAsyncTaskFinishedListener delegate;

        initializePlayerSkillsAsyncTask(PlayerSkillsDao playerSkillsDao)
        {
            asyncPlayerSkillsDao = playerSkillsDao;
        }

        @Override
        protected Void doInBackground(Object... params) {
            UUID playerCharacterID = (UUID)params[0];
            List<ISkill> skillsList = (List<ISkill>)params[1];
            for(ISkill skill : skillsList)
            {
                PlayerSkillsEntity temp = new PlayerSkillsEntity();
                temp.setPlayerID(playerCharacterID);
                temp.setSkillID(skill.getSkillID());
                temp.setLevelUpPointsInvested(0);
                temp.setFavoredClassPointsInvested(0);
                temp.setAddedStat(skill.getAddedStat());
                temp.setArmorCheckPenaltyApplied(skill.isArmorCheckPenaltyApplied());
                temp.setSkillName(skill.getSkillName());
                asyncPlayerSkillsDao.InsertPlayerSkill(temp);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void nothing)
        {
            delegate.onInitializePlayerSkillsAsyncTaskFinished();
        }
    }

    private static class getPlayerCharacterByIDAsyncTask extends AsyncTask<UUID, Void, IPlayerCharacter> {
        private GetPlayerCharacterAsyncTaskFinishedListener delegate = null;
        private PlayerCharacterDao asyncPlayerCharacterDao;

        getPlayerCharacterByIDAsyncTask(PlayerCharacterDao dao) {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected IPlayerCharacter doInBackground(UUID... uuids) {
            PlayerCharacterEntity entityToConvert = asyncPlayerCharacterDao.getPlayerCharacterByID(uuids[0]);
            return DatabaseEntityObjectConverter.ConverterPlayerCharacterEntityToPlayerCharacterObject(entityToConvert);
        }

        @Override
        protected void onPostExecute(IPlayerCharacter characterToReturn) {
            delegate.onGetPlayerCharacterAsyncTaskFinished(characterToReturn);
        }
    }

    private static class getPlayerCharacterNamesAndIDsAsyncTask extends AsyncTask<Void, Void, List<PlayerCharacterNameAndIDEntity>> {
        private PlayerCharacterDao asyncPlayerCharacterDao;
        private GetPlayerCharacterNamesAndIDsAsyncTaskFinishedListener delegate = null;

        getPlayerCharacterNamesAndIDsAsyncTask(PlayerCharacterDao dao) {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected List<PlayerCharacterNameAndIDEntity> doInBackground(Void... voids) {
            return asyncPlayerCharacterDao.getListOfCharacterNames();
        }

        protected void onPostExecute(List<PlayerCharacterNameAndIDEntity> result) {
            delegate.onGetPlayerCharacterNamesAndIDsAsyncTaskFinished(result);
        }
    }

    private static class getDefaultSkillsAsyncTask extends AsyncTask<Void, Void, List<ISkill>> {
        private SkillsDao asyncSkillsDao;
        private GetDefaultSkillsAsyncTaskFinishedListener delegate = null;

        getDefaultSkillsAsyncTask(SkillsDao dao) {
            asyncSkillsDao = dao;
        }

        @Override
        protected List<ISkill> doInBackground(Void... voids) {
            List<SkillEntity> skillsToConvert = asyncSkillsDao.getUneditedSkillsList();
            List<ISkill> skillsToReturn = new ArrayList<ISkill>();
            for (SkillEntity skillEntity : skillsToConvert) {
                skillsToReturn.add(DatabaseEntityObjectConverter.ConvertSkillEntityToSkillObject(skillEntity));
            }
            return skillsToReturn;
        }

        protected void onPostExecute(List<ISkill> result) {
            delegate.onGetDefaultSkillsAsyncTaskFinished(result);
        }
    }

    private static class getPlayerSkillEntityAsyncTask extends AsyncTask<UUID, Void, List<PlayerSkillsEntity>> {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private GetPlayerSkillsAsyncTaskFinishedListener delegate = null;

        getPlayerSkillEntityAsyncTask(PlayerSkillsDao dao) {
            asyncPlayerSkillsDao = dao;
        }

        @Override
        protected List<PlayerSkillsEntity> doInBackground(UUID... params) {
            return asyncPlayerSkillsDao.GetPlayerSkillEntity(params[0]);
        }

        protected void onPostExecute(List<PlayerSkillsEntity> result)
        {
            List<ISkill> skillsToReturn = new ArrayList<>();
            for(PlayerSkillsEntity entity : result)
            {
                ISkill tempSkill = new Skill();

                tempSkill.setSkillID(entity.getSkillID());
                tempSkill.setSkillName(entity.getSkillName());
                tempSkill.setAddedStat(entity.getAddedStat());
                tempSkill.setArmorCheckPenaltyApplied(entity.isArmorCheckPenaltyApplied());
                tempSkill.setFavoredClassPointsInvested(entity.getFavoredClassPointsInvested());
                tempSkill.setLevelUpPointsInvested(entity.getLevelUpPointsInvested());

                skillsToReturn.add(tempSkill);
            }

            delegate.onGetPlayerSkillsAsyncTaskFinished(skillsToReturn);
        }
    }

    private static class getAllArmorsAsyncTask extends AsyncTask<Void, Void, List<ArmorEntity>>
    {
        private ArmorDao asyncArmorDao;
        private GetAllArmorsAsyncTaskFinishedListener delegate;

        getAllArmorsAsyncTask(ArmorDao dao){asyncArmorDao = dao;}

        @Override
        protected List<ArmorEntity> doInBackground(Void... voids)
        {
            return asyncArmorDao.getAllArmors();
        }

        @Override
        protected void onPostExecute(List<ArmorEntity> result)
        {
            delegate.onGetAllArmorsAsyncTaskFinished(result);
        }
    }

    private static class getArmorEntityForPlayerCharacterAsyncTask extends AsyncTask<UUID, Void, List<PlayerArmorEntity>>
    {
        private PlayerArmorDao asyncPlayerArmorDao;
        private GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener delegate;

        getArmorEntityForPlayerCharacterAsyncTask(PlayerArmorDao dao){asyncPlayerArmorDao = dao;}


        @Override
        protected List<PlayerArmorEntity> doInBackground(UUID... params)
        {
            return asyncPlayerArmorDao.GetPlayerArmorEntity(params[0]);
        }

        @Override
        protected void onPostExecute(List<PlayerArmorEntity> result)
        {
            delegate.onGetArmorEntityForCurrentPlayerAsyncTaskFinished(result);
        }
    }

    private static class getSingleArmorAsyncTask extends AsyncTask<UUID, Void, ArmorEntity>
    {
        private ArmorDao asyncArmorDao;
        private GetSingleArmorAsyncTaskFinishedListener delegate;

        getSingleArmorAsyncTask(ArmorDao dao){asyncArmorDao = dao;}


        @Override
        protected ArmorEntity doInBackground(UUID... params)
        {
            return asyncArmorDao.getSingleArmor(params[0]);
        }

        @Override
        protected void onPostExecute(ArmorEntity result)
        {
            delegate.onGetSingleArmorAsyncTaskFinished(result);
        }
    }

    private static class updatePlayerCharacterAsyncTask extends AsyncTask<PlayerCharacterEntity, Void, PlayerCharacterEntity> {
        private PlayerCharacterDao asyncPlayerCharacterDao;
        private UpdatePlayerCharacterAsyncTaskFinishedListener delegate = null;

        updatePlayerCharacterAsyncTask(PlayerCharacterDao dao) {
            asyncPlayerCharacterDao = dao;
        }

        @Override
        protected PlayerCharacterEntity doInBackground(final PlayerCharacterEntity... params) {
            asyncPlayerCharacterDao.updatePlayerCharacter(params[0]);
            return params[0];
        }

        protected void onPostExecute(PlayerCharacterEntity result) {
            delegate.onUpdatePlayerCharacterAsyncTaskFinished((PlayerCharacter) DatabaseEntityObjectConverter.ConverterPlayerCharacterEntityToPlayerCharacterObject(result));
        }
    }

    private static class updatePlayerSkillEntityAsyncTask extends AsyncTask<PlayerSkillsEntity, Void, Void> {
        private PlayerSkillsDao asyncPlayerSkillsDao;

        updatePlayerSkillEntityAsyncTask(PlayerSkillsDao dao) {
            asyncPlayerSkillsDao = dao;
        }

        @Override
        protected Void doInBackground(PlayerSkillsEntity... params) {
            asyncPlayerSkillsDao.UpdatePlayerSkillsEntity(params[0]);
            return null;
        }
    }

    private static class updatePlayerArmorAsyncTask extends AsyncTask<PlayerArmorEntity, Void, Void>
    {
        private PlayerArmorDao asyncPlayerArmorDao;
        private UpdatePlayerArmorAsyncTaskFinishedListener delegate;

        updatePlayerArmorAsyncTask(PlayerArmorDao dao){asyncPlayerArmorDao = dao;}

        @Override
        protected Void doInBackground(PlayerArmorEntity... params)
        {
            asyncPlayerArmorDao.UpdatePlayerArmorEntity(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void nothing)
        {
            delegate.onUpdatePlayerArmorAsyncTaskFinished();
        }
    }

    private static class deletePlayerSkillEntityAsyncTask extends AsyncTask<PlayerSkillsEntity, Void, Void>
    {
        private PlayerSkillsDao asyncPlayerSkillsDao;

        deletePlayerSkillEntityAsyncTask(PlayerSkillsDao dao){asyncPlayerSkillsDao = dao;}

        protected Void doInBackground(PlayerSkillsEntity... params)
        {
            asyncPlayerSkillsDao.DeletePlayerSkill(params[0]);
            return null;
        }
    }
    //endregion

    //region Repository Listeners
    public interface InsertCustomSkillListener
    {
        void onInsertCustomSkillAsyncTaskFinished(ISkill insertedCustomSkill, Exception thrownException);
    }

    public interface InitializePlayerSkillsAsyncTaskFinishedListener
    {
        void onInitializePlayerSkillsAsyncTaskFinished();
    }

    public interface GetPlayerCharacterAsyncTaskFinishedListener
    {
        void onGetPlayerCharacterAsyncTaskFinished(IPlayerCharacter playerCharacter);
    }

    public interface GetSingleArmorAsyncTaskFinishedListener
    {
        void onGetSingleArmorAsyncTaskFinished(ArmorEntity result);
    }

    public interface GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener
    {
        void onGetArmorEntityForCurrentPlayerAsyncTaskFinished(List<PlayerArmorEntity> result);
    }

    public interface GetAllArmorsAsyncTaskFinishedListener
    {
        void onGetAllArmorsAsyncTaskFinished(List<ArmorEntity> result);
    }

    public interface GetPlayerCharacterNamesAndIDsAsyncTaskFinishedListener
    {
        void onGetPlayerCharacterNamesAndIDsAsyncTaskFinished(List<PlayerCharacterNameAndIDEntity> playerCharacterNamesAndIDs);
    }

    public interface GetDefaultSkillsAsyncTaskFinishedListener
    {
        void onGetDefaultSkillsAsyncTaskFinished(List<ISkill> result);
    }

    public interface GetPlayerSkillsAsyncTaskFinishedListener
    {
        void onGetPlayerSkillsAsyncTaskFinished(List<ISkill> result);
    }

    public interface UpdatePlayerArmorAsyncTaskFinishedListener
    {
        void onUpdatePlayerArmorAsyncTaskFinished();
    }

    public interface UpdatePlayerCharacterAsyncTaskFinishedListener
    {
        void onUpdatePlayerCharacterAsyncTaskFinished(PlayerCharacter playerCharacter);
    }

    public interface UpdatePlayerSkillEntityAsyncTaskFinishedListener
    {
        void onUpdatePlayerSkillEntityAsyncTaskFinished();
    }
    //endregion
}
