package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsScreenFragment;

/**
 * Created by Stephen Hagen on 2/20/2018.
 */

public class ReferenceFragmentAdapter extends FragmentPagerAdapter
{
    public ReferenceFragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = new StatsScreenFragment();
        Bundle args = new Bundle();
        args.putString("Foo", "Bar");
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount()
    {
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //Unsurprisingly, the count here should be the number of fragments you want to include.      //
        //We should be able to get away with hardcoding this because FragmentPagerAdapter assumes a  //
        //small, static group of fragments.                                                          //
        ///////////////////////////////////////////////////////////////////////////////////////////////
        return 2;
    }

    public CharSequence getPageTitle(int position)
    {
        return Integer.toString(position + 1);
    }
}
