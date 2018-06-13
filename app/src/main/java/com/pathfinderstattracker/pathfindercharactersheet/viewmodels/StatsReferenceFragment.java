package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WondrousItems;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.IMovement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.Movement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddNameDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EditAbilityScoresDialog;
import com.pathfinderstattracker.pathfindercharactersheet.views.ACReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.CombatManeuverReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.HP_BAB_SR_ReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.InitiativeReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.MovementReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.SavesReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.AbilityScoreReferenceBlockView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatsReferenceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatsReferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class StatsReferenceFragment extends Fragment implements PathfinderRepositoryListener
{
    private IPlayerCharacter currentPlayerCharacter;
    private PathfinderRepository repository;
    private View rootView;
    private Animation click;

    private static final int ADD_NEW_CHARACTER_NAME_DIALOG = 1;//Used later in the code to determine which dialog is returning data to this fragment
    private static final int UPDATE_ABILITY_SCORES_DIALOG = 2;

    //region Test Movements
    private Movement base = new Movement("Base", 30, MovementManeuverabilityEnum.Perfect);
    private Movement armor = new Movement("Armor", 20, MovementManeuverabilityEnum.Perfect);
    private Movement fly = new Movement("Fly", 30, MovementManeuverabilityEnum.Perfect);
    private Movement swim = new Movement("Swim", 30, MovementManeuverabilityEnum.Perfect);
    private Movement climb = new Movement("Climb", 30, MovementManeuverabilityEnum.Perfect);
    private Movement burrow = new Movement("Burrow", 30, MovementManeuverabilityEnum.Perfect);
    private List<IMovement> tempMovement = new ArrayList<IMovement>();
    //endregion

    //region Test Armor Items
    private Armor armorBonus = new Armor("Armor", 5, 5, 0,3,3,3,3, ArmorWeightCategoryEnum.Heavy,5, SizeCategoryEnum.Medium,false,null);
    private WondrousItems naturalArmorBonus = new WondrousItems("Natural Armor", 5,5, null, BodySlotsEnum.Throat, null, 100, ArmorTypesEnum.NaturalArmor, 3);
    private Shield shieldArmorBonus = new Shield("Shield", 5,5,5,5,5,5, ShieldWeightCategoryEnum.Tower,SizeCategoryEnum.Small,false,5, false, null);
    private WondrousItems dodgeArmorBonus = new WondrousItems("Dodge", 5, 5, null, BodySlotsEnum.Feet, null, 5, ArmorTypesEnum.Dodge, 2);
    private List<IEquipment> tempArmorItems = new ArrayList<IEquipment>();
    //endregion

    // TODO: Rename parameter arguments, choose names that match
    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

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
        tempArmorItems.add(armorBonus);
        tempArmorItems.add(naturalArmorBonus);
        tempArmorItems.add(shieldArmorBonus);
        tempArmorItems.add(dodgeArmorBonus);
        tempMovement.add(base);
        tempMovement.add(armor);

        if (getArguments() != null)
        {
            //Like above, since we don't have any parameters yet, there's not much to do here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.stats_screen_fragment_view, container, false);
        Activity context = this.getActivity();
        repository = new PathfinderRepository(this.getActivity().getApplication());

        //For some reason this fragment is getting created twice.
        //The first time it has a parent fragment and can get the data from that, but has no arguments of its own
        //The second time it has no parent fragment(?!) and get its arguments passed to it from the reference adapter.
        //If we don't account for that first pass, the code returns a null reference exception
        //TODO:Figure out why the fragment is getting created twice and see if we need both, or if there's a better spot to pass/get the arguments from.
        Bundle bundle = new Bundle();
        if(this.getParentFragment() == null)
        {
            bundle = this.getArguments();
            currentPlayerCharacter =  (PlayerCharacter)bundle.getSerializable("PlayerCharacter");
            if(currentPlayerCharacter.getPlayerCharacterName() == null || currentPlayerCharacter.getPlayerCharacterName().isEmpty())
            {
                AddNameDialog getNameDialog = new AddNameDialog();
                getNameDialog.setTargetFragment(this, ADD_NEW_CHARACTER_NAME_DIALOG);
                getNameDialog.setStyle(DialogFragment.STYLE_NO_TITLE,0);
                getNameDialog.show(this.getFragmentManager(),"Add Player Character Name");
            }
        }
        else
        {
            bundle = this.getParentFragment().getArguments();
            currentPlayerCharacter =  (PlayerCharacter)bundle.getSerializable("PlayerCharacter");
        }

        //region Create and set our View Adapters
        //Populate and bind our stats list
        AbilityScoreReferenceBlockView statsView = rootView.findViewById(R.id.statsList);
        statsView.setValues(currentPlayerCharacter.getAbilityScores());
        final ImageButton editStatsButton = statsView.findViewById(R.id.EditStatsButton);
        editStatsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editStatsButton.startAnimation(click);
                OpenEditAbilityScoresDialog();
            }
        });

        //Populate and bind our movement list
        MovementReferenceBlockView movementView = rootView.findViewById(R.id.movementList);
        movementView.setValues(tempMovement);

        //Populate and bind our initiative section
        InitiativeReferenceBlockView initiativeView = rootView.findViewById(R.id.initiativeList);
        initiativeView.setValues(currentPlayerCharacter.getInitiative());

        //Populate and bind our combat Maneuver list
        CombatManeuverReferenceBlockView combatManeuverView = rootView.findViewById(R.id.combatManeuverList);
        combatManeuverView.setValues(currentPlayerCharacter.getCombatManeuverStats());

        //Populate and bind our saves list
        SavesReferenceBlockView savesView = rootView.findViewById(R.id.savesList);
        savesView.setValues(currentPlayerCharacter.getFortitudeSave(), currentPlayerCharacter.getReflexSave(), currentPlayerCharacter.getWillSave());

        //Populate and bind our AC list
        ACReferenceBlockView armorView = rootView.findViewById(R.id.armorList);
        armorView.setValues(currentPlayerCharacter.getTotalAC(), currentPlayerCharacter.getTouchAC(), currentPlayerCharacter.getFlatFootedAC());

        //Populate and bind our HP, BAB, SR section
        HP_BAB_SR_ReferenceBlockView hp_BAB_SRView = rootView.findViewById(R.id.hp_bab_srList);
        hp_BAB_SRView.setValues(currentPlayerCharacter.getTotalHitPoints(),currentPlayerCharacter.getTotalBaseAttackBonus(), currentPlayerCharacter.getSpellResistance());
        //endregion

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
        } else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    //region Repository Listener Methods
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
        AbilityScoreReferenceBlockView statsView = rootView.findViewById(R.id.statsList);
        SavesReferenceBlockView savesView = rootView.findViewById(R.id.savesList);
        InitiativeReferenceBlockView initiativeReferenceBlockView = rootView.findViewById(R.id.initiativeList);
        ACReferenceBlockView acReferenceBlockView = rootView.findViewById(R.id.armorList);
        HP_BAB_SR_ReferenceBlockView hp_bab_sr_referenceBlockView = rootView.findViewById(R.id.hp_bab_srList);
        CombatManeuverReferenceBlockView combatManeuverReferenceBlockView = rootView.findViewById(R.id.combatManeuverList);

        statsView.setValues(playerCharacter.getAbilityScores());
        savesView.setValues(playerCharacter.getFortitudeSave(), playerCharacter.getReflexSave(), playerCharacter.getWillSave());
        initiativeReferenceBlockView.setValues(playerCharacter.getInitiative());
        acReferenceBlockView.setValues(playerCharacter.getTotalAC(), playerCharacter.getTouchAC(), playerCharacter.getFlatFootedAC());
        hp_bab_sr_referenceBlockView.setValues(playerCharacter.getTotalHitPoints(), playerCharacter.getTotalBaseAttackBonus(), playerCharacter.getSpellResistance());
        combatManeuverReferenceBlockView.setValues(playerCharacter.getCombatManeuverStats());
    }
    //endregion

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle bundle = data.getExtras();
        switch(requestCode)
        {
            case ADD_NEW_CHARACTER_NAME_DIALOG:
                if (resultCode == Activity.RESULT_OK) {
                    String newPlayerCharacterName = (String) bundle.getSerializable("NewPlayerCharacterName");
                    currentPlayerCharacter.setPlayerCharacterName(newPlayerCharacterName);
                }
                break;
            case UPDATE_ABILITY_SCORES_DIALOG:
                if (resultCode == Activity.RESULT_OK) {
                    List<IAbilityScore> updatedAbilityScores = (List<IAbilityScore>) bundle.getSerializable("UpdatedAbilityScores");
                    currentPlayerCharacter.setAbilityScores(updatedAbilityScores);
                }
                break;
        }
        repository.updatePlayerCharacter(DatabaseEntityObjectConverter.ConvertPlayerCharacterObjectToPlayerCharacterEntity(currentPlayerCharacter), this);
    }


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
}
