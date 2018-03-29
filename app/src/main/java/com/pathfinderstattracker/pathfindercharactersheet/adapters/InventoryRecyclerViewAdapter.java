package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IItem;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.InventoryReferenceFragment.OnListFragmentInteractionListener;
import static com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher.SwitchVisibility;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link IItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class InventoryRecyclerViewAdapter extends RecyclerView.Adapter<InventoryRecyclerViewAdapter.ViewHolder>
{

    private final List<IItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public InventoryRecyclerViewAdapter(List<IItem> items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inventory_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mItem = mValues.get(position);
        holder.itemName.setText(holder.mItem.getName());
        holder.itemCost.setText(Double.toString(holder.mItem.getCost()));
        holder.itemWeight.setText(Double.toString(holder.mItem.getWeightAtMediumSize()));
        holder.itemDetails.setText(holder.mItem.getDescription());


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
                    SwitchVisibility(holder.itemDetails);
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
        private final TextView itemName;
        private final TextView itemCost;
        private final TextView itemWeight;
        private final TextView itemDetails;
        private IItem mItem;

        private ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            itemName = view.findViewById(R.id.ItemName);
            itemCost = view.findViewById(R.id.ItemCost);
            itemWeight = view.findViewById(R.id.ItemWeight);
            itemDetails = view.findViewById(R.id.ItemDetails);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + mItem.toString() + "'";
        }
    }
}
