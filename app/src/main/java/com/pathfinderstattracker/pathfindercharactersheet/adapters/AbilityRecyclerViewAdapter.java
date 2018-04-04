package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbility;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.AbilityReferenceFragment.OnListFragmentInteractionListener;

import java.util.List;

import static com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher.SwitchVisibility;

/**
 * {@link RecyclerView.Adapter} that can display a {@link IAbility} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AbilityRecyclerViewAdapter extends RecyclerView.Adapter<AbilityRecyclerViewAdapter.ViewHolder>
{

    private final List<IAbility> mValues;
    private final OnListFragmentInteractionListener mListener;

    public AbilityRecyclerViewAdapter(List<IAbility> items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ability_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mItem = mValues.get(position);
        holder.abilityName.setText(holder.mItem.getName());
        holder.abilityShortDescription.setText(holder.mItem.getShortDescription());
        holder.abilityFullDescription.setText(holder.mItem.getEffectText());

        holder.recycledRow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                    SwitchVisibility(holder.abilityFullDescription);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final View recycledRow;
        private final TextView abilityName;
        private final TextView abilityShortDescription;
        //public final TextView abilitySource;
        //We want to track an ability's source, but until we implement character creation/ storage, we can't do so
        //(It can't be tracked on the ability object itself, since each ability may come from multiple sources)
        private final TextView abilityFullDescription;
        private IAbility mItem;

        private ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            abilityName = (TextView) view.findViewById(R.id.AbilityName);
            abilityShortDescription = (TextView) view.findViewById(R.id.ShortAbilityDescription);
            //abilitySource = (TextView) view.findViewById(R.id.content);
            abilityFullDescription = (TextView) view.findViewById(R.id.FullAbilityDescription);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + abilityName.getText() + "'";
        }
    }
}
