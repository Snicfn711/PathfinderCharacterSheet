package com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerSkillsEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SkillForDisplay;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EditSkillValuesDialog extends DialogFragment implements PathfinderRepository.GetPlayerSkillEntityAsyncTaskFinishedListener
{
    private EditText getLevelUpPoints;
    private EditText getFavoredClassPoints;
    private UUID currentSkillID;
    private UUID currentPlayerCharacterID;
    private View rootView;
    private PathfinderRepository repository;

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
        currentPlayerCharacterID = (UUID)getArguments().getSerializable("CurrentPlayerCharacterID");

        repository.requestPlayerSkillEntity(this, currentPlayerCharacterID, currentSkillID);
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
    public void onGetPlayerSkillEntityAsyncTaskFinished(PlayerSkillsEntity result)
    {
        getLevelUpPoints.setText(Integer.toString(result.getLevelUpPointsInvested()));
        getFavoredClassPoints.setText(Integer.toString(result.getFavoredClassPointsInvested()));

        ImageButton getSkillPointsButton = rootView.findViewById(R.id.SaveSkillChanges);
        getSkillPointsButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v)
        {
            if(getLevelUpPoints.getText().toString().isEmpty() ||
                    getFavoredClassPoints.getText().toString().isEmpty())
            {
                //If any of the fields are empty, it means the user took the time to clear them out,
                //and we don't them to be able to return to the main screen until they've fixed that
            }
            else
            {
                PlayerSkillsEntity playerSkillsEntityToReturn = new PlayerSkillsEntity();
                playerSkillsEntityToReturn.setPlayerID(currentPlayerCharacterID);
                playerSkillsEntityToReturn.setSkillID(currentSkillID);
                playerSkillsEntityToReturn.setFavoredClassPointsInvested(Integer.parseInt(getFavoredClassPoints.getText().toString()));
                playerSkillsEntityToReturn.setLevelUpPointsInvested(Integer.parseInt(getLevelUpPoints.getText().toString()));

                Intent i = new Intent().putExtra("PlayerSkillEntityToUpdate", (Serializable)playerSkillsEntityToReturn);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
                dismiss();
            }
        }
        });
    }
}
