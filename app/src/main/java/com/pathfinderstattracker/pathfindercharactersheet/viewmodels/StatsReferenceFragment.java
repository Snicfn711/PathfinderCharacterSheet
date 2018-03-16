package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AbilityScoreAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.ArmorAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.CombatManueverAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.HP_BAB_SR_Adapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.InitiativeAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.MovementAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.SavesAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.ArmorItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.CombatManeuver;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.HitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.Movement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;

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
    private AbilityScore[] tempStats = new AbilityScore[] {strength, dexterity, constiution, intelligence, wisdom, charisma};
    //endregion

    //region Test Movements
    private Movement base = new Movement("Base", 30, MovementManeuverabilityEnum.Perfect);
    private Movement armor = new Movement("Armor", 20, MovementManeuverabilityEnum.Perfect);
    private Movement fly = new Movement("Fly", 30, MovementManeuverabilityEnum.Perfect);
    private Movement swim = new Movement("Swim", 30, MovementManeuverabilityEnum.Perfect);
    private Movement climb = new Movement("Climb", 30, MovementManeuverabilityEnum.Perfect);
    private Movement burrow = new Movement("Burrow", 30, MovementManeuverabilityEnum.Perfect);
    private Movement[] tempMovement = new Movement[]{base,armor,fly,swim,climb,burrow};
    //endregion

    //region Test Character
    private PlayerCharacter tempCharacter = new PlayerCharacter();
    //endregion

    //region Test Armor Items
    private ArmorItem armorBonus = new ArmorItem("armorBonus", ArmorTypesEnum.Armor,5);
    private ArmorItem naturalArmorBonus = new ArmorItem("naturalArmorBonus", ArmorTypesEnum.NaturalArmor,5);
    private ArmorItem shieldArmorBonus = new ArmorItem("shieldArmorBonus", ArmorTypesEnum.Shield,5);
    private ArmorItem dodgeArmorBonus = new ArmorItem("dodgeArmorBonus", ArmorTypesEnum.Dodge, 5);
    private ArmorItem[] tempArmorItems = new ArmorItem[]{armorBonus, naturalArmorBonus, shieldArmorBonus, dodgeArmorBonus};
    //endregion

    //region Temp Hit Points
    private IHitPoints tempHitPoints = new HitPoints(0,30);
    //endregion


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StatsReferenceFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatsReferenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatsReferenceFragment newInstance(String param1, String param2)
    {
        StatsReferenceFragment fragment = new StatsReferenceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.stats_screen_fragment, container, false);
        Activity context = this.getActivity();
        //region Populate Test Character Data
        tempCharacter.setInitiative(3); //TODO: Replace test data
        tempCharacter.setCombatManeuverStats(new CombatManeuver(3,16));
        tempCharacter.setAbilityScores(tempStats);
        tempCharacter.setFortitudeSave(4);
        tempCharacter.setReflexSave(5);
        tempCharacter.setWillSave(6);
        tempCharacter.setTotalAC(35);
        tempCharacter.setEquippedArmor(tempArmorItems);
        tempCharacter.setHitPoints(tempHitPoints);
        tempCharacter.setTotalBaseAttackBonus(5);
        tempCharacter.setSpellResistance(5);
        //endregion

        //Populate and bind our stats list
        ListView statsView = rootView.findViewById(R.id.statsList);
        AbilityScoreAdapter abilityScoreAdapter = new AbilityScoreAdapter(context,tempCharacter.getAbilityScores());
        statsView.setAdapter(abilityScoreAdapter);

        //Populate and bind our movement list
        ListView movementView = rootView.findViewById(R.id.movementList);
        MovementAdapter movementAdapter = new MovementAdapter(context, tempMovement);
        movementView.setAdapter(movementAdapter);

        //Populate and bind our initiative section
        ListView initiativeView = rootView.findViewById(R.id.initiativeList);
        InitiativeAdapter initiativeAdapter = new InitiativeAdapter(context, tempCharacter.getInitiative());
        initiativeView.setAdapter(initiativeAdapter);

        //Populate and bind our combat manuever list
        ListView combatManueverView = rootView.findViewById(R.id.combatManueverList);
        CombatManueverAdapter combatManueverAdapter = new CombatManueverAdapter(context, tempCharacter.getCombatManeuverStats());
        combatManueverView.setAdapter(combatManueverAdapter);

        //Populate and bind our saves list
        ListView savesView = rootView.findViewById(R.id.savesList);
        SavesAdapter savesAdapter = new SavesAdapter(context, tempCharacter.getFortitudeSave(), tempCharacter.getReflexSave(), tempCharacter.getWillSave());
        savesView.setAdapter(savesAdapter);

        //Populate and bind our AC list
        ListView armorView = rootView.findViewById(R.id.armorList);
        ArmorAdapter armorAdapter = new ArmorAdapter(context, tempCharacter.getTotalAC(), tempCharacter.CalculateTouchAC(), tempCharacter.CalculateFlatFootedAC());
        armorView.setAdapter(armorAdapter);

        //Populate and bind our HP, BAB, SR section
        ListView hp_BAB_SRView = rootView.findViewById(R.id.hp_bab_srList);
        HP_BAB_SR_Adapter hp_bab_sr_adapter = new HP_BAB_SR_Adapter(context, tempCharacter.getHitPoints(), tempCharacter.getTotalBaseAttackBonus(), tempCharacter.getSpellResistance());
        hp_BAB_SRView.setAdapter(hp_bab_sr_adapter);

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
