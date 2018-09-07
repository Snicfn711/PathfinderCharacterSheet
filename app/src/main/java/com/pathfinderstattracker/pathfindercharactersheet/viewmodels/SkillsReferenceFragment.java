package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
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
import android.widget.Toast;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.SkillRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddCustomSkillDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditSkillValuesDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.RollD20Dialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.UpdateFragmentInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SkillsReferenceFragment extends Fragment implements SkillRecyclerViewAdapter.OnRollSkillCheckButtonClickedListener,
                                                                 SkillRecyclerViewAdapter.OnEditSkillLongClickListener,
                                                                 PathfinderRepository.InsertCustomSkillListener,
                                                                 UpdateFragmentInterface
{
    private SkillRecyclerViewAdapter skillAdapter;
    private PathfinderRepository repository;
    private Animation click;
    private static final int UPDATE_SKILL_POINTS_DIALOG = 1;
    private static final int ADD_CUSTOM_SKILL_DIALOG = 2;

    private IPlayerCharacter currentPlayerCharacter;
    private ArrayList<ISkill> currentPlayerCharacterSkills = new ArrayList<>();
    private ArrayList<ISkill> defaultSkills;
    
    private OnListFragmentInteractionListener mListener;
    private OnSkillsUpdatedListener skillsUpdatedListener;
    private OnCustomSkillAddedListener customSkillAddedListener;
    private OnSkillsDeletedListener skillsDeletedListener;

    public SkillsReferenceFragment()
    {

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
    @SuppressWarnings("unchecked cast")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        repository = new PathfinderRepository(this.getActivity().getApplication());
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            currentPlayerCharacter = (PlayerCharacter)bundle.get("PlayerCharacter");
            if(bundle.containsKey("PlayerSkillsList"))
            {
                currentPlayerCharacterSkills = (ArrayList<ISkill>)bundle.get("PlayerSkillsList");
                Collections.sort(currentPlayerCharacterSkills);
            }
            if(bundle.containsKey("DefaultSkills"))
            {
                defaultSkills = (ArrayList<ISkill>)bundle.get("DefaultSkills");
            }
        }
        View rootView = inflater.inflate(R.layout.skill_fragment_view, container, false);

        // Set the adapter
        Context context = rootView.getContext();
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final RecyclerView recyclerView = rootView.findViewById(R.id.SkillsRecycler);
        skillAdapter = new SkillRecyclerViewAdapter(currentPlayerCharacterSkills, currentPlayerCharacter.getAbilityScores(), mListener, this);
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
                //skillAdapter.notifyDataSetChanged();
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
                OpenAddCustomSkillDialog();
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
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
        if(context instanceof OnSkillsUpdatedListener)
        {
            skillsUpdatedListener = (OnSkillsUpdatedListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                   +" must implement OnSkillsUpdatedListener");
        }
        if(context instanceof OnCustomSkillAddedListener)
        {
            customSkillAddedListener = (OnCustomSkillAddedListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                                               +" must implement OnCustomSkillAddedListener");
        }
        if(context instanceof OnSkillsDeletedListener)
        {
            skillsDeletedListener = (OnSkillsDeletedListener)context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                                               + " must implement OnSkillDeletedListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case UPDATE_SKILL_POINTS_DIALOG:
                if (resultCode == Activity.RESULT_OK)
                {
                    if (data.getExtras().containsKey("UpdatedSkill"))
                    {
                        ISkill updatedSkill = (ISkill)data.getExtras().getSerializable("UpdatedSkill");
                        repository.updateSkill(updatedSkill, currentPlayerCharacter.getPlayerCharacterID());
                        skillsUpdatedListener.onSkillsUpdated(updatedSkill);
                    }
                    else if(data.getExtras().containsKey("DeletedSkill"))
                    {
                        ISkill deletedSkill = (ISkill)data.getExtras().getSerializable("DeletedSkill");
                        repository.deleteCustomSkill(deletedSkill, currentPlayerCharacter.getPlayerCharacterID());
                        skillsDeletedListener.onSkillDeleted(deletedSkill);
                    }

                }
                break;
            case ADD_CUSTOM_SKILL_DIALOG:
                if(resultCode == Activity.RESULT_OK)
                {
                    ISkill customSkillAdded = (ISkill)data.getExtras().getSerializable("CustomSkillAdded");
                    repository.insertCustomSkill(this,customSkillAdded, currentPlayerCharacter.getPlayerCharacterID());
                }
        }
    }

    //region Local Button Listeners
    @Override
    public void onRollSkillCheckButtonPressed(ISkill skillClicked)
    {
        OpenRollD20Dialog("Roll " + skillClicked.getSkillName() + " check", GetSkillTotalScore(currentPlayerCharacter, skillClicked));
    }

    @Override
    public void onEditSkillLongClickActivated(ISkill skillHeld)
    {
        OpenEditSkillsDialog(skillHeld);
    }
    //endregion

    //region Database Callback Methods
    @Override
    public void onInsertCustomSkillAsyncTaskFinished(ISkill insertedPlayerSkill, Exception thrownException)
    {
        if(thrownException instanceof SQLiteConstraintException)
        {
            String toastText = "The Skill " + insertedPlayerSkill.getSkillName() + " Has Already Been Added For This Character";
            Toast.makeText(this.getContext(), toastText, Toast.LENGTH_LONG).show();
        }
        else
        {
            customSkillAddedListener.onCustomSkillAdded(insertedPlayerSkill);
        }
    }

    @Override
    public void Update(Bundle args)
    {
        if(args.containsKey("PlayerSkillsList"))
        {
            currentPlayerCharacterSkills = (ArrayList<ISkill>)args.getSerializable("PlayerSkillsList");
        }
        if(args.containsKey("DefaultSkills"))
        {
            defaultSkills = (ArrayList<ISkill>)args.getSerializable("DefaultSkills");
        }
        if(args.containsKey("PlayerCharacter"))
        {
            currentPlayerCharacter = (IPlayerCharacter)args.getSerializable("PlayerCharacter");
        }
    }
    //endregion

    //region Listener Interfaces
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ISkill item);
    }

    public interface OnSkillsUpdatedListener
    {
        void onSkillsUpdated(ISkill skillToUpdate);
    }

    public interface OnCustomSkillAddedListener
    {
        void onCustomSkillAdded(ISkill skillToAdd);
    }

    public interface OnSkillsDeletedListener
    {
        void onSkillDeleted(ISkill skillToDelete);
    }
    //endregion

    //region Private Methods
    private static int GetSkillTotalScore(IPlayerCharacter currentPlayerCharacter, ISkill playerSkillsWithPointsInvested)
    {
        AbilityScoreEnum statToCheck = playerSkillsWithPointsInvested.getAddedStat();
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
        skillTotal += playerSkillsWithPointsInvested.getLevelUpPointsInvested();
        skillTotal += playerSkillsWithPointsInvested.getFavoredClassPointsInvested();

        return skillTotal;
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

    private void OpenEditSkillsDialog(ISkill skillHeld)
    {
        Bundle args = new Bundle();
        Boolean isCustomSkill = true;

        for(ISkill defaultSkill : defaultSkills)
        {
            if(skillHeld.getSkillID().equals(defaultSkill.getSkillID()))
            {
                isCustomSkill = false;
            }
        }

        args.putSerializable("CurrentSkill", skillHeld);
        args.putBoolean("isCustomSkill", isCustomSkill);

        EditSkillValuesDialog editSkillValuesDialog = new EditSkillValuesDialog();
        editSkillValuesDialog.setTargetFragment(this, UPDATE_SKILL_POINTS_DIALOG);
        editSkillValuesDialog.setArguments(args);
        editSkillValuesDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        editSkillValuesDialog.show(this.getFragmentManager(), "Edit Skill Values");
    }

    private void OpenAddCustomSkillDialog()
    {
        Bundle args = new Bundle();
        AddCustomSkillDialog addCustomSkillDialog = new AddCustomSkillDialog();
        addCustomSkillDialog.setArguments(args);
        addCustomSkillDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        addCustomSkillDialog.setTargetFragment(this, ADD_CUSTOM_SKILL_DIALOG);
        addCustomSkillDialog.show(this.getFragmentManager(),"Add Custom Skill");
    }
    //endregion
}
