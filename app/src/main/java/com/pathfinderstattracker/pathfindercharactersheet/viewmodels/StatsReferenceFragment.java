package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddNameDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditAbilityScoresDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.RollD20Dialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.UpdateFragmentInterface;
import com.pathfinderstattracker.pathfindercharactersheet.views.ACReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.CombatManeuverReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.HP_BAB_ReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.InitiativeReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.MovementReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.SavesReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.AbilityScoreReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.SpellResistanceReferenceBlockView;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatsReferenceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatsReferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class StatsReferenceFragment extends Fragment implements UpdateFragmentInterface
{
    private PathfinderRepository repository;
    private OnFragmentInteractionListener mListener;
    private OnPlayerCharacterUpdatedListener playerCharacterUpdatedListener;
    private Animation click;

    private IPlayerCharacter currentPlayerCharacter;

    //Used later in the code to determine which dialog is returning data to this fragment
    private static final int ADD_NEW_CHARACTER_NAME_DIALOG = 1;
    private static final int UPDATE_ABILITY_SCORES_DIALOG = 2;

    private MovementReferenceBlockView movementView;
    private AbilityScoreReferenceBlockView statsView;
    private InitiativeReferenceBlockView initiativeView;
    private CombatManeuverReferenceBlockView combatManeuverView;
    private SavesReferenceBlockView savesView;
    private ACReferenceBlockView armorView;
    private HP_BAB_ReferenceBlockView hp_BAB_SRView;
    SpellResistanceReferenceBlockView spellResistanceReferenceBlockView;

    public StatsReferenceFragment()
    {
        // Required empty public constructor
    }

    public static StatsReferenceFragment newInstance(String param1, String param2)
    {
        StatsReferenceFragment fragment = new StatsReferenceFragment();
        Bundle args = new Bundle();
        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        click = AnimationUtils.loadAnimation(this.getContext(), R.anim.roll_button_click);
        repository = new PathfinderRepository(this.getActivity().getApplication());

        Bundle getPlayerCharacterBundle = getArguments();
        currentPlayerCharacter =  (PlayerCharacter)getPlayerCharacterBundle.getSerializable("PlayerCharacter");

        if(currentPlayerCharacter.getPlayerCharacterName() == null || currentPlayerCharacter.getPlayerCharacterName().isEmpty())
        {
            AddNameDialog getNameDialog = new AddNameDialog();
            getNameDialog.setTargetFragment(this, ADD_NEW_CHARACTER_NAME_DIALOG);
            getNameDialog.setStyle(DialogFragment.STYLE_NO_TITLE,0);
            getNameDialog.show(this.getFragmentManager(),"Add Player Character Name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.stats_screen_fragment_view, container, false);

        //region Create and set our View Adapters

        //Populate and bind our stats list
        statsView = rootView.findViewById(R.id.statsList);

        final ImageButton editStatsButton = statsView.findViewById(R.id.EditStatsButton);
        final ImageButton rollStrength = statsView.findViewById(R.id.RollStrengthCheck);
        final ImageButton rollDexterity = statsView.findViewById(R.id.RollDexterityCheck);
        final ImageButton rollConstitution = statsView.findViewById(R.id.RollConstitutionCheck);
        final ImageButton rollIntelligence = statsView.findViewById(R.id.RollIntelligenceCheck);
        final ImageButton rollWisdom = statsView.findViewById(R.id.RollWisdomCheck);
        final ImageButton rollCharisma = statsView.findViewById(R.id.RollCharismaCheck);

        editStatsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editStatsButton.startAnimation(click);
                OpenEditAbilityScoresDialog();
            }
        });

        rollStrength.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollStrength.startAnimation(click);
                OpenRollD20Dialog("Roll Strength Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.STR).calculateModifier());
            }
        });
        rollDexterity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollDexterity.startAnimation(click);
                OpenRollD20Dialog("Roll Dexterity Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.DEX).calculateModifier());
            }
        });
        rollConstitution.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollConstitution.startAnimation(click);
                OpenRollD20Dialog("Roll Constitution Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.CON).calculateModifier());
            }
        });
        rollIntelligence.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollIntelligence.startAnimation(click);
                OpenRollD20Dialog("Roll Intelligence Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.INT).calculateModifier());
            }
        });
        rollWisdom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollWisdom.startAnimation(click);
                OpenRollD20Dialog("Roll Wisdom Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.WIS).calculateModifier());
            }
        });
        rollCharisma.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollCharisma.startAnimation(click);
                OpenRollD20Dialog("Roll Charisma Check", currentPlayerCharacter.GetStat(AbilityScoreEnum.CHA).calculateModifier());
            }
        });

        //Populate and bind our movement list
        movementView = rootView.findViewById(R.id.movementList);

        //Populate and bind our initiative section
        initiativeView = rootView.findViewById(R.id.initiativeList);
        final ImageButton rollInitiative = initiativeView.findViewById(R.id.RollInitiative);
        rollInitiative.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollInitiative.startAnimation(click);
                OpenRollD20Dialog("Roll Initiative", currentPlayerCharacter.getInitiative());
            }
        });

        //Populate and bind our combat Maneuver list
        combatManeuverView = rootView.findViewById(R.id.combatManeuverList);
        final ImageButton rollCombatManeuver = combatManeuverView.findViewById(R.id.RollCombatManeuver);
        rollCombatManeuver.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollCombatManeuver.startAnimation(click);
                OpenRollD20Dialog("Roll Combat Maneuver Check", currentPlayerCharacter.getCombatManeuverStats().getCombatManeuverCheck());
            }
        });

        //Populate and bind our saves list
        savesView = rootView.findViewById(R.id.savesList);
        final ImageButton rollFortitudeSave = savesView.findViewById(R.id.RollFortSave);
        final ImageButton rollReflexSave = savesView.findViewById(R.id.RollReflexSave);
        final ImageButton rollWillSave = savesView.findViewById(R.id.RollWillSave);

        rollFortitudeSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollFortitudeSave.startAnimation(click);
                OpenRollD20Dialog("Roll Fortitude Save", currentPlayerCharacter.getFortitudeSave());
            }
        });

        rollReflexSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollReflexSave.startAnimation(click);
                OpenRollD20Dialog("Roll Reflex Save", currentPlayerCharacter.getReflexSave());
            }
        });

        rollWillSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollWillSave.startAnimation(click);
                OpenRollD20Dialog("Roll Will Save", currentPlayerCharacter.getWillSave());
            }
        });

        //Populate and bind our AC list
        armorView = rootView.findViewById(R.id.armorList);

        //Populate and bind our HP, BAB, SR section
        hp_BAB_SRView = rootView.findViewById(R.id.hp_bab_srList);
        spellResistanceReferenceBlockView = rootView.findViewById(R.id.spellResistanceView);
        //endregion

        BindViews();

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri)
    {
        if (mListener != null)
        {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        if(context instanceof OnPlayerCharacterUpdatedListener)
        {
            playerCharacterUpdatedListener = (OnPlayerCharacterUpdatedListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnPlayerCharacterUpdatedListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case ADD_NEW_CHARACTER_NAME_DIALOG:
                if (resultCode == Activity.RESULT_OK)
                {
                    String newPlayerCharacterName = (String) data.getExtras().getSerializable("NewPlayerCharacterName");
                    currentPlayerCharacter.setPlayerCharacterName(newPlayerCharacterName);
                }
                break;
            case UPDATE_ABILITY_SCORES_DIALOG:
                if (resultCode == Activity.RESULT_OK)
                {
                    List<IAbilityScore> updatedAbilityScores = (List<IAbilityScore>)  data.getExtras().getSerializable("UpdatedAbilityScores");
                    currentPlayerCharacter.setAbilityScores(updatedAbilityScores);
                }
                break;
        }
        repository.updatePlayerCharacter(currentPlayerCharacter);
        playerCharacterUpdatedListener.onPlayerCharacterUpdated(currentPlayerCharacter);
    }

    //region Open Dialog Methods
    private void OpenEditAbilityScoresDialog()
    {
        Bundle args = new Bundle();
        args.putSerializable("CurrentAbilityScores", (Serializable)currentPlayerCharacter.getAbilityScores());

        EditAbilityScoresDialog editAbilityScoresDialog = new EditAbilityScoresDialog();
        editAbilityScoresDialog.setArguments(args);
        editAbilityScoresDialog.setTargetFragment(this, UPDATE_ABILITY_SCORES_DIALOG);
        editAbilityScoresDialog.setStyle(DialogFragment.STYLE_NO_TITLE,0);
        editAbilityScoresDialog.show(this.getFragmentManager(),"Edit Ability Scores");
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
    //endregion

    //region Listener Interfaces
    public interface OnPlayerCharacterUpdatedListener
    {
        void onPlayerCharacterUpdated(IPlayerCharacter playerCharacter);
    }

    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    //endregion

    @Override
    public void Update(Bundle args)
    {
        if(args.containsKey("PlayerCharacter"))
        {
            currentPlayerCharacter = (IPlayerCharacter)args.getSerializable("PlayerCharacter");
            BindViews();
        }
    }

    private void BindViews()
    {
        //By binding our  views in a separate function we can more easily call it for both the initial binding and binding on updates to our underlying data
        statsView.setValues(currentPlayerCharacter.getAbilityScores());
        initiativeView.setValues(currentPlayerCharacter.getInitiative());
        combatManeuverView.setValues(currentPlayerCharacter.getCombatManeuverStats());
        savesView.setValues(currentPlayerCharacter.getFortitudeSave(), currentPlayerCharacter.getReflexSave(), currentPlayerCharacter.getWillSave());
        armorView.setValues(currentPlayerCharacter.getTotalAC(), currentPlayerCharacter.getTouchAC(), currentPlayerCharacter.getFlatFootedAC());
        hp_BAB_SRView.setValues(currentPlayerCharacter.getCalculatedHitPoints(),currentPlayerCharacter.getTotalBaseAttackBonus());
        spellResistanceReferenceBlockView.setValues(currentPlayerCharacter.getSpellResistance());
    }
}
