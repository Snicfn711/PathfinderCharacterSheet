package com.pathfinderstattracker.pathfindercharactersheet.database;

import android.app.Application;
import android.app.FragmentManager;
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
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;
import com.pathfinderstattracker.pathfindercharactersheet.views.InitiativeReferenceBlockView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class PathfinderRepository {
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

    public void initializePlayerSkill(InitializePlayerSkillsAsyncTaskFinishedListener callingActivity, IPlayerCharacter characterToInitialize, List<ISkill> skillsToInitialize)
    {
        initializePlayerSkillsAsyncTask task = new initializePlayerSkillsAsyncTask(playerSkillsDao);
        task.delegate = callingActivity;
        task.execute(characterToInitialize.getPlayerCharacterID(), skillsToInitialize);
    }

    public void requestPlayerNamesAndIDs(GetPlayerCharacterNamesAndIDsAsyncTaskFinishedListener callingActivity) {
        getPlayerCharacterNamesAndIDsAsyncTask task = new getPlayerCharacterNamesAndIDsAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerCharacterByID(UUID playerCharacterID, FindPlayerCharacterAsyncTaskFinishedListener callingActivity) {
        getPlayerCharacterByIDAsyncTask task = new getPlayerCharacterByIDAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void updatePlayerCharacter(PlayerCharacterEntity character, UpdatePlayerCharacterAsyncTaskFinishedListener callingActivity) {
        updatePlayerCharacterAsyncTask task = new updatePlayerCharacterAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(character);
    }

    public void requestSkills(GetUnformattedSkillsAsyncTaskFinishedListener callingActivity) {
        getUnformattedSkillsAsyncTask task = new getUnformattedSkillsAsyncTask(skillsDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerSkillEntity(GetPlayerSkillEntityAsyncTaskFinishedListener callingActivity, UUID playerCharacterID) {
        getPlayerSkillEntityAsyncTask task = new getPlayerSkillEntityAsyncTask(playerSkillsDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void updatePlayerSkillEntity(PlayerSkillsEntity playerSkillsEntity)
    {
        updatePlayerSkillEntityAsyncTask task = new updatePlayerSkillEntityAsyncTask(playerSkillsDao);
        task.execute(playerSkillsEntity);
    }

    public void requestArmors(GetAllArmorsAsyncTaskFinishedListener callingActivity)
    {
        getAllArmorsAsyncTask task = new getAllArmorsAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestPlayerArmors(UUID playerCharacterID, GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener callingActivity)
    {
        getArmorEntityForPlayerCharacterAsyncTask task = new getArmorEntityForPlayerCharacterAsyncTask(playerArmorDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }
    public void updatePlayerArmorEntity(PlayerArmorEntity playerArmorEntity, UpdatePlayerArmorAsyncTaskFinishedListener callingActivity)
    {
        updatePlayerArmorAsyncTask task = new updatePlayerArmorAsyncTask(playerArmorDao);
        task.delegate = callingActivity;
        task.execute(playerArmorEntity);
    }

    public void insertPlayerArmorEntity(PlayerArmorEntity playerArmorEntity, InsertPlayerArmorAsyncTaskFinishedListener callingActivity)
    {
        insertPlayerArmorAsyncTask task = new insertPlayerArmorAsyncTask(playerArmorDao);
        task.delegate = callingActivity;
        task.execute(playerArmorEntity);
    }

    public void requestSingleArmor(UUID armorIDToGet, GetSingleArmorAsyncTaskFinishedListener callingActivity)
    {
        getSingleArmorAsyncTask task = new getSingleArmorAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute(armorIDToGet);
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
        private FindPlayerCharacterAsyncTaskFinishedListener delegate = null;
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
            delegate.onFindPlayerCharacterAsyncTaskFinished(characterToReturn);
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

    private static class getUnformattedSkillsAsyncTask extends AsyncTask<Void, Void, List<ISkill>> {
        private SkillsDao asyncSkillsDao;
        private GetUnformattedSkillsAsyncTaskFinishedListener delegate = null;

        getUnformattedSkillsAsyncTask(SkillsDao dao) {
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
            delegate.onGetUnformattedSkillsAsyncTaskFinished(result);
        }
    }

    private static class getPlayerSkillEntityAsyncTask extends AsyncTask<UUID, Void, List<PlayerSkillsEntity>> {
        private PlayerSkillsDao asyncPlayerSkillsDao;
        private GetPlayerSkillEntityAsyncTaskFinishedListener delegate = null;

        getPlayerSkillEntityAsyncTask(PlayerSkillsDao dao) {
            asyncPlayerSkillsDao = dao;
        }

        @Override
        protected List<PlayerSkillsEntity> doInBackground(UUID... params) {
            return asyncPlayerSkillsDao.GetPlayerSkillEntity(params[0]);
        }

        protected void onPostExecute(List<PlayerSkillsEntity> result) {
            delegate.onGetPlayerSkillEntityAsyncTaskFinished(result);
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

    private static class insertPlayerArmorAsyncTask extends AsyncTask<PlayerArmorEntity, Void, Void>
    {
        private PlayerArmorDao asyncPlayerArmorDao;
        private InsertPlayerArmorAsyncTaskFinishedListener delegate;

        insertPlayerArmorAsyncTask(PlayerArmorDao dao){asyncPlayerArmorDao = dao;}

        @Override
        protected Void doInBackground(PlayerArmorEntity... params)
        {
            asyncPlayerArmorDao.InsertPlayerArmor(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void nothing)
        {
            delegate.onInsertPlayerArmorAsyncTaskFinished();
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
    //endregion

    //region Repository Listeners
    public interface FindPlayerCharacterAsyncTaskFinishedListener
    {
        void onFindPlayerCharacterAsyncTaskFinished(IPlayerCharacter playerCharacter);
    }

    public interface GetPlayerCharacterNamesAndIDsAsyncTaskFinishedListener
    {
        void onGetPlayerCharacterNamesAndIDsAsyncTaskFinished(List<PlayerCharacterNameAndIDEntity> playerCharacterNamesAndIDs);
    }

    public interface UpdatePlayerCharacterAsyncTaskFinishedListener
    {
        void onUpdatePlayerCharacterAsyncTaskFinished(PlayerCharacter playerCharacter);
    }

    public interface GetUnformattedSkillsAsyncTaskFinishedListener
    {
        void onGetUnformattedSkillsAsyncTaskFinished(List<ISkill> result);
    }

    public interface GetPlayerSkillEntityAsyncTaskFinishedListener
    {
        void onGetPlayerSkillEntityAsyncTaskFinished(List<PlayerSkillsEntity> result);
    }

    public interface UpdatePlayerSkillEntityAsyncTaskFinishedListener
    {
        void onUpdatePlayerSkillEntityAsyncTaskFinished();
    }

    public interface InitializePlayerSkillsAsyncTaskFinishedListener
    {
        void onInitializePlayerSkillsAsyncTaskFinished();
    }

    public interface GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener
    {
        void onGetArmorEntityForCurrentPlayerAsyncTaskFinished(List<PlayerArmorEntity> result);
    }

    public interface GetAllArmorsAsyncTaskFinishedListener
    {
        void onGetAllArmorsAsyncTaskFinished(List<ArmorEntity> result);
    }

    public interface InsertPlayerArmorAsyncTaskFinishedListener
    {
        void onInsertPlayerArmorAsyncTaskFinished();
    }

    public interface UpdatePlayerArmorAsyncTaskFinishedListener
    {
        void onUpdatePlayerArmorAsyncTaskFinished();
    }

    public interface GetSingleArmorAsyncTaskFinishedListener
    {
        void onGetSingleArmorAsyncTaskFinished(ArmorEntity result);
    }
    //endregion
}
