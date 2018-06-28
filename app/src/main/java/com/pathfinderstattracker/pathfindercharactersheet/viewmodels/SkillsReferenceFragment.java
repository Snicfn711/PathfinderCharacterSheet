package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
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
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SkillForDisplay;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditSkillValuesDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.RollD20Dialog;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SkillsReferenceFragment extends Fragment implements PathfinderRepositoryListener, SkillRecyclerViewAdapter.OnRollSkillCheckButtonClickedListener, SkillRecyclerViewAdapter.OnEditSkillLongClickListener
{
    private OnListFragmentInteractionListener mListener;
    private Animation click;
    private IPlayerCharacter playerCharacter;
    PathfinderRepository repository;
    private View rootView;
    private static final int UPDATE_SKILL_POINTS_DIALOG = 1;

    public SkillsReferenceFragment()
    {
        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @SuppressWarnings("unused")
    public static SkillsReferenceFragment newInstance(int columnCount)
    {
        SkillsReferenceFragment fragment = new SkillsReferenceFragment();
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
        Bundle getPlayerCharacter = this.getArguments();
        if(getPlayerCharacter != null)
        {
            playerCharacter = (PlayerCharacter)getPlayerCharacter.get("PlayerCharacter");
        }
        rootView = inflater.inflate(R.layout.skill_fragment_view, container, false);
        repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestSkills(this);

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

    @Override
    public void findCharacterProcessFinished(IPlayerCharacter playerCharacter)
    {
        //Required method inherited from PathfinderRepositoryListener that doesn't do anything here.
        //It's a code smell, but it works for now
        //TODO:Figure out how to properly use our PathfinderRepositoryListener
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

    @Override
    public void getPlayerSkillEntityTaskFinished(PlayerSkillsEntity result)
    {
        //Required method inherited from PathfinderRepositoryListener that doesn't do anything here.
        //It's a code smell, but it works for now
        //TODO:Figure out how to properly use our PathfinderRepositoryListener
    }

    @Override
    public void initializePlayerSkillsTaskFinished()
    {
        //Required method inherited from PathfinderRepositoryListener that doesn't do anything here.
        //It's a code smell, but it works for now
        //TODO:Figure out how to properly use our PathfinderRepositoryListener
    }

    @Override
    public void getUnformattedSkillsTaskFinished(List<ISkill> result)
    {
        List<ISkill> skillsList = result;
        List<SkillForDisplay> skillsForDisplay = new ArrayList<>();

        for(ISkill skill : skillsList)
        {
            SkillForDisplay temp = new SkillForDisplay(skill.getSkillID(),
                                                       skill.getAddedStat(),
                                                       skill.isArmorCheckPenaltyApplied(),
                                                       skill.getSkillName(),
                                                       GetSkillTotalForDisplay(skill));
            skillsForDisplay.add(temp);
        }
        // Set the adapter
        Context context = rootView.getContext();
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final RecyclerView recyclerView = rootView.findViewById(R.id.StatsRecycler);
        final SkillRecyclerViewAdapter skillAdapter = new SkillRecyclerViewAdapter(skillsForDisplay, mListener, this);
        recyclerView.setAdapter(skillAdapter);

        //Get and set our points invested
        TextView skillPointsInvested = rootView.findViewById(R.id.TotalRanks);
        TextView favoredClassPointsInvested = rootView.findViewById(R.id.FavoredClassRanks);
        skillPointsInvested.setText(String.format("Total Ranks: %s", Integer.toString(GetTotalSkillPointsInvested(skillsList))));
        favoredClassPointsInvested.setText(String.format("Favored Ranks: %s", Integer.toString(GetFavoredClassSkillPointsInvested(skillsList))));

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
                  //As noted in the Skills object, we're changing where skill points are stored, so we're going to need to changed this part once we implement that
//                if(!Skill.checkIfSortedByProficiency(TempSkills))
//                {
//                    Collections.sort(TempSkills, Skill.compareByIsClassSkill);
//                }
//                else
//                {
//                    Collections.sort(TempSkills);
//                }
                skillAdapter.notifyDataSetChanged();
            }
        });
        sortByRanksButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByRanksButton.startAnimation(click);
                  //As noted in the Skills object, we're changing where skill points are stored, so we're going to need to changed this part once we implement that
//                if(!Skill.checkIfSortedByTotalRanks(TempSkills))
//                {
//                    Collections.sort(TempSkills, Skill.compareByTotalRanks);
//                }
//                else
//                {
//                    Collections.sort(TempSkills);
//                }
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
    }

    @Override
    public void onRollSkillCheckButtonPressed(SkillForDisplay skillClicked)
    {
        OpenRollD20Dialog("Roll " + skillClicked.getSkillName() + " check", skillClicked.getTotalSkillScore());
    }

    @Override
    public void onEditSkillLongClickActivated(SkillForDisplay skillHeld)
    {
        OpenEditSkillsDialog(skillHeld);
    }


    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(SkillForDisplay item);
    }

    private int GetTotalSkillPointsInvested(List<ISkill> skillList)
    {
        int skillPoints = 0;
        for(ISkill skill:skillList)
        {
            //As noted in the Skills object, we're changing where skill points are stored, so we're going to need to changed this part once we implement that
            //skillPoints += skill.getPointsInvested();
        }
        return skillPoints;
    }

    private int GetFavoredClassSkillPointsInvested(List<ISkill> skillList)
    {
        int skillPoints = 0;
        for(ISkill skill:skillList)
        {
            //As noted in the Skills object, we're changing where skill points are stored, so we're going to need to changed this part once we implement that
           //skillPoints += skill.getFavoredClassPointsInvested();
        }
        return skillPoints;
    }

    private int GetSkillTotalForDisplay(ISkill skillTotalToCalculate)
    {
        AbilityScoreEnum statToCheck = skillTotalToCalculate.getAddedStat();
        int skillTotal = 0;
        if(playerCharacter != null)
        {
            for (IAbilityScore abilityScore : playerCharacter.getAbilityScores())
            {
                if(abilityScore.getStat() == statToCheck)
                {
                    skillTotal += abilityScore.calculateModifier();
                }
            }
        }
        //Since we still haven't implemented point investments, for now all that gets returned is the characters stat modifier
        return skillTotal;
    }

    private void OpenRollD20Dialog(String titleText, int addedValue)
    {
        Bundle args = new Bundle();
        args.putString("TitleText", titleText);
        args.putInt("AddedValue", addedValue);

        RollD20Dialog rollD20Dialog = new RollD20Dialog();
        rollD20Dialog.setArguments(args);
        rollD20Dialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        rollD20Dialog.show(this.getFragmentManager(), "Roll a d20");
    }

    private void OpenEditSkillsDialog(SkillForDisplay skillHeld)
    {
        Bundle args = new Bundle();
        args.putSerializable("CurrentSkillID", skillHeld.getSkillID());
        args.putSerializable("CurrentPlayerCharacterID", playerCharacter.getPlayerCharacterID());
        EditSkillValuesDialog editSkillValuesDialog = new EditSkillValuesDialog();
        editSkillValuesDialog.setTargetFragment(this, UPDATE_SKILL_POINTS_DIALOG);
        editSkillValuesDialog.setArguments(args);
        editSkillValuesDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        editSkillValuesDialog.show(this.getFragmentManager(), "Edit Skill Values");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle bundle = data.getExtras();
        switch(requestCode)
        {
            case UPDATE_SKILL_POINTS_DIALOG:
                if (resultCode == Activity.RESULT_OK) {
                    PlayerSkillsEntity playerSkillEntityToUpdate = (PlayerSkillsEntity) bundle.getSerializable("PlayerSkillEntityToUpdate");
                    repository.updatePlayerSkillEntity(playerSkillEntityToUpdate);
                }
                break;
        }
    }
}
