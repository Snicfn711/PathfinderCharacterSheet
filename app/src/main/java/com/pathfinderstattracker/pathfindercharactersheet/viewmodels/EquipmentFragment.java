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

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.EquipmentRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Weapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponFamilyEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EquipmentFragment extends Fragment
{

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
                                     new Damage(1, 8),
                                     2,
                                     2,
                                     false,
                                     new WeaponDamageTypeEnum[1],
                                     false,
                                     false,
                                     false,
                                     false,
                                     "Steel",
                                     true,
                                     false,
                                     0,
                                     SizeCategoryEnum.Medium,
                                     4);
    private Armor plate = new Armor("Plate Armor",
                                    1650,
                                    9,
                                    0,
                                    1,
                                    6,
                                    35,
                                    20,
                                    ArmorWeightCategoryEnum.Heavy,
                                    50,
                                    SizeCategoryEnum.Medium,
                                    false);
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
                                      true);
    private IEquipment[] TempEquipment = new IEquipment[]{sword, plate, tower};

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EquipmentFragment()
    {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EquipmentFragment newInstance(int columnCount)
    {
        EquipmentFragment fragment = new EquipmentFragment();
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
        View rootView = inflater.inflate(R.layout.equipment_list_view, container, false);

        // Set the adapter

            Context context = rootView.getContext();
            final RecyclerView recyclerView =  rootView.findViewById(R.id.EquipmentRecycler);
            final EquipmentRecyclerViewAdapter equipmentAdapter = new EquipmentRecyclerViewAdapter(TempEquipment, mListener);
            if (mColumnCount <= 1)
            {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else
            {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new EquipmentRecyclerViewAdapter(TempEquipment, mListener));

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
