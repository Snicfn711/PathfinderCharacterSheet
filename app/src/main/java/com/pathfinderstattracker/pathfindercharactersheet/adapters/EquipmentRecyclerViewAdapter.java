package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class EquipmentRecyclerViewAdapter extends RecyclerView.Adapter<EquipmentRecyclerViewAdapter.ViewHolder>
{

    private final IEquipment[] mValues;
    private final OnListFragmentInteractionListener mListener;

    public EquipmentRecyclerViewAdapter(IEquipment[] items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.equipment_row_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mEquipment = mValues[position];
        if(mValues[position].getMagicBonus() > 0)
        {
            holder.magicBonus.setText("+" + Integer.toString(mValues[position].getMagicBonus()));
        }
        else
        {
            holder.magicBonus.setVisibility(View.GONE);
        }
        if(position == 1)
        {
            holder.abilities.setText("Flaming"); //Todo: We're copping out here until abilities get implemented.
        }
        else
        {
            holder.abilities.setVisibility(View.GONE);
        }
        holder.equipmentName.setText(mValues[position].getName());
        holder.equipmentLabel.setText(mValues[position].getClass().getSimpleName());

        holder.recycledRow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mEquipment);
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
        private final View recycledRow;
        private final TextView magicBonus;
        private final TextView abilities;
        private final TextView equipmentName;
        private final TextView equipmentLabel;
        private IEquipment mEquipment;

        public ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            magicBonus =  view.findViewById(R.id.MagicBonus);
            abilities = view.findViewById(R.id.EquipmentAbilities);
            equipmentName = view.findViewById(R.id.EquipmentName);
            equipmentLabel = view.findViewById(R.id.EquipmentLabel);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + equipmentName.getText() + "'";
        }
    }
}
