package com.pathfinderstattracker.pathfindercharactersheet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsScreen;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsScreenFragment;

public class MainActivity extends FragmentActivity implements StatsScreenFragment.OnFragmentInteractionListener
{
    ReferenceFragmentAdapter referenceFragmentAdapter;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referenceFragmentAdapter = new ReferenceFragmentAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(referenceFragmentAdapter);

    }

    public void navigateToStatsScreen()
    {
        Intent intent = new Intent(this, StatsScreen.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}
