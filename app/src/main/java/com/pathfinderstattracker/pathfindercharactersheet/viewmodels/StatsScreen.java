package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AbilityScoreAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.MovementAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.Movement;
import com.pathfinderstattracker.pathfindercharactersheet.models.races.MovementManeuverabilityEnum;

public class StatsScreen extends Activity
{


    //region Test Ability Scores
    private AbilityScore strength = new AbilityScore(AbilityScoreEnum.Strength, 10);
    private AbilityScore dexterity = new AbilityScore(AbilityScoreEnum.Dexterity, 11);
    private AbilityScore constiution = new AbilityScore(AbilityScoreEnum.Constitution, 12);
    private AbilityScore intelligence = new AbilityScore(AbilityScoreEnum.Intelligence, 13);
    private AbilityScore wisdom = new AbilityScore(AbilityScoreEnum.Wisdom, 14);
    private AbilityScore charisma = new AbilityScore(AbilityScoreEnum.Charisma, 15);
    private AbilityScore[] tempStats = new AbilityScore[] {strength, dexterity, constiution, intelligence, wisdom, charisma};
    //endregion

    //region Test Movements
    private Movement base = new Movement("Base", 30, MovementManeuverabilityEnum.Perfect);
    private Movement armor = new Movement("Armor", 20, MovementManeuverabilityEnum.Perfect);
    private Movement fly = new Movement("Fly", 30, MovementManeuverabilityEnum.Perfect);
    private Movement swim = new Movement("Swim", 30, MovementManeuverabilityEnum.Perfect);
    private Movement climb = new Movement("Climb", 30, MovementManeuverabilityEnum.Perfect);
    private Movement burrow = new Movement("Burrow", 30, MovementManeuverabilityEnum.Perfect);
    private Movement[] tempMovement = new Movement[]{base,armor,fly,swim,climb,burrow};
    //endregion



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_screen);

        //Populate and bind our stats list
        ListView statsView = findViewById(R.id.statsList);
        AbilityScoreAdapter abilityScoreAdapter = new AbilityScoreAdapter(this,tempStats);
        statsView.setAdapter(abilityScoreAdapter);

        //Populate and bond our movement list
        ListView movementView = findViewById(R.id.movementList);
        MovementAdapter movementAdapter = new MovementAdapter(this, tempMovement);
        movementView.setAdapter(movementAdapter);
    }
}
