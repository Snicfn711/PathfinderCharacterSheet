package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.models.SkillForDisplay;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.ViewHolder>
{

    private final List<SkillForDisplay> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Animation click;

    public SkillRecyclerViewAdapter(List<SkillForDisplay> items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_row_view, parent, false);
        click = AnimationUtils.loadAnimation(parent.getContext(), R.anim.roll_button_click);
        final ImageButton rollButton = view.findViewById(R.id.RollSkill);
        rollButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rollButton.startAnimation(click);
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        holder.mSkill = mValues.get(position);
        //holder.isClassSkill.setChecked(mValues.get(position).isProficiency());
        holder.skillName.setText(mValues.get(position).getSkillName());
        holder.skillTotal.setText(Integer.toString(mValues.get(position).getTotalSkillScore()));
        holder.skillStat.setText(mValues.get(position).getAddedStat().toString());

        holder.recycledRow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (null != mListener)
                {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mSkill);
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
        private final CheckBox isClassSkill;
        private final TextView skillName;
        private final TextView skillStat;
        private final TextView skillTotal;
        private SkillForDisplay mSkill;

        private ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            isClassSkill =  view.findViewById(R.id.IsClassSkill);
            skillName =  view.findViewById(R.id.SkillName);
            skillStat = view.findViewById(R.id.SkillStat);
            skillTotal = view.findViewById(R.id.SkillTotal);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + skillName.getText() + "'";
        }
    }
}
