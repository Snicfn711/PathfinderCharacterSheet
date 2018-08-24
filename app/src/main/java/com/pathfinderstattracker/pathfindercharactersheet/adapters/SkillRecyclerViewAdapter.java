package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v4.app.Fragment;
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
import com.pathfinderstattracker.pathfindercharactersheet.models.IAbilityScore;
import com.pathfinderstattracker.pathfindercharactersheet.models.ISkill;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.SkillsReferenceFragment.OnListFragmentInteractionListener;

import java.util.List;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.ViewHolder>
{
    private final List<ISkill> mValues;
    private final List<IAbilityScore> currentPlayerCharacterAbilityScores;
    private final OnListFragmentInteractionListener mListener;
    private final OnRollSkillCheckButtonClickedListener skillCheckButtonClickedListener;
    private final OnEditSkillLongClickListener editSkillLongClickListener;
    private Animation click;

    public SkillRecyclerViewAdapter(List<ISkill> items, List<IAbilityScore> currentPlayerCharacterAbilityScores, OnListFragmentInteractionListener listener, Fragment containingFragment)
    {
        mValues = items;
        mListener = listener;
        this.currentPlayerCharacterAbilityScores = currentPlayerCharacterAbilityScores;
        if(containingFragment instanceof OnRollSkillCheckButtonClickedListener)
        {
            skillCheckButtonClickedListener = (OnRollSkillCheckButtonClickedListener)containingFragment;
        }
        else
        {
            throw new RuntimeException(containingFragment.toString()
                    + " must implement OnPlayerCharacterUpdatedListener");
        }

        if(containingFragment instanceof OnEditSkillLongClickListener)
        {
            editSkillLongClickListener = (OnEditSkillLongClickListener)containingFragment;
        }
        else
        {
            throw new RuntimeException(containingFragment.toString()
                    + " must implement OnEditSkillLongClickListener");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_row_view, parent, false);
        click = AnimationUtils.loadAnimation(parent.getContext(), R.anim.roll_button_click);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        final ImageButton rollButton = holder.recycledRow.findViewById(R.id.RollSkill);
        holder.mSkill = mValues.get(position);
        //holder.isClassSkill.setChecked(mValues.get(position).isProficiency());
        holder.skillName.setText(mValues.get(position).getSkillName());
        holder.skillTotal.setText(Integer.toString(getTotalSkillScore(mValues.get(position))));
        holder.skillStat.setText(mValues.get(position).getAddedStat().toString());

        holder.recycledRow.setOnLongClickListener(new View.OnLongClickListener()
        {
                @Override
                public boolean onLongClick (View v)
                {
                    editSkillLongClickListener.onEditSkillLongClickActivated(holder.mSkill);
                    return true;
                }
            });

        rollButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                skillCheckButtonClickedListener.onRollSkillCheckButtonPressed(holder.mSkill);

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
        private ISkill mSkill;

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

    public interface OnRollSkillCheckButtonClickedListener
    {
        void onRollSkillCheckButtonPressed(ISkill skillClicked);
    }

    public interface OnEditSkillLongClickListener
    {
        void onEditSkillLongClickActivated(ISkill skillHeld);
    }

    private int getTotalSkillScore(ISkill skillTotalToCalculate)
    {
        int totalValue = 0;
        totalValue += skillTotalToCalculate.getTotalInvestedPoints();
        for (IAbilityScore abilityScore : currentPlayerCharacterAbilityScores)
        {
            if (abilityScore.getStat().equals(skillTotalToCalculate.getAddedStat()))
            {
                totalValue += abilityScore.calculateModifier();
            }
        }
        return totalValue;
    }
}
