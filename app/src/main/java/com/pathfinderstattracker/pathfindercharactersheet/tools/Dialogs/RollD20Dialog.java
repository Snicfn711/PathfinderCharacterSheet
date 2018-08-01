package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

import java.util.Random;

public class RollD20Dialog extends DialogFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.roll_d20_dialog_view, container,false);
        ImageButton closeDialogButton = rootView.findViewById(R.id.CloseRollD20DialogButton);
        Button rollD20Button = rootView.findViewById(R.id.RollD20RollButton);
        TextView titleText = rootView.findViewById(R.id.RollD20TitleText);
        final TextView resultText = rootView.findViewById(R.id.RollD20ResultText);

        String title = getArguments().getString("TitleText");
        final int addedValue = getArguments().getInt("AddedValue");

        titleText.setText(title);
        resultText.setText(String.format("1d20 + %s", Integer.toString(addedValue)));

        closeDialogButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            dismiss();
        }});

        rollD20Button.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            int rollResult = addedValue;
            Random r = new Random();
            rollResult += (r.nextInt(21-1) + 1);
            resultText.setText(Integer.toString(rollResult));
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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int) (displayHeight * .33));
        }
    }
}
