package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AbilityScoreAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityScoreEnum;

public class StatsScreen extends Activity
{

    private AbilityScore strength = new AbilityScore(AbilityScoreEnum.Strength, 10);
    private AbilityScore dexterity = new AbilityScore(AbilityScoreEnum.Dexterity, 10);
    private AbilityScore constiution = new AbilityScore(AbilityScoreEnum.Constitution, 10);
    private AbilityScore intelligence = new AbilityScore(AbilityScoreEnum.Intelligence, 10);
    private AbilityScore wisdom = new AbilityScore(AbilityScoreEnum.Wisdom, 10);
    private AbilityScore charisma = new AbilityScore(AbilityScoreEnum.Charisma, 10);
    private AbilityScore[] tempStats = new AbilityScore[] {strength, dexterity, constiution, intelligence, wisdom, charisma};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_screen);
        GridView gridView = (GridView)findViewById(R.id.acGrid);
        AbilityScoreAdapter abilityScoreAdapter = new AbilityScoreAdapter(this,tempStats);
        gridView.setAdapter(abilityScoreAdapter);
    }
}
