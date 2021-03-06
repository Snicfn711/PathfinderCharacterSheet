package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.PlayerCharacterRecyclerViewAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.PlayerCharacterNameAndIDEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class PlayerCharacterListFragment extends Fragment implements PathfinderRepository.GetListOfPlayerCharactersAsyncTaskFinishedListener
{
    private OnListFragmentInteractionListener mListener;
    private Animation click;
    private PathfinderRepository repository;
    private View rootView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlayerCharacterListFragment()
    {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PlayerCharacterListFragment newInstance(int columnCount)
    {
        //We don't have any parameters yet, so we're not doing anything here
        PlayerCharacterListFragment fragment = new PlayerCharacterListFragment();
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
        rootView = inflater.inflate(R.layout.player_character_fragment_view, container, false);
        Context context = rootView.getContext();

        //Request a list of character names and their UUIDs from the db. The data is returned via listener callback below
        repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestPlayerCharacterList(this);

        //Set our animation for adding new player characters
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final ImageButton addNewPlayerCharacterButton = rootView.findViewById(R.id.AddNewCharacter);

        addNewPlayerCharacterButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addNewPlayerCharacterButton.startAnimation(click);
                mListener.AddNewCharacter();
            }
        }));

        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onGetListOfPlayerCharacterAsyncTaskFinished(List<IPlayerCharacter> playerCharacters)
    {
        List<IPlayerCharacter> characterListToDisplay = playerCharacters;

        final RecyclerView recyclerView =  rootView.findViewById(R.id.PlayerCharacterRecycler);
        final PlayerCharacterRecyclerViewAdapter playerCharacterAdapter = new PlayerCharacterRecyclerViewAdapter(characterListToDisplay, mListener);
        recyclerView.setAdapter(playerCharacterAdapter);
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
        public void AddNewCharacter();
        void onListFragmentInteraction(IPlayerCharacter item);
    }
}
