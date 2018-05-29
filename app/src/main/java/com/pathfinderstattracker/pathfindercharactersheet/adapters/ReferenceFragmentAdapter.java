package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;

/**
 * Created by Stephen Hagen on 2/20/2018.
 */

public class ReferenceFragmentAdapter extends FragmentPagerAdapter
{
    Fragment fragment;
    Bundle args;
    public ReferenceFragmentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                fragment = new StatsReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            case 1:
                fragment = new SkillsReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            case 2:
                fragment = new AbilityReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            case 3:
                fragment = new SpellReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            case 4:
                fragment = new InventoryReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            case 5:
                fragment = new EquipmentReferenceFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
                return fragment;
            //TODO: Make sure to remove the PlayerCharacterListFragment from this adapter once we're able to get it its own page
            case 6:
                fragment = new PlayerCharacterListFragment();
                args = new Bundle();
                args.putString("Foo", "Bar");
                fragment.setArguments(args);
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
        return 7;
    }

    public CharSequence getPageTitle(int position)
    {
        switch(position)//Todo: This implementation will work in a pinch, but if we ever need to add new fragments or rearrange our fragments, we should look up how to just ask the fragment its name
        {
            case 0:
                return "Stats Reference";
            case 1:
                return "Skills";
            case 2:
                return "Abilities";
            case 3:
                return "Spells";
            case 4:
                return "Inventory";
            case 5:
                return "Equipment";
            default:
                return "Error";
        }
    }
}
