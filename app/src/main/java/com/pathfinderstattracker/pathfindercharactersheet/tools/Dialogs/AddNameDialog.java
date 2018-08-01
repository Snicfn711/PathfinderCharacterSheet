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
import android.widget.EditText;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;

public class AddNameDialog extends DialogFragment
{
    private EditText getNameText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.add_player_character_name_dialog_view, container,false);
        ImageButton getNameButton = rootView.findViewById(R.id.SaveNewCharactername);
        getNameText = rootView.findViewById(R.id.GetNewCharacterName);
        getNameButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            if(!getNameText.getText().toString().isEmpty())
            {
                Intent returnedIntent = new Intent().putExtra("NewPlayerCharacterName", getNameText.getText().toString());
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, returnedIntent);
                dismiss();
            }
        }});
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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (displayHeight * .25));
        }
    }
}
