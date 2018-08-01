package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

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
                                    new ArrayList<DescriptorEnum>(){{add(DescriptorEnum.Acid);}},
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
            new ArrayList<DescriptorEnum>(){{add(DescriptorEnum.Acid);}},
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
            new ArrayList<DescriptorEnum>(){{add(DescriptorEnum.Acid);}},
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
            new ArrayList<DescriptorEnum>(){{add(DescriptorEnum.Acid);}},
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
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;

    private Animation click;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SpellReferenceFragment()
    {
    }


    @SuppressWarnings("unused")
    public static SpellReferenceFragment newInstance(int columnCount)
    {
        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here yet
        SpellReferenceFragment fragment = new SpellReferenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final ConstraintLayout rootView = (ConstraintLayout)inflater.inflate(R.layout.spell_fragment_view, container, false);
        Context context = rootView.getContext();
        BindOnClickListeners(rootView);

        //region Set Spell Recycler View Adapters
        final RecyclerView cantripRecyclerView = rootView.findViewById(R.id.CantripSpellsList);
        final SpellRecyclerViewAdapter cantripAdapter = new SpellRecyclerViewAdapter(tempCantrips, mListener);
        cantripRecyclerView.setAdapter(cantripAdapter);

        final RecyclerView firstLevelRecyclerView = rootView.findViewById(R.id.FirstLevelSpellsList);
        final SpellRecyclerViewAdapter firstLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(firstLevelAdapter);

        final RecyclerView secondLevelRecyclerView = rootView.findViewById(R.id.SecondLevelSpellsList);
        final SpellRecyclerViewAdapter secondLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(secondLevelAdapter);

        final RecyclerView thirdLevelRecyclerView = rootView.findViewById(R.id.ThirdLevelSpellsList);
        final SpellRecyclerViewAdapter thirdLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(thirdLevelAdapter);

        final RecyclerView fourthLevelRecyclerView = rootView.findViewById(R.id.FourthLevelSpellsList);
        final SpellRecyclerViewAdapter fourthLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(fourthLevelAdapter);

        final RecyclerView fifthLevelRecyclerView = rootView.findViewById(R.id.FifthLevelSpellsList);
        final SpellRecyclerViewAdapter fifthLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(fifthLevelAdapter);

        final RecyclerView sixthLevelRecyclerView = rootView.findViewById(R.id.SixthLevelSpellsList);
        final SpellRecyclerViewAdapter sixthLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(sixthLevelAdapter);

        final RecyclerView seventhLevelRecyclerView = rootView.findViewById(R.id.SeventhLevelSpellsList);
        final SpellRecyclerViewAdapter seventhLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(seventhLevelAdapter);

        final RecyclerView eighthLevelRecyclerView = rootView.findViewById(R.id.EighthLevelSpellsList);
        final SpellRecyclerViewAdapter eighthLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(eighthLevelAdapter);

        final RecyclerView ninthLevelRecyclerView = rootView.findViewById(R.id.NinthLevelSpellsList);
        final SpellRecyclerViewAdapter ninthLevelAdapter = new SpellRecyclerViewAdapter(tempFirstLevelSpells, mListener);
        firstLevelRecyclerView.setAdapter(ninthLevelAdapter);
        //endregion

        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final ImageButton addAbilityButton = rootView.findViewById(R.id.AddSpellButton);
        addAbilityButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addAbilityButton.startAnimation(click);
            }
        }));
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
            final View sectionView = rootLayout.getChildAt(i);
            View tempSpellList = sectionView.findViewWithTag("SpellList");
            //If we don't check for null values before adding to the lists, the lists continue growing in size, causing null pointer references when we try to bind our onClickListeners
            if(tempSpellList != null)
            {
                spellLists.add(tempSpellList);
            }
            View tempSpellHeader = sectionView.findViewWithTag("SpellHeader");
            if(tempSpellHeader != null)
            {

                headerList.add(tempSpellHeader);
            }
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
