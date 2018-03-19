package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.SpellRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.ActionsEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.ArcaneSchoolEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.CastingTime;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.DescriptorEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.Spell;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellArea;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDurationEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellRangeEnum;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SpellReferenceFragment extends Fragment
{
    //region Temp Spells
    private Spell acidSplash = new Spell("Acid Splash",
                                    ArcaneSchoolEnum.Conjuration,
                                    new DescriptorEnum[]{DescriptorEnum.Acid},
                                    "None",
                                    "None",
                                    true,
                                    true,
                                    false,
                                    false,
                                    new CastingTime(ActionsEnum.Standard,
                                                    null,
                                                    1),
                                    SpellRangeEnum.Close,
                                    "Single Target",
                                    new SpellDuration(SpellDurationEnum.Instant,
                                                      null,
                                                      null),
                                    null,
                                    null,
                                    "Throw an orb of acid stupid that does 1d3 damage to a single target in range. Touch attack",
                                    "Hawk a loogie",
                                    1,
                                    new Damage(1,3),
                                    1,
                                    false,
                                    0);

    private Spell notAcidSplash = new Spell("Not Acid Splash",
            ArcaneSchoolEnum.Conjuration,
            new DescriptorEnum[]{DescriptorEnum.Acid},
            "None",
            "None",
            true,
            true,
            false,
            false,
            new CastingTime(ActionsEnum.Standard,
                    null,
                    1),
            SpellRangeEnum.Close,
            "Single Target",
            new SpellDuration(SpellDurationEnum.Instant,
                    null,
                    null),
            null,
            null,
            "Throw an orb of acid stupid that does 1d3 damage to a single target in range. Touch attack",
            "Hawk a loogie",
            1,
            new Damage(1,3),
            1,
            false,
            0);

    private Spell[] tempCantrips = new Spell[]{acidSplash, notAcidSplash};

    private Spell firstLevelAcidSplash = new Spell("First Level Acid Splash",
            ArcaneSchoolEnum.Conjuration,
            new DescriptorEnum[]{DescriptorEnum.Acid},
            "None",
            "None",
            true,
            true,
            false,
            false,
            new CastingTime(ActionsEnum.Standard,
                    null,
                    1),
            SpellRangeEnum.Close,
            "Single Target",
            new SpellDuration(SpellDurationEnum.Instant,
                    null,
                    null),
            null,
            null,
            "Throw an orb of acid stupid that does 1d3 damage to a single target in range. Touch attack",
            "Hawk a loogie",
            1,
            new Damage(1,3),
            1,
            false,
            1);

    private Spell notFirstLevelAcidSplash = new Spell("Not First Level Acid Splash",
            ArcaneSchoolEnum.Conjuration,
            new DescriptorEnum[]{DescriptorEnum.Acid},
            "None",
            "None",
            true,
            true,
            false,
            false,
            new CastingTime(ActionsEnum.Standard,
                    null,
                    1),
            SpellRangeEnum.Close,
            "Single Target",
            new SpellDuration(SpellDurationEnum.Instant,
                    null,
                    null),
            null,
            null,
            "Throw an orb of acid stupid that does 1d3 damage to a single target in range. Touch attack",
            "Hawk a loogie",
            1,
            new Damage(1,3),
            1,
            false,
            1);

    private Spell[] tempFirstLevelSpells = new Spell[]{acidSplash, notAcidSplash};
    //endregion

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SpellReferenceFragment()
    {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SpellReferenceFragment newInstance(int columnCount)
    {
        SpellReferenceFragment fragment = new SpellReferenceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final ConstraintLayout rootView = (ConstraintLayout)inflater.inflate(R.layout.spell_list_view, container, false);
        BindOnClickListeners(rootView);
        
        final RecyclerView cantripRecyclerView = rootView.findViewById(R.id.CantripsSpellsList);
        final SpellRecyclerViewAdapter cantripAdapter = new SpellRecyclerViewAdapter(tempCantrips, mListener);
        cantripRecyclerView.setAdapter(cantripAdapter);

        final RecyclerView firstLevelRecyclerView = rootView.findViewById(R.id.FirstLevelSpellsList);
        final SpellRecyclerViewAdapter firstLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(firstLevelAdapter);

        return rootView;
    }


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener)
        {
            mListener = (OnListFragmentInteractionListener) context;
        } else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ISpell item);
    }

    private void SwitchVisibility(View in)
    {
        if(in.getVisibility() == View.VISIBLE)
        {
            in.setVisibility(View.GONE);
        }
        else if(in.getVisibility() == View.GONE)
        {
            in.setVisibility(View.VISIBLE);
        }
        //If the view is invisible, we'll just leave it. While we may need to worry about visibilities elsewhere
        //this particular implementation probably won't be used many other places.
    }


    //Closes all spell lists by searching through the given layout to set their visiblities to gone
    private void CloseAllSpellLists(ConstraintLayout rootLayout)
    {
        for(int i = 0; i < rootLayout.getChildCount(); i++)
        {
            View v = rootLayout.getChildAt(i);
            if(v instanceof RecyclerView && v.getVisibility() != View.GONE)
            {
                v.setVisibility(View.GONE);
            }
        }
    }

    private void BindOnClickListeners(final ConstraintLayout rootLayout)
    {
        //Todo: It's weird to think that we need to set each onClickListener like this. See if we can't refactor this at some point
        //region Grab the spell lists
        final RecyclerView cantripsList = rootLayout.findViewById(R.id.CantripsSpellsList);
        final RecyclerView firstLevelList = rootLayout.findViewById(R.id.FirstLevelSpellsList);
        final RecyclerView secondLevelList = rootLayout.findViewById(R.id.SecondLevelSpellsList);
        final RecyclerView thirdLevelList = rootLayout.findViewById(R.id.ThirdLevelSpellsList);
        final RecyclerView fourthLevelList = rootLayout.findViewById(R.id.FourthLevelSpellsList);
        final RecyclerView fifthLevelList = rootLayout.findViewById(R.id.FifthLevelSpellsList);
        final RecyclerView sixthLevelList = rootLayout.findViewById(R.id.SixthLevelSpellsList);
        final RecyclerView seventhLevelList = rootLayout.findViewById(R.id.SeventhLevelSpellsList);
        final RecyclerView eightLevelList = rootLayout.findViewById(R.id.EighthLevelSpellsList);
        final RecyclerView ninthLevelList = rootLayout.findViewById(R.id.NinthLevelSpellsList);
        //endregion

        //region Grab the headers
        RelativeLayout cantripsSectionHeader = rootLayout.findViewById(R.id.CantripsSpellSectionHeader);
        RelativeLayout firstLevelSectionHeader = rootLayout.findViewById(R.id.FirstLevelSpellSectionHeader);
        RelativeLayout secondLevelSectionHeader = rootLayout.findViewById(R.id.SecondLevelSpellSectionHeader);
        RelativeLayout thirdLevelSectionHeader = rootLayout.findViewById(R.id.ThirdLevelSpellSectionHeader);
        RelativeLayout fourthLevelSectionHeader = rootLayout.findViewById(R.id.FourthLevelSpellSectionHeader);
        RelativeLayout fifthLevelSectionHeader = rootLayout.findViewById(R.id.FifthLevelSpellSectionHeader);
        RelativeLayout sixthLevelSectionHeader = rootLayout.findViewById(R.id.SixthLevelSpellSectionHeader);
        RelativeLayout seventhLevelSectionHeader = rootLayout.findViewById(R.id.SeventhLevelSpellSectionHeader);
        RelativeLayout eightLevelSectionHeader = rootLayout.findViewById(R.id.EighthLevelSpellSectionHeader);
        RelativeLayout ninthLevelSectionHeader = rootLayout.findViewById(R.id.NinthLevelSpellSectionHeader);
        //endregion

        //region Set the OnClickListeners
        cantripsSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                cantripsList.setVisibility(View.VISIBLE);
            }
        });

        firstLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                firstLevelList.setVisibility(View.VISIBLE);
            }
        });

        secondLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                secondLevelList.setVisibility(View.VISIBLE);
            }
        });

        thirdLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                thirdLevelList.setVisibility(View.VISIBLE);
            }
        });

        fourthLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                fourthLevelList.setVisibility(View.VISIBLE);
            }
        });

        fifthLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                fifthLevelList.setVisibility(View.VISIBLE);
            }
        });

        sixthLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                sixthLevelList.setVisibility(View.VISIBLE);
            }
        });

        seventhLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                seventhLevelList.setVisibility(View.VISIBLE);
            }
        });

        eightLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                eightLevelList.setVisibility(View.VISIBLE);
            }
        });

        ninthLevelSectionHeader.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                CloseAllSpellLists(rootLayout);
                ninthLevelList.setVisibility(View.VISIBLE);
            }
        });
        //endregion
    }

}
