package com.pathfinderstattracker.pathfindercharactersheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsScreen;

public class MainActivity extends Activity
{
    private Button navigateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateButton = this.findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                navigateToStatsScreen();
            }
        });
    }

    public void navigateToStatsScreen()
    {
        Intent intent = new Intent(this, StatsScreen.class);
        startActivity(intent);
    }
}
