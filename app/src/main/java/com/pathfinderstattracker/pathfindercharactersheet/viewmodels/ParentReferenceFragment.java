package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParentReferenceFragment extends Fragment implements PathfinderRepository.GetMundaneProtectionForCurrentPlayerAsyncTaskFinishedListener,
                                                                 PathfinderRepository.GetPlayerSkillsAsyncTaskFinishedListener
{
    private ReferenceFragmentAdapter referenceFragmentAdapter;
    private OnFragmentInteractionListener mListener;
    private PathfinderRepository repository;

    private IPlayerCharacter currentPlayerCharacter;
    private ArrayList<ISkill> currentPlayerSkills;
    private ArrayList<IItem> currentPlayerInventory;
    private ArrayList<ISkill> defaultSkills;
    private ArrayList<IEquipment> currentlyEquippedItems;
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

        Bundle getPlayerCharacterBundle = getArguments();
        //Initialize the data for our current player character
        currentPlayerSkills = new ArrayList<>();
        currentPlayerInventory = new ArrayList<>();
        currentlyEquippedItems = new ArrayList<>();
        currentPlayerCharacter = (PlayerCharacter)getPlayerCharacterBundle.getSerializable("PlayerCharacter");
        defaultSkills = (ArrayList<ISkill>)getPlayerCharacterBundle.getSerializable("DefaultSkillsList");

        //TODO: Like with MainActivity, we're likely going to be loading a fair amount of data here, so this could potentially use a loading screen.
        repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestPlayerSkills(this, currentPlayerCharacter.getPlayerCharacterID());
        repository.requestMundaneProtectionForPlayer(currentPlayerCharacter.getPlayerCharacterID(),this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
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
    public void onGetPlayerSkillsAsyncTaskFinished(List<ISkill> result)
    {
        currentPlayerSkills.addAll(result);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    @Override
    public void onGetMundaneProtectionForCurrentPlayerAsyncTaskFinished(List<IProtection> result)
    {
        currentPlayerInventory.addAll(result);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }
    //endregion

    //region Methods Called by MainActivity
    public void UpdateCharacter(IPlayerCharacter updatedCharacter)
    {
        currentPlayerCharacter = updatedCharacter;
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    public void UpdateSkill(ISkill skillToUpdate)
    {
        for(ISkill skill : currentPlayerSkills)
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

    public void AddCustomSkill(ISkill skillToAdd)
    {
        currentPlayerSkills.add(skillToAdd);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    public void AddMundaneProtection(IProtection armorToUpdate)
    {
        currentPlayerInventory.add(armorToUpdate);
        referenceFragmentAdapter.setArgs(createBundle());
        ReloadScreen();
    }

    public void DeleteSkill(ISkill skillToDelete)
    {
        for(Iterator<ISkill> iterator = currentPlayerSkills.iterator(); iterator.hasNext();)
        {
            ISkill skillToCheck = iterator.next();
            if(skillToCheck.getSkillID().equals(skillToDelete.getSkillID()))
            {
                iterator.remove();
            }
        }
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
        bundleToPass.putSerializable("DefaultSkills", defaultSkills);
        bundleToPass.putSerializable("CurrentlyEquippedItems", currentlyEquippedItems);
        return bundleToPass;
    }
    //endregion
}
