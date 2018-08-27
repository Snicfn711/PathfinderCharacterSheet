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
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.pathfinderstattracker.pathfindercharactersheet.models.items.AbsItem.compareMundaneProtections;

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

    public void addMundaneProtectionToPlayerInventory(IProtection ProtectionToAdd, UUID currentPlayerCharacterID)
    {

        addMundaneProtectionToPlayerInventoryAsyncTask task = new addMundaneProtectionToPlayerInventoryAsyncTask(playerArmorDao);

        PlayerArmorEntity playerArmorEntityToAdd = new PlayerArmorEntity();
        playerArmorEntityToAdd.setPlayerArmorID(UUID.randomUUID());
        playerArmorEntityToAdd.setPlayerID(currentPlayerCharacterID);
        playerArmorEntityToAdd.setArmorID(ProtectionToAdd.getItemID());
        playerArmorEntityToAdd.setIsEquipped(false);

        task.execute(playerArmorEntityToAdd);
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

    public void requestMundaneProtections(GetAllMundaneProtectionsAsyncTaskFinishedListener callingActivity)
    {
        getAllMundaneProtectionsAsyncTask task = new getAllMundaneProtectionsAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute();
    }

    public void requestSingleMundaneProtection(UUID mundaneProtectionIDToGet, GetSingleMundaneProtectionAsyncTaskFinishedListener callingActivity)
    {
        getSingleMundaneProtectionAsyncTask task = new getSingleMundaneProtectionAsyncTask(armorDao);
        task.delegate = callingActivity;
        task.execute(mundaneProtectionIDToGet);
    }

    public void requestMundaneProtectionForPlayer(UUID playerCharacterID, GetMundaneProtectionForCurrentPlayerAsyncTaskFinishedListener callingActivity)
    {
        getMundaneProtectionForPlayerCharacterAsyncTask task = new getMundaneProtectionForPlayerCharacterAsyncTask(playerArmorDao, armorDao);
        task.delegate = callingActivity;
        task.execute(playerCharacterID);
    }

    public void updatePlayerCharacter(PlayerCharacterEntity character, UpdatePlayerCharacterAsyncTaskFinishedListener callingActivity)
    {
        updatePlayerCharacterAsyncTask task = new updatePlayerCharacterAsyncTask(playerCharacterDao);
        task.delegate = callingActivity;
        task.execute(character);
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

    private static class addMundaneProtectionToPlayerInventoryAsyncTask extends AsyncTask<PlayerArmorEntity, Void, Void>
    {
        private PlayerArmorDao asyncPlayerArmorDao;

        addMundaneProtectionToPlayerInventoryAsyncTask(PlayerArmorDao dao){asyncPlayerArmorDao = dao;}

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

    private static class getAllMundaneProtectionsAsyncTask extends AsyncTask<Void, Void, List<IProtection>>
    {
        private ArmorDao asyncArmorDao;
        private GetAllMundaneProtectionsAsyncTaskFinishedListener delegate;

        getAllMundaneProtectionsAsyncTask(ArmorDao dao){asyncArmorDao = dao;}

        @Override
        protected List<IProtection> doInBackground(Void... voids)
        {
            List<ArmorEntity> returnedArmorEntities = asyncArmorDao.getAllArmors();
            List<IProtection> protectionsToReturn = new ArrayList<>();
            for(ArmorEntity entity:returnedArmorEntities)
            {
                if(entity.getArmorType() == ArmorTypesEnum.Armor)
                {
                    protectionsToReturn.add(DatabaseEntityObjectConverter.ConvertArmorEntityToArmorObject(entity));
                }
                if(entity.getArmorType() == ArmorTypesEnum.Shield)
                {
                    protectionsToReturn.add(DatabaseEntityObjectConverter.ConvertArmorEntityToShieldObject(entity));
                }
            }
            Collections.sort(protectionsToReturn, compareMundaneProtections);
            return protectionsToReturn;
        }

        @Override
        protected void onPostExecute(List<IProtection> result)
        {
            delegate.onGetAllMundaneProtectionsAsyncTaskFinished(result);
        }
    }

    private static class getMundaneProtectionForPlayerCharacterAsyncTask extends AsyncTask<UUID, Void, List<PlayerArmorEntity>> implements GetSingleMundaneProtectionAsyncTaskFinishedListener
    {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //This is a hot mess. Rather than calling a method to get the PlayerArmorEntities then another one to constantly re-query the db to get all  the actual armor pieces  //
        //we should just write a better query somewhere. But we have no idea how to write multi-table queries in room and this should work for now.                           //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        private PlayerArmorDao asyncPlayerArmorDao;
        private ArmorDao asyncArmorDao;
        private GetMundaneProtectionForCurrentPlayerAsyncTaskFinishedListener delegate;
        private int playerMundaneProtectionsCount = 0;
        private List<IProtection> protectionListToReturn = new ArrayList<>();

        getMundaneProtectionForPlayerCharacterAsyncTask(PlayerArmorDao playerArmorDao, ArmorDao armorDao)
        {
            asyncPlayerArmorDao = playerArmorDao;
            asyncArmorDao = armorDao;
        }


        @Override
        protected List<PlayerArmorEntity> doInBackground(UUID... params)
        {
            return asyncPlayerArmorDao.GetPlayerArmorEntity(params[0]);
        }

        @Override
        protected void onPostExecute(List<PlayerArmorEntity> result)
        {
            playerMundaneProtectionsCount = result.size();
            for(PlayerArmorEntity entity : result)
            {
                getSingleMundaneProtectionAsyncTask task = new getSingleMundaneProtectionAsyncTask(asyncArmorDao);
                task.delegate = this;
                task.execute(entity.getArmorID());
            }
        }

        @Override
        public void onGetSingleMundaneProtectionAsyncTaskFinished(IProtection result)
        {
            protectionListToReturn.add(result);
            if(protectionListToReturn.size() == playerMundaneProtectionsCount)
            {
                delegate.onGetMundaneProtectionForCurrentPlayerAsyncTaskFinished(protectionListToReturn);
            }
        }
    }

    private static class getSingleMundaneProtectionAsyncTask extends AsyncTask<UUID, Void, IProtection>
    {
        private ArmorDao asyncArmorDao;
        private GetSingleMundaneProtectionAsyncTaskFinishedListener delegate;

        getSingleMundaneProtectionAsyncTask(ArmorDao dao){asyncArmorDao = dao;}


        @Override
        protected IProtection doInBackground(UUID... params)
        {
            ArmorEntity armorEntityToConvert = asyncArmorDao.getSingleArmor(params[0]);
            if(armorEntityToConvert instanceof IArmor)
            {
                return DatabaseEntityObjectConverter.ConvertArmorEntityToArmorObject(armorEntityToConvert);
            }
            else if (armorEntityToConvert instanceof IShield)
            {
                return DatabaseEntityObjectConverter.ConvertArmorEntityToShieldObject(armorEntityToConvert);
            }

            throw new RuntimeException("The current player character has been given an invalid armor or shield");
        }

        @Override
        protected void onPostExecute(IProtection result)
        {
            delegate.onGetSingleMundaneProtectionAsyncTaskFinished(result);
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

    public interface GetSingleMundaneProtectionAsyncTaskFinishedListener
    {
        void onGetSingleMundaneProtectionAsyncTaskFinished(IProtection result);
    }

    public interface GetMundaneProtectionForCurrentPlayerAsyncTaskFinishedListener
    {
        void onGetMundaneProtectionForCurrentPlayerAsyncTaskFinished(List<IProtection> result);
    }

    public interface GetAllMundaneProtectionsAsyncTaskFinishedListener
    {
        void onGetAllMundaneProtectionsAsyncTaskFinished(List<IProtection> result);
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
