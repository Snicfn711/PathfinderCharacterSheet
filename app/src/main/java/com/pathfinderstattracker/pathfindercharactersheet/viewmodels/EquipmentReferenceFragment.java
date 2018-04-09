package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.EquipmentRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Weapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponFamilyEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EquipmentReferenceFragment extends Fragment
{

    //region Temp Equipment List
    private Weapon sword = new Weapon("Longsword",
                                     WeaponFamilyEnum.Martial,
                                     0,
                                     false,
                                     false,
                                     false,
                                     false,
                                     WeaponWeightClassEnum.OneHanded,
                                     false,
                                     315,
                                     new Damage[]{new Damage(1,8), new Damage(1,6)},
                                     2,
                                     1,
                                     false,
                                     new WeaponDamageTypeEnum[]{WeaponDamageTypeEnum.Slashing},
                                     false,
                                     false,
                                     false,
                                     false,
                                     "Steel",
                                     true,
                                     false,
                                     1,
                                     SizeCategoryEnum.Medium,
                                     4,
                                     0,
                                      null);
    private Armor plate = new Armor("Plate Armor",
                                    1650,
                                    9,
                                    2,
                                    1,
                                    6,
                                    35,
                                    20,
                                    ArmorWeightCategoryEnum.Heavy,
                                    50,
                                    SizeCategoryEnum.Medium,
                                    false,
                                    null);
    private Shield tower = new Shield("Tower Shield",
                                      180,
                                      4,
                                      2,
                                      10,
                                      50,
                                      45,
                                      ShieldWeightCategoryEnum.Tower,
                                      SizeCategoryEnum.Medium,
                                      false,
                                      0,
                                      true,
                                      null);
    private IEquipment[] TempEquipment = new IEquipment[]{sword, plate, tower};
    //endregion

    // TODO: Customize parameter argument names
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;
    private Animation click;

    public EquipmentReferenceFragment()
    {
        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @SuppressWarnings("unused")
    public static EquipmentReferenceFragment newInstance(int columnCount)
    {

        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here yet
        EquipmentReferenceFragment fragment = new EquipmentReferenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            //Like above, since we don't have any paramters yet, there's not much to do here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.equipment_fragment_view, container, false);
        Context context = rootView.getContext();

        // Set the adapter
        final RecyclerView recyclerView =  rootView.findViewById(R.id.EquipmentRecycler);
        final EquipmentRecyclerViewAdapter equipmentAdapter = new EquipmentRecyclerViewAdapter(TempEquipment, mListener);
        recyclerView.setAdapter(equipmentAdapter);

        //Set up the animations for clicking our sort buttons
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final Button armorAndWeaponsButton = rootView.findViewById(R.id.ArmorAndWeaponsButton);
        final Button wondrousItemsButton = rootView.findViewById(R.id.WondrousItemsButton);
        armorAndWeaponsButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                armorAndWeaponsButton.startAnimation(click);
            }
        }));

        wondrousItemsButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                wondrousItemsButton.startAnimation(click);
            }
        }));

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
        void onListFragmentInteraction(IEquipment item);
    }
}
