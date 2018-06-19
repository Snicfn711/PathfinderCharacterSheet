package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepositoryListener;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.StatsReferenceFragment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment;

import java.util.List;

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
                fragment.setArguments(args);
                return fragment;
            case 1:
                fragment = new SkillsReferenceFragment();
                fragment.setArguments(args);
                return fragment;
            case 2:
                fragment = new AbilityReferenceFragment();
                fragment.setArguments(args);
                return fragment;
            case 3:
                fragment = new SpellReferenceFragment();
                fragment.setArguments(args);
                return fragment;
            case 4:
                fragment = new InventoryReferenceFragment();
                fragment.setArguments(args);
                return fragment;
            case 5:
                fragment = new EquipmentReferenceFragment();
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
        return 6;
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

    public void setArgs(Bundle args)
    {
        this.args = args;
    }

    public int getItemPosition(Object item)
    {
        return POSITION_NONE;
    }
}
