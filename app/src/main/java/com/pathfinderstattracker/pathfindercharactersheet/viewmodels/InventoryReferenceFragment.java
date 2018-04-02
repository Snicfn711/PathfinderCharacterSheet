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
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.InventoryRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.AbsItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ConsumableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ReusableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InventoryReferenceFragment extends Fragment
{

    //region Temp Items
    ConsumableMundaneItem potion = new ConsumableMundaneItem("Potion", "Heal 1d8", 15.6, 0);
    ReusableMundaneItem rope = new ReusableMundaneItem("Hemp Rope", "Use as a rope", .05, 10);
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
    List<IItem> tempItems = new ArrayList<IItem>();
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
    public InventoryReferenceFragment()
    {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static InventoryReferenceFragment newInstance(int columnCount)
    {
        InventoryReferenceFragment fragment = new InventoryReferenceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //region Temporary items
        tower.setDescription("Is a shield");
        tempItems.add(tower);
        tempItems.add(potion);
        tempItems.add(rope);
        //endregion

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
        View rootView = inflater.inflate(R.layout.inventory_fragment_view, container, false);
        Context context = rootView.getContext();

        //Set up our adapter
        final RecyclerView inventoryRecyclerView = rootView.findViewById(R.id.InventoryRecycler);
        final InventoryRecyclerViewAdapter inventoryRecyclerViewAdapter = new InventoryRecyclerViewAdapter(tempItems, mListener);
        inventoryRecyclerView.setAdapter(inventoryRecyclerViewAdapter);

        //Set up the click animations for our sort/add buttons
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final Button sortByEquippedButton = rootView.findViewById(R.id.SortByEquipped);
        final Button sortByNameButton = rootView.findViewById(R.id.SortByName);
        final Button sortByWeightButton = rootView.findViewById(R.id.SortByWeight);
        final ImageButton addNewItemButton = rootView.findViewById(R.id.AddItemToInventory);

        sortByEquippedButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByEquippedButton.startAnimation(click);
                if(!AbsItem.checkIfSortedByEquipment(tempItems))
                {
                    Collections.sort(tempItems, AbsItem.compareEquipment);
                }
                else
                {
                    Collections.sort(tempItems);
                }
                inventoryRecyclerViewAdapter.notifyDataSetChanged();
            }
        }));

        sortByNameButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByNameButton.startAnimation(click);
                if(!AbsItem.checkIfSortedByName(tempItems))
                {
                    Collections.sort(tempItems, AbsItem.compareByName);
                }
                else
                {
                    Collections.sort(tempItems);
                }
                inventoryRecyclerViewAdapter.notifyDataSetChanged();
            }
        }));

        sortByWeightButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByWeightButton.startAnimation(click);
                if(!AbsItem.checkIfSortedByWeight(tempItems))
                {
                    Collections.sort(tempItems, AbsItem.compareByWeight);
                }
                else
                {
                    Collections.sort(tempItems);
                }
                inventoryRecyclerViewAdapter.notifyDataSetChanged();
            }
        }));

        addNewItemButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addNewItemButton.startAnimation(click);
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
        void onListFragmentInteraction(IItem item);
    }
}
