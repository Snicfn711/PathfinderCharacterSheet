package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AddItemToInventoryDialogAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AddArmorToInventoryFragment;

import java.util.ArrayList;
import java.util.List;

public class AddItemToInventoryDialog extends DialogFragment
{
    AddItemToInventoryDialogAdapter addItemToInventoryDialogAdapter;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.add_item_to_inventory_dialog_view, container, false);
        addItemToInventoryDialogAdapter = new AddItemToInventoryDialogAdapter(getChildFragmentManager());
        viewPager = (ViewPager)rootView.findViewById(R.id.AddItemToInventoryViewPager);
        viewPager.setAdapter(addItemToInventoryDialogAdapter);
        Button confirmButton = rootView.findViewById(R.id.AddItemToInventoryConfirmButton);
        confirmButton.setOnClickListener(new ConfirmButtonOnClickListener());
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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    private class ConfirmButtonOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Fragment currentFragment = addItemToInventoryDialogAdapter.getItem(viewPager.getCurrentItem());

            if(currentFragment instanceof AddArmorToInventoryFragment)
            {
                View rootView = viewPager.findViewWithTag("AddArmorRootView");
                Spinner spinner = rootView.findViewById(R.id.AddArmorToInventoryDropdown);
                ArmorEntity armorToSave = (ArmorEntity)spinner.getSelectedItem();

                Intent i = new Intent().putExtra("ArmorToAddToInventory", armorToSave.getArmorID().toString());
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                dismiss();
            }
        }
    }
}
