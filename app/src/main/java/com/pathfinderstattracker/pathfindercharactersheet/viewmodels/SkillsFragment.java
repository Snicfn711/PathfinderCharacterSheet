package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.SkillRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;

import java.util.Arrays;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SkillsFragment extends Fragment
{

    //region Temp Skills
    private Skill dance = new Skill("Dance", false,5, 5, AbilityScoreEnum.DEX, true);
    private Skill climb = new Skill("Climb", true, 100, 0, AbilityScoreEnum.STR, true);
    private Skill swim = new Skill("Swim", false, 0, 0, AbilityScoreEnum.STR, true);
    private Skill appraise = new Skill("Appraise", true, 3, 2, AbilityScoreEnum.INT, false);
    private Skill ride = new Skill("Ride", true, 15, 3, AbilityScoreEnum.DEX, true);
    private Skill[] TempSkills = new Skill[] {climb, dance, appraise, swim, ride};
    //endregion

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private Animation click;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillsFragment()
    {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SkillsFragment newInstance(int columnCount)
    {
        SkillsFragment fragment = new SkillsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.skill_list_view, container, false);
        Arrays.sort(TempSkills);

        // Set the adapter
        //Todo: This may be a misuse of Recyclerview, since it doesn't check whether the rootView actually is a recycler view. Come back and fix if necessary
        Context context = rootView.getContext();
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final RecyclerView recyclerView = rootView.findViewById(R.id.StatsRecycler);
        final SkillRecyclerViewAdapter skillAdapter = new SkillRecyclerViewAdapter(TempSkills, mListener);
        if (mColumnCount <= 1)
        {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else
        {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        recyclerView.setAdapter(skillAdapter);

        //Get and set our points invested
        TextView skillPointsInvested = rootView.findViewById(R.id.TotalRanks);
        TextView favoredClassPointsInvested = rootView.findViewById(R.id.FavoredClassRanks);
        skillPointsInvested.setText("Total Ranks: " + Integer.toString(GetTotalSkillPointsInvested(TempSkills)));
        favoredClassPointsInvested.setText("Favored Ranks: " + Integer.toString(GetFavoredClassSkillPointsInvested(TempSkills)));

        //Get our buttons and set their onClickListeners
        final ImageButton isClassSkillSortButton = rootView.findViewById(R.id.SortByIsClassSkill);
        final ImageButton sortByRanksButton = rootView.findViewById(R.id.SortByRanks);
        final ImageButton addNewSkillButton = rootView.findViewById(R.id.AddNewSkill);

        isClassSkillSortButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                isClassSkillSortButton.startAnimation(click);
                if(!Skill.checkIfSortedByProficiency(TempSkills))
                {
                    Arrays.sort(TempSkills, Skill.compareByIsClassSkill);
                }
                else
                {
                    Arrays.sort(TempSkills);
                }
                skillAdapter.notifyDataSetChanged();
            }
        });
        sortByRanksButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByRanksButton.startAnimation(click);
                if(!Skill.checkIfSortedByTotalRanks(TempSkills))
                {
                    Arrays.sort(TempSkills, Skill.compareByTotalRanks);
                }
                else
                {
                    Arrays.sort(TempSkills);
                }
                skillAdapter.notifyDataSetChanged();
            }
        });
        addNewSkillButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addNewSkillButton.startAnimation(click);
            }
        });

        return rootView;
    }


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener)
        {
            mListener = (OnListFragmentInteractionListener) context;
        } else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ISkill item);
    }

    private int GetTotalSkillPointsInvested(ISkill[] skillList)
    {
        int skillPoints = 0;
        for(ISkill skill:skillList)
        {
            skillPoints += skill.getPointsInvested();
        }
        return skillPoints;
    }

    private int GetFavoredClassSkillPointsInvested(ISkill[] skillList)
    {
        int skillPoints = 0;
        for(ISkill skill:skillList)
        {
            skillPoints += skill.getFavoredClassPointsInvested();
        }
        return skillPoints;
    }
}
