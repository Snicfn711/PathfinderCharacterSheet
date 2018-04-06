package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AbilityRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.AbilityTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;

import java.util.ArrayList;
import java.util.List;

public class AbilityReferenceFragment extends Fragment
{
    //region Temp Abilities
    private Ability punch = new Ability("Punch", AbilityTypeEnum.ExtraOrdinary, "Punch People IN THE FACE for 1 million damage", null, null, null,"Punch");
    private Ability kick = new Ability("Kick", AbilityTypeEnum.ExtraOrdinary, "Kick people in the CROTCH for 1 damage", null, null, null, "Kick");
    private List<IAbility> tempAbilities = new ArrayList<IAbility>();
    //endregion

    // TODO: Customize parameter argument names
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;
    private Animation click;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AbilityReferenceFragment()
    {
    }

    @SuppressWarnings("unused")
    public static AbilityReferenceFragment newInstance(int columnCount)
    {
        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here yet
        AbilityReferenceFragment fragment = new AbilityReferenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        tempAbilities.add(punch);
        tempAbilities.add(kick);
        if (getArguments() != null)
        {
            //Like above, since we don't have any paramters yet, there's not much to do here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.ability_fragment_view, container, false);
        Context context = rootView.getContext();
        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.AbilityList);
        final AbilityRecyclerViewAdapter abilityRecyclerViewAdapter = new AbilityRecyclerViewAdapter(tempAbilities, mListener);
        recyclerView.setAdapter(abilityRecyclerViewAdapter);

        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final ImageButton addAbilityButton = rootView.findViewById(R.id.AddAbilityButton);
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
        void onListFragmentInteraction(IAbility item);
    }
}
