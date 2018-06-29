package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.ReferenceFragmentAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.models.Skill;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;

public class ParentReferenceFragment extends Fragment
{
    ReferenceFragmentAdapter referenceFragmentAdapter;
    ViewPager mViewPager;
    private OnFragmentInteractionListener mListener;

    public ParentReferenceFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentReferenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentReferenceFragment newInstance(String param1, String param2) {
        ParentReferenceFragment fragment = new ParentReferenceFragment();
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
        View rootView = inflater.inflate(R.layout.parent_reference_fragment, container, false);
        referenceFragmentAdapter = new ReferenceFragmentAdapter(getFragmentManager());
        referenceFragmentAdapter.setArgs(getArguments());
        mViewPager = (ViewPager)rootView.findViewById(R.id.referenceFragmentPager);
        mViewPager.setAdapter(referenceFragmentAdapter);
        // Inflate the layout for this fragment
        return rootView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void UpdateCharacter(IPlayerCharacter updatedCharacter)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("PlayerCharacter", updatedCharacter);
        referenceFragmentAdapter.setArgs(bundle);
        referenceFragmentAdapter.notifyDataSetChanged();
    }

    public void RefreshSkills()
    {
        referenceFragmentAdapter.notifyDataSetChanged();
    }
}
