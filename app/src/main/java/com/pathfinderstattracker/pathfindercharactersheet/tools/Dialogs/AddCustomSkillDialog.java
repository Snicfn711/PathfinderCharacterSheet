package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;

import java.util.ArrayList;
import java.util.UUID;

public class AddCustomSkillDialog extends DialogFragment
{
    private Spinner addedStatSpinner;
    private CheckBox armorCheckPenaltyCheckBox;
    private EditText customSkillNameEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Initialize our AbilityScoreEnum Array
        ArrayList<String> abilityScoreEnumList = new ArrayList<>();
        abilityScoreEnumList.add("Strength");
        abilityScoreEnumList.add("Dexterity");
        abilityScoreEnumList.add("Constitution");
        abilityScoreEnumList.add("Intelligence");
        abilityScoreEnumList.add("Wisdom");
        abilityScoreEnumList.add("Charisma");

        //Initialize our view and bind our controls
        View rootView = inflater.inflate(R.layout.add_custom_skill_dialog_view, container, false);
        addedStatSpinner = rootView.findViewById(R.id.AddCustomSkillAddedStatSpinner);
        armorCheckPenaltyCheckBox = rootView.findViewById(R.id.AddCustomSkillArmorCheckPenaltyCheckbox);
        customSkillNameEditText = rootView.findViewById(R.id.GetCustomSkillName);
        Button confirmButton = rootView.findViewById(R.id.AddCustomSkillConfirmButton);
        confirmButton.setOnClickListener(new ConfirmButtonOnClickListener());
        ArrayAdapter<String> addedStatAdapter = new ArrayAdapter<>(this.getContext(), R.layout.dropdown_item_view, abilityScoreEnumList);
        addedStatSpinner.setAdapter(addedStatAdapter);

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
            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, (int)(displayHeight * .4));
        }
    }

    private class ConfirmButtonOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
                ISkill customSkillToInsert = new Skill();
                customSkillToInsert.setSkillID(UUID.randomUUID());
                switch((String)addedStatSpinner.getSelectedItem())
                {
                    case "Strength":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.STR);
                        break;
                    case "Dexterity":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.DEX);
                        break;
                    case "Constitution":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.CON);
                        break;
                    case "Intelligence":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.INT);
                        break;
                    case "Wisdom":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.WIS);
                        break;
                    case "Charisma":
                        customSkillToInsert.setAddedStat(AbilityScoreEnum.CHA);
                        break;
                    default:
                        throw new RuntimeException("An Invalid AbilityScoreEnum Was Selected in the AddCustomSkillDialog");
                }
                customSkillToInsert.setArmorCheckPenaltyApplied(armorCheckPenaltyCheckBox.isChecked());
                customSkillToInsert.setSkillName(customSkillNameEditText.getText().toString());
                customSkillToInsert.setLevelUpPointsInvested(0);
                customSkillToInsert.setFavoredClassPointsInvested(0);

                Intent i = new Intent().putExtra("CustomSkillAdded", customSkillToInsert);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                dismiss();
        }
    }
}
