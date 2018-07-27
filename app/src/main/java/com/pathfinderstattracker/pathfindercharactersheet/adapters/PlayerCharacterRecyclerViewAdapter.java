package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.PlayerCharacterListFragment.OnListFragmentInteractionListener;

import java.util.List;

//TODO:Properly implement our player character screen
public class PlayerCharacterRecyclerViewAdapter extends RecyclerView.Adapter<PlayerCharacterRecyclerViewAdapter.ViewHolder> {

    private Animation click;
    private final List<IPlayerCharacter> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PlayerCharacterRecyclerViewAdapter(List<IPlayerCharacter> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_character_row_view, parent, false);
        click = AnimationUtils.loadAnimation(parent.getContext(), R.anim.roll_button_click);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.playerCharacter = mValues.get(position);
        holder.playerCharacterName.setText(holder.playerCharacter.getPlayerCharacterName());
        holder.playerCharacterCharacterLevel.setText(Integer.toString(holder.playerCharacter.getCharacterLevel()));
        if(holder.playerCharacter.getCharacterRace() == null)
        {
            holder.playerCharacterRace.setText("-");
        }
        else
        {
            holder.playerCharacterRace.setText(holder.playerCharacter.getCharacterRace().toString());
        }
        //We're not actually associating the character with a class yet, so for now will just use a placeholder
        holder.playerCharacterClass.setText("-");



        holder.recycledRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    holder.recycledRow.startAnimation(click);
                    mListener.onListFragmentInteraction(holder.playerCharacter);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View recycledRow;
        private final TextView playerCharacterName;
        private final TextView playerCharacterCharacterLevel;
        private final TextView playerCharacterRace;
        private final TextView playerCharacterClass;
        private IPlayerCharacter playerCharacter;

        public ViewHolder(View view) {
            super(view);
            recycledRow = view;
            playerCharacterName = view.findViewById(R.id.PlayerCharacterName);
            playerCharacterCharacterLevel = view.findViewById(R.id.PlayerCharacterTotalLevel);
            playerCharacterRace = view.findViewById(R.id.PlayerCharacterRace);
            playerCharacterClass = view.findViewById(R.id.PlayerCharacterClass);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + playerCharacterName.getText() + "'";
        }
    }
}
