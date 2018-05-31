package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.BodySlotsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;
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
import com.pathfinderstattracker.pathfindercharactersheet.views.ACReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.CombatManueverReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.HP_BAB_SR_ReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.InitiativeReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.MovementReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.SavesReferenceBlockView;
import com.pathfinderstattracker.pathfindercharactersheet.views.AbilityScoreReferenceBlockView;

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

public class StatsReferenceFragment extends Fragment
{
    //region Test Ability Scores
    private AbilityScore strength = new AbilityScore(AbilityScoreEnum.STR, 10);
    private AbilityScore dexterity = new AbilityScore(AbilityScoreEnum.DEX, 11);
    private AbilityScore constiution = new AbilityScore(AbilityScoreEnum.CON, 12);
    private AbilityScore intelligence = new AbilityScore(AbilityScoreEnum.INT, 13);
    private AbilityScore wisdom = new AbilityScore(AbilityScoreEnum.WIS, 14);
    private AbilityScore charisma = new AbilityScore(AbilityScoreEnum.CHA, 15);
    private List<IAbilityScore> tempStats = new ArrayList<IAbilityScore>();
    //endregion

    //region Test Movements
    private Movement base = new Movement("Base", 30, MovementManeuverabilityEnum.Perfect);
    private Movement armor = new Movement("Armor", 20, MovementManeuverabilityEnum.Perfect);
    private Movement fly = new Movement("Fly", 30, MovementManeuverabilityEnum.Perfect);
    private Movement swim = new Movement("Swim", 30, MovementManeuverabilityEnum.Perfect);
    private Movement climb = new Movement("Climb", 30, MovementManeuverabilityEnum.Perfect);
    private Movement burrow = new Movement("Burrow", 30, MovementManeuverabilityEnum.Perfect);
    private List<IMovement> tempMovement = new ArrayList<IMovement>();
    //endregion

    //region Test Character
    private PlayerCharacter tempCharacter = new PlayerCharacter();
    //endregion

    //region Test Armor Items
    private Armor armorBonus = new Armor("Armor", 5, 5, 0,3,3,3,3, ArmorWeightCategoryEnum.Heavy,5, SizeCategoryEnum.Medium,false,null);
    private WondrousItems naturalArmorBonus = new WondrousItems("Natural Armor", 5,5, null, BodySlotsEnum.Throat, null, 100, ArmorTypesEnum.NaturalArmor, 3);
    private Shield shieldArmorBonus = new Shield("Shield", 5,5,5,5,5,5, ShieldWeightCategoryEnum.Tower,SizeCategoryEnum.Small,false,5, false, null);
    private WondrousItems dodgeArmorBonus = new WondrousItems("Dodge", 5, 5, null, BodySlotsEnum.Feet, null, 5, ArmorTypesEnum.Dodge, 2);
    private List<IEquipment> tempArmorItems = new ArrayList<IEquipment>();
    //endregion

    //region Temp Hit Points
    private IHitPoints tempHitPoints = new HitPoints(0,30);
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
        tempArmorItems.add(armorBonus);
        tempArmorItems.add(naturalArmorBonus);
        tempArmorItems.add(shieldArmorBonus);
        tempArmorItems.add(dodgeArmorBonus);
        tempMovement.add(base);
        tempMovement.add(armor);
        tempMovement.add(fly);
        tempMovement.add(swim);
        tempMovement.add(climb);
        tempMovement.add(burrow);
        tempStats.add(strength);
        tempStats.add(dexterity);
        tempStats.add(constiution);
        tempStats.add(intelligence);
        tempStats.add(wisdom);
        tempStats.add(charisma);

        if (getArguments() != null)
        {
            //Like above, since we don't have any paramters yet, there's not much to do here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.stats_screen_fragment_view, container, false);
        Activity context = this.getActivity();
        //region Populate Test Character Data
        tempCharacter.setInitiative(3); //TODO: Replace test character data
        tempCharacter.setCombatManeuverStats(new CombatManeuver(3,16));
        tempCharacter.setAbilityScores(tempStats);
        tempCharacter.setFortitudeSave(4);
        tempCharacter.setReflexSave(5);
        tempCharacter.setWillSave(6);
        tempCharacter.setTotalAC(35);
        tempCharacter.setEquipment(tempArmorItems);
        tempCharacter.setHitPoints(tempHitPoints);
        tempCharacter.setTotalBaseAttackBonus(5);
        tempCharacter.setSpellResistance(5);
        //endregion

        //region Create and set our View Adapters
        //Populate and bind our stats list
        AbilityScoreReferenceBlockView statsView = rootView.findViewById(R.id.statsList);
        statsView.setValues(tempCharacter.getAbilityScores());

        //Populate and bind our movement list
        MovementReferenceBlockView movementView = rootView.findViewById(R.id.movementList);
        movementView.setValues(tempMovement);

        //Populate and bind our initiative section
        InitiativeReferenceBlockView initiativeView = rootView.findViewById(R.id.initiativeList);
        initiativeView.setValues(tempCharacter.getInitiative());

        //Populate and bind our combat manuever list
        CombatManueverReferenceBlockView combatManueverView = rootView.findViewById(R.id.combatManueverList);
        combatManueverView.setValues(tempCharacter.getCombatManeuverStats());

        //Populate and bind our saves list
        SavesReferenceBlockView savesView = rootView.findViewById(R.id.savesList);
        savesView.setValues(tempCharacter.getFortitudeSave(), tempCharacter.getReflexSave(), tempCharacter.getWillSave());

        //Populate and bind our AC list
        ACReferenceBlockView armorView = rootView.findViewById(R.id.armorList);
        armorView.setValues(tempCharacter.getTotalAC(), tempCharacter.CalculateTouchAC(), tempCharacter.CalculateFlatFootedAC());

        //Populate and bind our HP, BAB, SR section
        HP_BAB_SR_ReferenceBlockView hp_BAB_SRView = rootView.findViewById(R.id.hp_bab_srList);
        hp_BAB_SRView.setValues(tempCharacter.getHitPoints(),tempCharacter.getTotalBaseAttackBonus(), tempCharacter.getSpellResistance());
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
}
