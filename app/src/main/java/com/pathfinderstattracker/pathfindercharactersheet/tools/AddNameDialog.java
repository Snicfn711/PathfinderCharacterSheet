package com.pathfinderstattracker.pathfindercharactersheet.tools;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

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
            if(getNameText.getText().toString().isEmpty())
            {
                //If no text has been entered, just return null
            }
            else
            {
                Intent i = new Intent().putExtra("NewPlayerCharacterName", getNameText.getText().toString());
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
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
        if(d != null)
        {
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, 600);//TODO:Figure out how to avoid using a hard coded value for the height. Preferably it would a percentage of the screen size depending on the screen's orientation
        }
    }

}
