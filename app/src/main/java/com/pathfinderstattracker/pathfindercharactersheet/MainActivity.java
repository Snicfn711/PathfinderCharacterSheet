package com.pathfinderstattracker.pathfindercharactersheet;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;

public class MainActivity extends FragmentActivity implements StatsReferenceFragment.OnFragmentInteractionListener, SkillsReferenceFragment.OnListFragmentInteractionListener, EquipmentReferenceFragment.OnListFragmentInteractionListener, SpellReferenceFragment.OnListFragmentInteractionListener, InventoryReferenceFragment.OnListFragmentInteractionListener
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

    @Override
    public void onListFragmentInteraction(ISpell item)
    {

    }

    @Override
    public void onListFragmentInteraction(IItem item)
    {

    }
}
