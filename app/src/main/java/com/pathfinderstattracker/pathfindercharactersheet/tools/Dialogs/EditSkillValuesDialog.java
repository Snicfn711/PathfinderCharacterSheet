package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher;

import java.util.List;
import java.util.UUID;

public class EditSkillValuesDialog extends DialogFragment implements PathfinderRepository.GetPlayerSkillEntityAsyncTaskFinishedListener
{
    private View rootView;
    private PathfinderRepository repository;

    private EditText getLevelUpPoints;
    private EditText getFavoredClassPoints;
    private Button deleteSkillButton;
    private UUID currentSkillID;
    private PlayerSkillsEntity currentPlayerSkill;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        repository = new PathfinderRepository(this.getActivity().getApplication());
        rootView = inflater.inflate(R.layout.edit_player_character_skill_values_dialog_view, container,false);

        getLevelUpPoints = rootView.findViewById(R.id.GetLevelUpSkillPoints);
        getLevelUpPoints.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getLevelUpPoints.setText("");
                }
            }
        });

        getFavoredClassPoints = rootView.findViewById(R.id.GetFavoredClassPoints);
        getFavoredClassPoints.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    getFavoredClassPoints.setText("");
                }
            }
        });

        currentSkillID = (UUID)getArguments().getSerializable("CurrentSkillID");
        UUID currentPlayerCharacterID = (UUID) getArguments().getSerializable("CurrentPlayerCharacterID");
        Boolean isFeatCustom = getArguments().getBoolean("IsFeatCustom");
        deleteSkillButton = rootView.findViewById(R.id.DeleteSkillButton);
        if(isFeatCustom)
        {
            deleteSkillButton.setVisibility(View.VISIBLE);
        }

        repository.requestPlayerSkillEntity(this, currentPlayerCharacterID);
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

    @Override
    public void onGetPlayerSkillEntityAsyncTaskFinished(List<PlayerSkillsEntity> result)
    {
        for(PlayerSkillsEntity playerSkillsEntity : result)
        {
            if(playerSkillsEntity.getSkillID().equals(currentSkillID))
            {
                getLevelUpPoints.setText(Integer.toString(playerSkillsEntity.getLevelUpPointsInvested()));
                getFavoredClassPoints.setText(Integer.toString(playerSkillsEntity.getFavoredClassPointsInvested()));
                currentPlayerSkill = playerSkillsEntity;
            }
        }

        ImageButton getSkillPointsButton = rootView.findViewById(R.id.SaveSkillChanges);
        getSkillPointsButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            if(getLevelUpPoints.getText().toString().isEmpty())
            {
                getLevelUpPoints.requestFocus();
            }
            else if(getFavoredClassPoints.getText().toString().isEmpty())
            {
                getFavoredClassPoints.requestFocus();
            }
            else if(!getLevelUpPoints.getText().toString().isEmpty()&&
                    !getFavoredClassPoints.getText().toString().isEmpty())
            {
                currentPlayerSkill.setFavoredClassPointsInvested(Integer.parseInt(getFavoredClassPoints.getText().toString()));
                currentPlayerSkill.setLevelUpPointsInvested(Integer.parseInt(getLevelUpPoints.getText().toString()));

                repository.updatePlayerSkillEntity(currentPlayerSkill);
                Intent returnIntent = new Intent().putExtra("UpdatedSkill", currentPlayerSkill);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, returnIntent);
                dismiss();
            }
        }
        });

        deleteSkillButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        switch(which)
                        {
                            case DialogInterface.BUTTON_POSITIVE:
                                repository.deletePlayerSkillEntity(currentPlayerSkill);
                                Intent returnIntent = new Intent().putExtra("DeletedSkill", currentPlayerSkill);
                                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, returnIntent);
                                dismiss();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Are you sure you want to delete the " + currentPlayerSkill.getSkillName() + " skill?")
                       .setPositiveButton("Yes", dialogClickListener)
                       .setNegativeButton("No", dialogClickListener)
                       .show();
            }
        });
    }
}
