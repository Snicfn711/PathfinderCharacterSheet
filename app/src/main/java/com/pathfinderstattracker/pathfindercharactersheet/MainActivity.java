package com.pathfinderstattracker.pathfindercharactersheet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;

import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.ReferenceStatsFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsFragment;

public class MainActivity extends FragmentActivity implements ReferenceStatsFragment.OnFragmentInteractionListener, SkillsFragment.OnListFragmentInteractionListener, EquipmentFragment.OnListFragmentInteractionListener
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

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onListFragmentInteraction(ISkill item)
    {

    }


    @Override
    public void onListFragmentInteraction(IEquipment item)
    {

    }
}
