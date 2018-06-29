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
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditAbilityScoresDialog extends DialogFragment
{
    private EditText getStrength;
    private EditText getDexterity;
    private EditText getConstitution;
    private EditText getIntelligence;
    private EditText getWisdom;
    private EditText getCharisma;

    private List<IAbilityScore> abilityScoresToReturn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.edit_player_ability_scores_dialog_view, container,false);
        ImageButton getAbilityScoresButton = rootView.findViewById(R.id.SaveAbilityScores);
        abilityScoresToReturn = new ArrayList<IAbilityScore>();

        getStrength = rootView.findViewById(R.id.GetStrength);
        getStrength.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getStrength.setText("");
                }
            }
        });
        getDexterity = rootView.findViewById(R.id.GetDexterity);
        getDexterity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getDexterity.setText("");
                }
            }
        });
        getConstitution = rootView.findViewById(R.id.GetConstitution);
        getConstitution.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getConstitution.setText("");
                }
            }
        });
        getIntelligence = rootView.findViewById(R.id.GetIntelligence);
        getIntelligence.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getIntelligence.setText("");
                }
            }
        });
        getWisdom = rootView.findViewById(R.id.GetWisdom);
        getWisdom.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getWisdom.setText("");
                }
            }
        });
        getCharisma = rootView.findViewById(R.id.GetCharisma);
        getCharisma.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getCharisma.setText("");
                }
            }
        });

        List<IAbilityScore> currentAbilityScores = (List<IAbilityScore>)getArguments().getSerializable("CurrentAbilityScores");
        for(IAbilityScore abilityScore : currentAbilityScores)
        {
            switch(abilityScore.getStat())
            {
                case STR:
                    getStrength.setText(Integer.toString(abilityScore.getAmount()));
                    break;
                case DEX:
                    getDexterity.setText(Integer.toString(abilityScore.getAmount()));
                    break;
                case CON:
                    getConstitution.setText(Integer.toString(abilityScore.getAmount()));
                    break;
                case INT:
                    getIntelligence.setText(Integer.toString(abilityScore.getAmount()));
                    break;
                case WIS:
                    getWisdom.setText(Integer.toString(abilityScore.getAmount()));
                    break;
                case CHA:
                    getCharisma.setText(Integer.toString(abilityScore.getAmount()));
                    break;
            }
        }

        getAbilityScoresButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            if(getStrength.getText().toString().isEmpty())
            {
                //If any of the fields are empty, it means the user took the time to clear them out,
                //and we don't them to be able to save until they've fixed that.
                getStrength.requestFocus();
            }
            else if(getDexterity.getText().toString().isEmpty())
            {
                getDexterity.requestFocus();
            }
            else if(getConstitution.getText().toString().isEmpty())
            {
                getConstitution.requestFocus();
            }
            else if(getIntelligence.getText().toString().isEmpty())
            {
                getIntelligence.requestFocus();
            }
            else if(getWisdom.getText().toString().isEmpty())
            {
                getWisdom.requestFocus();
            }
            else if(getCharisma.getText().toString().isEmpty())
            {
                getCharisma.requestFocus();
            }
            else
            {
                IAbilityScore strength = new AbilityScore(AbilityScoreEnum.STR, Integer.parseInt(getStrength.getText().toString()));
                IAbilityScore dexterity = new AbilityScore(AbilityScoreEnum.DEX, Integer.parseInt(getDexterity.getText().toString()));
                IAbilityScore constitution = new AbilityScore(AbilityScoreEnum.CON, Integer.parseInt(getConstitution.getText().toString()));
                IAbilityScore intelligence = new AbilityScore(AbilityScoreEnum.INT, Integer.parseInt(getIntelligence.getText().toString()));
                IAbilityScore wisdom = new AbilityScore(AbilityScoreEnum.WIS, Integer.parseInt(getWisdom.getText().toString()));
                IAbilityScore charisma = new AbilityScore(AbilityScoreEnum.CHA, Integer.parseInt(getCharisma.getText().toString()));

                abilityScoresToReturn.add(strength);
                abilityScoresToReturn.add(dexterity);
                abilityScoresToReturn.add(constitution);
                abilityScoresToReturn.add(intelligence);
                abilityScoresToReturn.add(wisdom);
                abilityScoresToReturn.add(charisma);

                Intent i = new Intent().putExtra("UpdatedAbilityScores", (Serializable)abilityScoresToReturn);
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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }
}
