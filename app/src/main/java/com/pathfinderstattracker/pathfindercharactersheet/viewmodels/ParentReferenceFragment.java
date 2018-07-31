package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathfinderstattracker.pathfindercharactersheet.MainActivity;
import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParentReferenceFragment extends Fragment implements PathfinderRepository.GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener,
                                                                 PathfinderRepository.GetPlayerSkillEntityAsyncTaskFinishedListener,
                                                                 PathfinderRepository.GetSingleArmorAsyncTaskFinishedListener
{
    private ReferenceFragmentAdapter referenceFragmentAdapter;
    private OnFragmentInteractionListener mListener;
    private PathfinderRepository repository;

    private IPlayerCharacter currentPlayerCharacter;
    private ArrayList<PlayerSkillsEntity> currentPlayerSkills;
    private ArrayList<IItem> currentPlayerInventory;
    private int totalInventorySize;

    public ParentReferenceFragment()
    {
        // Required empty public constructor
    }

    public static ParentReferenceFragment newInstance(String param1, String param2)
    {
        ParentReferenceFragment fragment = new ParentReferenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Bundle getPlayerCharacterBundle = getArguments();
        //Initialize the data for our current player character
        currentPlayerSkills = new ArrayList<>();
        currentPlayerInventory = new ArrayList<>();
        currentPlayerCharacter = (PlayerCharacter)getPlayerCharacterBundle.getSerializable("PlayerCharacter");

        totalInventorySize = 0;

        //TODO: Like with MainActivity, we're likely going to be loading a fair amount of data here, so this could potentially use a loading screen.
        repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestPlayerSkillEntity(this, currentPlayerCharacter.getPlayerCharacterID());
        repository.requestPlayerArmors(currentPlayerCharacter.getPlayerCharacterID(),this);

        //Inflate our view, bind and set our adapter and view pager
        View rootView = inflater.inflate(R.layout.parent_reference_fragment, container, false);
        referenceFragmentAdapter = new ReferenceFragmentAdapter(getFragmentManager());
        //By creating our bundle to pass here, we're giving our initial StatsReferenceFragment an empty array of player skills
        //This might seem bad, but since by this point the repository is already fetching their actual skills, we should be getting back our proper skills list before the user can scroll
        //And this way we don't get a null reference in our SkillsReferenceFragment or InventoryReferenceFragment
        referenceFragmentAdapter.setArgs(createBundle());
        ViewPager mViewPager = rootView.findViewById(R.id.referenceFragmentPager);
        mViewPager.setAdapter(referenceFragmentAdapter);

        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //region Database Callback Methods
    @Override
    public void onGetPlayerSkillEntityAsyncTaskFinished(List<PlayerSkillsEntity> result)
    {
        currentPlayerSkills.addAll(result);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    @Override
    public void onGetArmorEntityForCurrentPlayerAsyncTaskFinished(List<PlayerArmorEntity> result)
    {
        totalInventorySize += result.size();
        if(result.size() != 0)
        {
            for (PlayerArmorEntity entity : result)
            {
                repository.requestSingleArmor(entity.getArmorID(), this);
            }
        }
    }

    @Override
    public void onGetSingleArmorAsyncTaskFinished(ArmorEntity result)
    {
        if(result.getArmorType() == ArmorTypesEnum.Armor)
        {
            currentPlayerInventory.add(DatabaseEntityObjectConverter.ConvertArmorEntityToArmorObject(result));
        }
        else if(result.getArmorType() == ArmorTypesEnum.Shield)
        {
            currentPlayerInventory.add(DatabaseEntityObjectConverter.ConvertArmorEntityToShieldObject(result));
        }
        else
        {
            throw new RuntimeException("The current player character has been given an invalid shield or armor");
        }
        if(currentPlayerInventory.size() == totalInventorySize)
        {

            referenceFragmentAdapter.setArgs(createBundle());
            ReloadScreen();
        }
    }
    //endregion

    //region Methods Called by MainActivity
    public void UpdateCharacter(IPlayerCharacter updatedCharacter)
    {
        currentPlayerCharacter = updatedCharacter;
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }
    public void UpdateSkill(PlayerSkillsEntity skillToUpdate)
    {
        for(PlayerSkillsEntity skill : currentPlayerSkills)
        {
            if(skill.getSkillID().equals(skillToUpdate.getSkillID()))
            {
                skill.setLevelUpPointsInvested(skillToUpdate.getLevelUpPointsInvested());
                skill.setFavoredClassPointsInvested(skillToUpdate.getFavoredClassPointsInvested());
            }
        }
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    public void AddCustomSkill(PlayerSkillsEntity skillToAdd)
    {
        currentPlayerSkills.add(skillToAdd);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    public void AddArmor(IProtection armorToUpdate)
    {
        currentPlayerInventory.add(armorToUpdate);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }
    //endregion

    //region Private Methods
    private void ReloadScreen()
    {
        referenceFragmentAdapter.notifyDataSetChanged();
    }

    private Bundle createBundle()
    {
        //We can't maintain a bundle at all times since they end up being too large, causing the application to fail when paused.
        //By recreating the bundle, it only exists for the short period we need it for and then passes out of scope
        //(notice that all of our calls to this createBundle() method don't actually persist the bundle in this class)
        Bundle bundleToPass = new Bundle();
        bundleToPass.putSerializable("PlayerInventory", currentPlayerInventory);
        bundleToPass.putSerializable("PlayerSkillsList", currentPlayerSkills);
        bundleToPass.putSerializable("PlayerCharacter", currentPlayerCharacter);
        return bundleToPass;
    }
    //endregion
}
