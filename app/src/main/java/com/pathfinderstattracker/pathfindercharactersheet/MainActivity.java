package com.pathfinderstattracker.pathfindercharactersheet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AddArmorToInventoryFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.ParentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends FragmentActivity implements StatsReferenceFragment.OnFragmentInteractionListener,
                                                              SkillsReferenceFragment.OnListFragmentInteractionListener,
                                                              EquipmentReferenceFragment.OnListFragmentInteractionListener,
                                                              SpellReferenceFragment.OnListFragmentInteractionListener,
                                                              InventoryReferenceFragment.OnListFragmentInteractionListener,
                                                              AbilityReferenceFragment.OnListFragmentInteractionListener,
                                                              PlayerCharacterListFragment.OnListFragmentInteractionListener,
                                                              ParentReferenceFragment.OnFragmentInteractionListener,
                                                              StatsReferenceFragment.OnPlayerCharacterUpdatedListener,
                                                              PathfinderRepository.GetPlayerCharacterAsyncTaskFinishedListener,
                                                              PathfinderRepository.GetDefaultSkillsAsyncTaskFinishedListener,
                                                              SkillsReferenceFragment.OnSkillsUpdatedListener,
                                                              AddArmorToInventoryFragment.OnListFragmentInteractionListener,
                                                              InventoryReferenceFragment.OnMundaneProtectionAddedToPlayerInventoryListener,
                                                              PathfinderRepository.GetAllMundaneProtectionsAsyncTaskFinishedListener,
                                                              PathfinderRepository.InitializePlayerSkillsAsyncTaskFinishedListener,
                                                              SkillsReferenceFragment.OnCustomSkillAddedListener,
                                                              SkillsReferenceFragment.OnSkillsDeletedListener
{
    private PathfinderRepository repository;
    private ArrayList<ISkill> defaultSkillList;
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
        repository.requestMundaneProtections(this);
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
    public void onListFragmentInteraction(ISkill item)
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

    //region Character Update Listeners
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
    public void onSkillsUpdated(ISkill skillToUpdate)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.UpdateSkill(skillToUpdate);
    }

    @Override
    public void onMundaneProtectionAddedToPlayerInventory(IProtection protectionToAddToInventory)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.AddMundaneProtection(protectionToAddToInventory);
    }

    @Override
    public void onCustomSkillAdded(ISkill skillToAdd)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.AddCustomSkill(skillToAdd);
    }

    @Override
    public void onSkillDeleted(ISkill skillToDelete)
    {
        ParentReferenceFragment parentReferenceFragment = (ParentReferenceFragment)getSupportFragmentManager().findFragmentByTag("ParentReferenceFragment");
        parentReferenceFragment.DeleteSkill(skillToDelete);
    }
    //endregion

    //region Database Callback Methods
    @Override
    public void onGetPlayerCharacterAsyncTaskFinished(IPlayerCharacter playerCharacter)
    {
        bundle.putSerializable("PlayerCharacter", playerCharacter);
        moveToParentReferenceScreen();
    }

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
        bundle.putSerializable("DefaultSkillsList", defaultSkillList);
        //We used to stick our default skills in the bundle, however we don't actually need to do that, and we want to keep the size of the bundle down(it has a maximum size of 1MB)
    }

    @Override
    public void onGetAllMundaneProtectionsAsyncTaskFinished(List<IProtection> result)
    {
        ArrayList<IProtection> defaultMundaneProtectionList = new ArrayList<IProtection>();
        if(bundle == null || bundle.isEmpty())
        {
            bundle = new Bundle();
        }
        bundle.putSerializable("DefaultMundaneProtection", defaultMundaneProtectionList);
    }

    @Override
    public void onInitializePlayerSkillsAsyncTaskFinished()
    {
        moveToParentReferenceScreen();
    }
    //endregion

    private void moveToParentReferenceScreen()
    {
        Fragment parentReferenceFragment = new ParentReferenceFragment();
        parentReferenceFragment.setArguments(bundle);
        //We're clearing out our bundle so that when the application is paused it doesn't give a "TransactionTooLargeError"
        bundle = null;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.PlayerCharacterListFragment, parentReferenceFragment, "ParentReferenceFragment").commit();
    }

}
