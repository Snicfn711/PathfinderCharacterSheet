package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.InventoryRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.AbsItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ConsumableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ReusableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddItemToInventoryDialog;

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

    private OnListFragmentInteractionListener mListener;
    private Animation click;
    private static final int ADD_ITEM_TO_INVENTORY = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InventoryReferenceFragment()
    {
    }

    @SuppressWarnings("unused")
    public static InventoryReferenceFragment newInstance(int columnCount)
    {
        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here yet
        InventoryReferenceFragment fragment = new InventoryReferenceFragment();
        Bundle args = new Bundle();
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
            //Like above, since we don't have any parameters yet, there's not much to do here
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
                OpenAddItemToInventoryDialog();
            }
        }));

        final TextView totalWeight = rootView.findViewById(R.id.TotalWeight);
        totalWeight.setText(String.format("Total Weight: %s", Double.toString(getTotalWeight(tempItems))));
        final TextView totalCost = rootView.findViewById(R.id.TotalCost);
        totalCost.setText(String.format("Total Cost of Items: %s", Double.toString(getTotalCost(tempItems))));
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

    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(IItem item);
    }

    private double getTotalCost(List<IItem> items)
    {
        double totalCost = 0;
        for (IItem item : items)
        {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    private double getTotalWeight(List<IItem> items)
    {
        double totalWeight = 0;
        for(IItem item: items)
        {
            totalWeight += item.getWeightAtMediumSize();
        }
        return totalWeight;
    }

    private void OpenAddItemToInventoryDialog()
    {
        AddItemToInventoryDialog addItemToInventoryDialog = new AddItemToInventoryDialog();
        addItemToInventoryDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        addItemToInventoryDialog.show(this.getFragmentManager(),"Add Item To Inventory");
    }
}
