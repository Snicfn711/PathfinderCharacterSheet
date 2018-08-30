package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;

import java.util.ArrayList;
import java.util.List;

public class EquipMundaneItemDialog extends DialogFragment
{
    private Spinner mundaneEquipmentInInventorySpinner;
    private TextView warningView;

    private List<IEquipment> currentRelevantEquipmentInventory;
    private List<IEquipment> currentlyEquippedItems;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        currentRelevantEquipmentInventory = (List<IEquipment>)getArguments().getSerializable("CurrentRelevantEquipmentInventory");
        //Eventually we'll need to implement some code around making sure that the items being equipped are valid together (shields with two handed weapons comes to mind)
        currentlyEquippedItems = (List<IEquipment>)getArguments().getSerializable("CurrentlyEquippedItems");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Initialize our view and bind our controls
        View rootView = inflater.inflate(R.layout.equip_mundane_equipment_dialog, container, false);
        mundaneEquipmentInInventorySpinner = rootView.findViewById(R.id.EquipMundaneItemDropdown);
        TextView titleView = rootView.findViewById(R.id.EquipMundaneItemTitle);
        titleView.setText((String)getArguments().getSerializable("TitleString"));
        warningView = rootView.findViewById(R.id.EquipMundaneItemWarningText);
        Button confirmButton = rootView.findViewById(R.id.EquipMundaneItemConfirmButton);

        //Create and bind our adapter
        ArrayAdapter<IEquipment> equipmentArrayAdapter = new ArrayAdapter<>(this.getContext(), R.layout.dropdown_item_view, currentRelevantEquipmentInventory);
        mundaneEquipmentInInventorySpinner.setAdapter(equipmentArrayAdapter);

        //Set our on click listener
        confirmButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IEquipment itemToEquip = (IEquipment)mundaneEquipmentInInventorySpinner.getSelectedItem();
                Intent i = new Intent().putExtra("ItemToEquip", itemToEquip);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                dismiss();
            }
        });

        return rootView;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Dialog d = getDialog();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayHeight = displayMetrics.heightPixels;
        if(d != null)
        {
            //The app is locked into a portrait view, so we're not too worried about checking our orientation or adjusting accordingly
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int)(displayHeight * .3));
        }
    }
}
