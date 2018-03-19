package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.icu.util.IslamicCalendar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.spells.ISpell;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SpellReferenceFragment.OnListFragmentInteractionListener;
import com.pathfinderstattracker.pathfindercharactersheet.views.SpellDetailView;

import org.w3c.dom.Text;

import java.util.List;

public class SpellRecyclerViewAdapter extends RecyclerView.Adapter<SpellRecyclerViewAdapter.ViewHolder>
{

    private final ISpell[] mValues;
    private final OnListFragmentInteractionListener mListener;

    public SpellRecyclerViewAdapter(ISpell[] items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spell_row_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mSpell = mValues[position];
        holder.spellName.setText(mValues[position].getSpellName());
        holder.shortSpellDescription.setText(mValues[position].getShortDescription());

        holder.recycledRow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mSpell);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mValues.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View recycledRow;
        public final TextView spellName;
        public final TextView shortSpellDescription;
        public final SpellDetailView spellDetailView;
        public ISpell mSpell;

        public ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            spellName = view.findViewById(R.id.SpellName);
            shortSpellDescription = view.findViewById(R.id.SpellShortDescription);
            spellDetailView = view.findViewById(R.id.SpellDetailView);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + mSpell.toString() + "'";
        }
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
}
