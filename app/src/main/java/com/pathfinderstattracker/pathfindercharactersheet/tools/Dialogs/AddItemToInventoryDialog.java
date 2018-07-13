package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathfinderstattracker.pathfindercharactersheet.R;

public class AddItemToInventoryDialog extends AppCompatDialogFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.add_item_to_inventory_dialog_view, container, false);
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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (displayHeight * .5));
        }
    }
}
