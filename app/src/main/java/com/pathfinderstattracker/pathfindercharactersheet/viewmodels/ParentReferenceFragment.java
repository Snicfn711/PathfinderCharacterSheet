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
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;

import java.util.ArrayList;
import java.util.List;

public class ParentReferenceFragment extends Fragment implements PathfinderRepository.GetArmorEntityForCurrentPlayerAsyncTaskFinishedListener,
                                                                 PathfinderRepository.GetPlayerSkillEntityAsyncTaskFinishedListener
{
    private ReferenceFragmentAdapter referenceFragmentAdapter;
    private ViewPager mViewPager;
    private PathfinderRepository repository;
    private Bundle bundle;
    private IPlayerCharacter currentPlayerCharacter;
    private ArrayList<PlayerSkillsEntity> currentPlayerSkills;
    private ArrayList<IProtection> currentPlayerArmor;

    private OnFragmentInteractionListener mListener;

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
        bundle = getArguments();
        //Initialize the data for our current player character
        currentPlayerSkills = new ArrayList<>();
        currentPlayerArmor = new ArrayList<>();
        currentPlayerCharacter = (PlayerCharacter)bundle.getSerializable("PlayerCharacter");

        //TODO: Like with MainActivity, we're likely going to be loading a fair amount of data here, so this could potentially use a loading screen.
        repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestPlayerSkillEntity(this, currentPlayerCharacter.getPlayerCharacterID());
        repository.requestPlayerArmors(currentPlayerCharacter.getPlayerCharacterID(),this);

        //Inflate our view, bind and set our adapter and view pager
        View rootView = inflater.inflate(R.layout.parent_reference_fragment, container, false);
        referenceFragmentAdapter = new ReferenceFragmentAdapter(getFragmentManager());
        referenceFragmentAdapter.setArgs(bundle);
        mViewPager = rootView.findViewById(R.id.referenceFragmentPager);
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

    //region Database Callback Methods
    @Override
    public void onGetArmorEntityForCurrentPlayerAsyncTaskFinished(List<PlayerArmorEntity> result)
    {

    }

    @Override
    public void onGetPlayerSkillEntityAsyncTaskFinished(List<PlayerSkillsEntity> result)
    {
        currentPlayerSkills.addAll(result);
        bundle.putSerializable("PlayerSkillsList", currentPlayerSkills);
    }
    //endregion

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void UpdateCharacter(IPlayerCharacter updatedCharacter)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("PlayerCharacter", updatedCharacter);
        referenceFragmentAdapter.setArgs(bundle);
        referenceFragmentAdapter.notifyDataSetChanged();
    }

    public void ReloadScreen()
    {
        referenceFragmentAdapter.notifyDataSetChanged();
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
        bundle.remove("PlayerSkillsList");
        bundle.putSerializable("PlayerSkillsList", currentPlayerSkills);
        ReloadScreen();
    }
}
