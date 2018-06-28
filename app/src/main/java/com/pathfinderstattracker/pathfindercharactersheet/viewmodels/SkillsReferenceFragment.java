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
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.SkillEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SkillForDisplay;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditSkillValuesDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.RollD20Dialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SkillsReferenceFragment extends Fragment implements SkillRecyclerViewAdapter.OnRollSkillCheckButtonClickedListener, SkillRecyclerViewAdapter.OnEditSkillLongClickListener, PathfinderRepository.GetUnformattedSkillsAsyncTaskFinishedListener, PathfinderRepository.GetPlayerSkillEntityAsyncTaskFinishedListener
{
    private OnListFragmentInteractionListener mListener;
    private Animation click;
    private IPlayerCharacter currentPlayerCharacter;
    private PathfinderRepository repository;
    private List<ISkill> currentPlayerCharacterSkills;
    private List<SkillForDisplay> currentPlayerCharacterSkillsForDisplay;
    private SkillRecyclerViewAdapter skillAdapter;
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
            currentPlayerCharacter = (PlayerCharacter)getPlayerCharacter.get("PlayerCharacter");
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
    public void onGetUnformattedSkillsAsyncTaskFinished(List<ISkill> result)
    {
        currentPlayerCharacterSkills = result;
        currentPlayerCharacterSkillsForDisplay = new ArrayList<>();

        for(ISkill skill : currentPlayerCharacterSkills)
        {
            repository.requestPlayerSkillEntity(this,currentPlayerCharacter.getPlayerCharacterID(),skill.getSkillID());
        }
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

    @Override
    public void onGetPlayerSkillEntityAsyncTaskFinished(PlayerSkillsEntity result)
    {
        for(ISkill skill : currentPlayerCharacterSkills)
        {
            if(skill.getSkillID().equals(result.getSkillID()))
            {
                currentPlayerCharacterSkillsForDisplay.add(new SkillForDisplay(result.getSkillID(),
                                                                               skill.getAddedStat(),
                                                                               skill.isArmorCheckPenaltyApplied(),
                                                                               skill.getSkillName(),
                                                                               GetSkillTotalForDisplay(skill,result)));
                skill.setLevelUpPointsInvested(result.getLevelUpPointsInvested());
                skill.setFavoredClassPointsInvested(result.getFavoredClassPointsInvested());
            }
        }

        if(currentPlayerCharacterSkillsForDisplay.size() == currentPlayerCharacterSkills.size())
        {
            // Set the adapter
            Context context = rootView.getContext();
            click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
            final RecyclerView recyclerView = rootView.findViewById(R.id.StatsRecycler);
            skillAdapter = new SkillRecyclerViewAdapter(currentPlayerCharacterSkillsForDisplay, mListener, this);
            recyclerView.setAdapter(skillAdapter);

            //Get and set our points invested
            TextView skillPointsInvested = rootView.findViewById(R.id.TotalRanks);
            TextView favoredClassPointsInvested = rootView.findViewById(R.id.FavoredClassRanks);
            skillPointsInvested.setText(String.format("Total Ranks: %s", Integer.toString(GetTotalSkillPointsInvested(currentPlayerCharacterSkills))));
            favoredClassPointsInvested.setText(String.format("Favored Ranks: %s", Integer.toString(GetFavoredClassSkillPointsInvested(currentPlayerCharacterSkills))));

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
                    //As noted in the Skills object, we're changing where skill points are stored, so we're going to need to change this part once we implement that
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

                if(!Skill.checkIfSortedByTotalRanks(currentPlayerCharacterSkills))
                {
                    Collections.sort(currentPlayerCharacterSkills, Skill.compareByTotalRanks);
                }
                else
                {
                    Collections.sort(currentPlayerCharacterSkills);
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
        }
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
            skillPoints += skill.getLevelUpPointsInvested();
            skillPoints += skill.getFavoredClassPointsInvested();
        }
        return skillPoints;
    }

    private int GetFavoredClassSkillPointsInvested(List<ISkill> skillList)
    {
        int skillPoints = 0;
        for(ISkill skill:skillList)
        {
            skillPoints += skill.getFavoredClassPointsInvested();
        }
        return skillPoints;
    }

    private int GetSkillTotalForDisplay(ISkill skillTotalToCalculate, PlayerSkillsEntity playerSkillsEntityWithPointsInvested)
    {
        AbilityScoreEnum statToCheck = skillTotalToCalculate.getAddedStat();
        int skillTotal = 0;
        if(currentPlayerCharacter != null)
        {
            for (IAbilityScore abilityScore : currentPlayerCharacter.getAbilityScores())
            {
                if(abilityScore.getStat() == statToCheck)
                {
                    skillTotal += abilityScore.calculateModifier();
                }
            }
        }
        skillTotal += playerSkillsEntityWithPointsInvested.getLevelUpPointsInvested();
        skillTotal += playerSkillsEntityWithPointsInvested.getFavoredClassPointsInvested();

        return skillTotal;
    }

    private int GetSkillTotalForDisplay(SkillForDisplay skillTotalToCalculate, PlayerSkillsEntity playerSkillsEntityWithPointsInvested)
    {
        AbilityScoreEnum statToCheck = skillTotalToCalculate.getAddedStat();
        int skillTotal = 0;
        if(currentPlayerCharacter != null)
        {
            for (IAbilityScore abilityScore : currentPlayerCharacter.getAbilityScores())
            {
                if(abilityScore.getStat() == statToCheck)
                {
                    skillTotal += abilityScore.calculateModifier();
                }
            }
        }
        skillTotal += playerSkillsEntityWithPointsInvested.getLevelUpPointsInvested();
        skillTotal += playerSkillsEntityWithPointsInvested.getFavoredClassPointsInvested();

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
        args.putSerializable("CurrentPlayerCharacterID", currentPlayerCharacter.getPlayerCharacterID());
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
                if (resultCode == Activity.RESULT_OK)
                {
                    PlayerSkillsEntity skillEntityFromDialog = (PlayerSkillsEntity)bundle.getSerializable("PlayerSkillEntityToUpdate");

                    int indexToReplace = 0;
                    for(SkillForDisplay temp : currentPlayerCharacterSkillsForDisplay)
                    {
                        if(temp.getSkillID().equals(skillEntityFromDialog.getSkillID()))
                        {
                            indexToReplace = currentPlayerCharacterSkillsForDisplay.indexOf(temp);
                        }
                    }
                    SkillForDisplay updatedSkillForDisplay = new SkillForDisplay(skillEntityFromDialog.getSkillID(),
                                                                                 currentPlayerCharacterSkillsForDisplay.get(indexToReplace).getAddedStat(),
                                                                                 currentPlayerCharacterSkillsForDisplay.get(indexToReplace).isArmorCheckPenaltyApplied(),
                                                                                 currentPlayerCharacterSkillsForDisplay.get(indexToReplace).getSkillName(),
                                                                                 GetSkillTotalForDisplay(currentPlayerCharacterSkillsForDisplay.get(indexToReplace), skillEntityFromDialog));
                    currentPlayerCharacterSkillsForDisplay.remove(indexToReplace);
                    currentPlayerCharacterSkillsForDisplay.add(indexToReplace, updatedSkillForDisplay);
                    skillAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
