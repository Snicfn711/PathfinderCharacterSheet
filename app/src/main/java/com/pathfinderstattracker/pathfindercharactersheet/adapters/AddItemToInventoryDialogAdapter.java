package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AddArmorToInventoryFragment;

public class AddItemToInventoryDialogAdapter extends FragmentPagerAdapter
{
    Fragment fragment;
    Bundle args;
    public AddItemToInventoryDialogAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                fragment = new AddArmorToInventoryFragment();
                return fragment;
            default:
                return fragment;
        }

    }

    @Override
    public int getCount()
    {
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //Unsurprisingly, the count here should be the number of fragments you want to include.      //
        //We should be able to get away with hardcoding this because FragmentPagerAdapter assumes a  //
        //small, static group of fragments.                                                          //
        ///////////////////////////////////////////////////////////////////////////////////////////////
        return 1;
    }

    public CharSequence getPageTitle(int position)
    {
        switch(position)//Todo: This implementation will work in a pinch, but if we ever need to add new fragments or rearrange our fragments, we should look up how to just ask the fragment its name
        {
            case 0:
                return "Armor";
            default:
                return "Error";
        }
    }

    public void setArgs(Bundle args)
    {
        this.args = args;
    }

    public int getItemPosition(Object item)
    {
        return POSITION_NONE;
    }
}

