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
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellAreaEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDuration;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellDurationEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.SpellRangeEnum;

import java.util.ArrayList;

import static com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher.SwitchVisibility;

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
            new SpellArea(SpellAreaEnum.Cone, 30),
            null,
            "This spell doesn't actually exist",
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

    private Spell[] tempFirstLevelSpells = new Spell[]{firstLevelAcidSplash, notFirstLevelAcidSplash};
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
        
        final RecyclerView cantripRecyclerView = rootView.findViewById(R.id.CantripSpellsList);
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

    private void BindOnClickListeners(final ConstraintLayout rootLayout)
    {
        int sectionCount = rootLayout.getChildCount();

        final ArrayList<View> spellLists = new ArrayList<>();
        final ArrayList<View> headerList = new ArrayList<>();

        //For each section of spells(Cantrips, First Level Spells, etc)  find the tagged views for the spell list and it's headers
        for(int i = 0; i < sectionCount; i++)
        {
            final ViewGroup sectionView = (ViewGroup)rootLayout.getChildAt(i);
            spellLists.add(sectionView.findViewWithTag("SpellList"));
            headerList.add(sectionView.findViewWithTag("SpellHeader"));
        }

        //Iterate through our list of headers, and for each header, bind our onClickListener to open/close the appropriate SpellList
        for(int i = 0; i < headerList.size(); i++)
        {
            View currentHeader = headerList.get(i);
            final View currentSpellList = spellLists.get(i);

            currentHeader.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    SwitchVisibility(currentSpellList);
                    if(currentSpellList.getVisibility() == View.GONE)
                    {
                        final ArrayList<View> spellSummaryList = new ArrayList<>();
                        final ArrayList<View> spellDetailList = new ArrayList<>();

                        spellSummaryList.add(currentSpellList.findViewWithTag("SpellSummary"));
                        spellDetailList.add(currentSpellList.findViewWithTag("SpellDetail"));

                        for(View i: spellSummaryList)
                        {
                            i.setVisibility(View.VISIBLE);
                        }
                        for(View i: spellDetailList)
                        {
                            i.setVisibility(View.GONE);
                        }
                    }
                }
            });
        }
    }
}
