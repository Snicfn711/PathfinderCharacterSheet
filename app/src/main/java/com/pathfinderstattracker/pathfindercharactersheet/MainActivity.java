package com.pathfinderstattracker.pathfindercharactersheet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SkillForDisplay;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddItemToInventoryDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditSkillValuesDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.RollD20Dialog;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AddArmorToInventoryFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.ParentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class MainActivity extends FragmentActivity implements StatsReferenceFragment.OnFragmentInteractionListener,
                                                              SkillsReferenceFragment.OnListFragmentInteractionListener,
                                                              EquipmentReferenceFragment.OnListFragmentInteractionListener,
                                                              SpellReferenceFragment.OnListFragmentInteractionListener,
                                                              InventoryReferenceFragment.OnListFragmentInteractionListener,
                                                              AbilityReferenceFragment.OnListFragmentInteractionListener,
                                                              PlayerCharacterListFragment.OnListFragmentInteractionListener,
                                                              ParentReferenceFragment.OnFragmentInteractionListener,
                                                              StatsReferenceFragment.OnPlayerCharacterUpdatedListener,
                                                              PathfinderRepository.FindPlayerCharacterAsyncTaskFinishedListener,
                                                              PathfinderRepository.GetDefaultSkillsAsyncTaskFinishedListener,
                                                              SkillsReferenceFragment.OnSkillsUpdatedListener,
                                                              AddArmorToInventoryFragment.OnListFragmentInteractionListener,
                                                              InventoryReferenceFragment.OnPlayerArmorAddedListener,
                                                              PathfinderRepository.GetAllArmorsAsyncTaskFinishedListener,
                                                              PathfinderRepository.InitializePlayerSkillsAsyncTaskFinishedListener
{
    private PathfinderRepository repository;
    private ArrayList<ISkill> defaultSkillList;
    private ArrayList<IProtection> defaultArmorList;
    private Bundle bundle; //This bundle is for all of our non-character specific data(i.e. Default Skills, Default Armor, etc).

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //TODO:This is likely where we're going to end up loading a fair amount of default data should get some kind of loading screen later on
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new PathfinderRepository(this.getApplication());
        Fragment characterListFragment = new PlayerCharacterListFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.MainActivity, characterListFragment).commit();
        repository.requestSkills(this);
        repository.requestArmors(this);
    }

    //region Fragment Interaction Listeners
    @Override
    public void onListFragmentInteraction(IPlayerCharacter item)
    {
        if(item == null)
        {
            AddNewCharacter();
        }
        else
        {
            repository.requestPlayerCharacterByID(item.getPlayerCharacterID(),this);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onListFragmentInteraction(SkillForDisplay item)
    {

    }


    @Override
    public void onListFragmentInteraction(IEquipment item)
    {

    }

    @Override
    public void onListFragmentInteraction(ISpell item)
    {

    }

    @Override
    public void onListFragmentInteraction(IItem item)
    {

    }

    @Override
    public void onListFragmentInteraction(IAbility item)
    {

    }

    @Override
    public void onListFragmentInteraction(IProtection item)
    {

    }
    //endregion

    public void AddNewCharacter()
    {
        IPlayerCharacter newPlayerCharacter = PlayerCharacter.CreateDefaultPlayerCharacterWithID(UUID.randomUUID());
        repository.insertNewPlayerCharacter(newPlayerCharacter);
        repository.initializePlayerSkill(this, newPlayerCharacter, defaultSkillList);

        bundle.putSerializable("PlayerCharacter", newPlayerCharacter);
    }

    @Override
    public void onPlayerCharacterUpdated(IPlayerCharacter playerCharacter)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.UpdateCharacter(playerCharacter);
    }

    @Override
    public void onFindPlayerCharacterAsyncTaskFinished(IPlayerCharacter playerCharacter)
    {
        bundle = new Bundle();
        bundle.putSerializable("PlayerCharacter", playerCharacter);
        moveToParentReferenceScreen();
    }

    //region Database Callback Methods
    @Override
    public void onGetDefaultSkillsAsyncTaskFinished(List<ISkill> result)
    {
        //We're converting to an ArrayList since it's serializable, and the alternative is mucking about with ISkill to make it parcelable
        defaultSkillList = new ArrayList<>();
        defaultSkillList.addAll(result);
        if(bundle == null || bundle.isEmpty())
        {
            bundle = new Bundle();
        }
        bundle.putSerializable("DefaultSkills", defaultSkillList);
    }

    @Override
    public void onGetAllArmorsAsyncTaskFinished(List<ArmorEntity> result)
    {
        defaultArmorList = new ArrayList<IProtection>();
        for(ArmorEntity entity : result)
        {
            if(entity.getArmorType() == ArmorTypesEnum.Armor)
            {
                defaultArmorList.add(DatabaseEntityObjectConverter.ConvertArmorEntityToArmorObject(entity));
            }
            else if(entity.getArmorType() == ArmorTypesEnum.Shield)
            {
                defaultArmorList.add(DatabaseEntityObjectConverter.ConvertArmorEntityToShieldObject(entity));
            }
        }
        if(bundle == null || bundle.isEmpty())
        {
            bundle = new Bundle();
        }
        bundle.putSerializable("DefaultArmors", defaultArmorList);
    }

    @Override
    public void onInitializePlayerSkillsAsyncTaskFinished()
    {
        moveToParentReferenceScreen();
    }
    //endregion

    @Override
    public void onSkillsUpdated(PlayerSkillsEntity skillToUpdate)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.UpdateSkill(skillToUpdate);
    }

    @Override
    public void onPlayerArmorAdded(IProtection armorItemUpdated)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.AddArmor(armorItemUpdated);
    }

    private void moveToParentReferenceScreen()
    {
        Fragment parentReferenceFragment = new ParentReferenceFragment();
        parentReferenceFragment.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.PlayerChracterListFragment, parentReferenceFragment, "ParentReferenceFragment").commit();
    }
}
