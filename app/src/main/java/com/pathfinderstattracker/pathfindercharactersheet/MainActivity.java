package com.pathfinderstattracker.pathfindercharactersheet;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderDatabase;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_daos.PlayerCharacterDao;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.tools.DatabaseInitializer;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.ParentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;

import java.util.UUID;
import java.util.List;

public class MainActivity extends FragmentActivity implements StatsReferenceFragment.OnFragmentInteractionListener, SkillsReferenceFragment.OnListFragmentInteractionListener, EquipmentReferenceFragment.OnListFragmentInteractionListener, SpellReferenceFragment.OnListFragmentInteractionListener, InventoryReferenceFragment.OnListFragmentInteractionListener, AbilityReferenceFragment.OnListFragmentInteractionListener, PlayerCharacterListFragment.OnListFragmentInteractionListener, ParentReferenceFragment.OnFragmentInteractionListener, PathfinderRepositoryListener
{
    PathfinderRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new PathfinderRepository(this.getApplication());
        Fragment characterListFragment = new PlayerCharacterListFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.MainActivity, characterListFragment).commit();
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

    public void AddNewCharacter()
    {
        IPlayerCharacter newPlayerCharacter = PlayerCharacter.CreateDefaultPlayerCharacterWithID(UUID.randomUUID());
        Bundle bundle = new Bundle();
        bundle.putSerializable("PlayerCharacter", newPlayerCharacter);
        repository.insertPlayerCharacter(newPlayerCharacter);
        Fragment parentReferenceFragment = new ParentReferenceFragment();
        parentReferenceFragment.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.PlayerChracterListFragment, parentReferenceFragment).commit();
    }

    @Override
    public void findCharacterProcessFinished(IPlayerCharacter playerCharacter)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("PlayerCharacter", playerCharacter);
        Fragment parentReferenceFragment = new ParentReferenceFragment();
        parentReferenceFragment.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.PlayerChracterListFragment, parentReferenceFragment).commit();
    }

    @Override
    public void getCharacterNamesAndIDsProcessFinished(List<PlayerCharacterNameAndIDEntity> playerCharacterNamesAndIDs)
    {
        //Required method inherited from PathfinderRepositoryListener that doesn't do anything here.
        //It's a code smell, but it works for now
        //TODO:Figure out how to properly use our PathfinderRepositoryListener
    }

    @Override
    public void updateCharacterFinished(PlayerCharacter playerCharacter)
    {
        //Required method inherited from PathfinderRepositoryListener that doesn't do anything here.
        //It's a code smell, but it works for now
        //TODO:Figure out how to properly use our PathfinderRepositoryListener
    }
}
