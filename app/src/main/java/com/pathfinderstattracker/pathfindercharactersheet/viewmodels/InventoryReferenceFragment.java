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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.InventoryRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.type_converters.UUIDConverter;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.AbsItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ConsumableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ReusableMundaneItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Converters.DatabaseEntityObjectConverter;
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.AddItemToInventoryDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class InventoryReferenceFragment extends Fragment
{
    private OnListFragmentInteractionListener mListener;
    private OnPlayerArmorAddedListener armorUpdatedListener;
    private IPlayerCharacter currentPlayerCharacter;
    private Animation click;
    private View rootView;
    private List<IItem> currentInventory;
    private static final int ADD_ITEM_TO_INVENTORY = 1;
    private Bundle  bundle;

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
        Bundle bundle = this.getArguments();
        if(bundle != null)
        {
            currentPlayerCharacter = (PlayerCharacter)bundle.get("PlayerCharacter");
            //If the player character has an empty inventory, the ParentReferenceFragment won't pass anything, so we need to handle this case.
            if(bundle.get("PlayerInventory") == null)
            {
                currentInventory = new ArrayList<>();
            }
            else
            {
                currentInventory = (List<IItem>) bundle.get("PlayerInventory");
            }
        }

        rootView = inflater.inflate(R.layout.inventory_fragment_view, container, false);
        Context context = rootView.getContext();
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final ImageButton addNewItemButton = rootView.findViewById(R.id.AddItemToInventory);
        addNewItemButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addNewItemButton.startAnimation(click);
                OpenAddItemToInventoryDialog();
            }
        }));

        final RecyclerView inventoryRecyclerView = rootView.findViewById(R.id.InventoryRecycler);
        final InventoryRecyclerViewAdapter inventoryRecyclerViewAdapter = new InventoryRecyclerViewAdapter(currentInventory, mListener);
        inventoryRecyclerView.setAdapter(inventoryRecyclerViewAdapter);

        //Set up the click animations for our sort/add buttons
        final Button sortByEquippedButton = rootView.findViewById(R.id.SortByEquipped);
        final Button sortByWeightButton = rootView.findViewById(R.id.SortByWeight);

        sortByEquippedButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sortByEquippedButton.startAnimation(click);
                if (!AbsItem.checkIfSortedByEquipment(currentInventory))
                {
                    Collections.sort(currentInventory, AbsItem.compareEquipment);
                }
                else
                {
                    Collections.sort(currentInventory);
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
                if (!AbsItem.checkIfSortedByWeight(currentInventory))
                {
                    Collections.sort(currentInventory, AbsItem.compareByWeight);
                }
                else
                {
                    Collections.sort(currentInventory);
                }
                inventoryRecyclerViewAdapter.notifyDataSetChanged();
            }
        }));

        final TextView totalWeight = rootView.findViewById(R.id.TotalWeight);
        totalWeight.setText(String.format("Total Weight: %s", Double.toString(getTotalWeight(currentInventory))));
        final TextView totalCost = rootView.findViewById(R.id.TotalCost);
        totalCost.setText(String.format("Total Cost of Items: %s", Double.toString(getTotalCost(currentInventory))));

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
        if(context instanceof OnPlayerArmorAddedListener)
        {
            armorUpdatedListener = (OnPlayerArmorAddedListener)context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnPlayerArmorUpdatedListener");
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

    //region Private Methods
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
        Bundle args = new Bundle();
        args.putSerializable("CurrentPlayerCharacterID", currentPlayerCharacter.getPlayerCharacterID());

        AddItemToInventoryDialog addItemToInventoryDialog = new AddItemToInventoryDialog();
        addItemToInventoryDialog.setArguments(args);
        addItemToInventoryDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        addItemToInventoryDialog.setTargetFragment(this, ADD_ITEM_TO_INVENTORY);
        addItemToInventoryDialog.show(this.getFragmentManager(),"Add Item To Inventory");
    }
    //endregion

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case ADD_ITEM_TO_INVENTORY:
                if (resultCode == Activity.RESULT_OK)
                {
                    ArmorEntity armorToConvert= (ArmorEntity)data.getExtras().getSerializable("ArmorToAddToInventory");
                    if(armorToConvert.getArmorType() == ArmorTypesEnum.Armor)
                    {
                        armorUpdatedListener.onPlayerArmorAdded(DatabaseEntityObjectConverter.ConvertArmorEntityToArmorObject(armorToConvert));
                    }
                    else if(armorToConvert.getArmorType() == ArmorTypesEnum.Shield)
                    {
                        armorUpdatedListener.onPlayerArmorAdded(DatabaseEntityObjectConverter.ConvertArmorEntityToShieldObject(armorToConvert));
                    }
                }
                break;
        }
    }

    public interface OnPlayerArmorAddedListener
    {
        void onPlayerArmorAdded(IProtection protectionToAddToInventory);
    }
}
