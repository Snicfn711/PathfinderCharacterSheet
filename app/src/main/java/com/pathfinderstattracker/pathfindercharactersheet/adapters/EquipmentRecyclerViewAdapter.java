package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.Ability;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
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
        if(holder.mEquipment.getMagicBonus() > 0)
        {
            holder.magicBonus.setText("+" + Integer.toString(mValues[position].getMagicBonus()) + " ");
            holder.magicBonusDropdown.setText("+" + Integer.toString(mValues[position].getMagicBonus()) + " ");
        }
        else
        {
            holder.magicBonus.setVisibility(View.GONE);
        }

        if(holder.mEquipment.getAbilities()!= null && holder.mEquipment.getAbilities().length > 1)
        {
            String abilitiesOnEquipment = holder.mEquipment.createAbilitiesString();
            holder.abilities.setText(abilitiesOnEquipment);
            holder.equipmentAbilitiesDropdown.setText(abilitiesOnEquipment);
        }
        else
        {
            holder.abilities.setVisibility(View.GONE);
        }
        holder.equipmentName.setText(holder.mEquipment.getName());
        holder.equipmentNameDropdown.setText(holder.mEquipment.getName());
        holder.equipmentLabel.setText(holder.mEquipment.getClass().getSimpleName());
        if(holder.mEquipment instanceof IWeapon)
        {
            holder.equipmentCriticalDropdown.setText(((IWeapon) holder.mEquipment).returnCriticalString());
            holder.damageTypeDropdown.setText(((IWeapon) holder.mEquipment).returnDamageTypes());
            holder.equipmentRangeDropdown.setText(Integer.toString(((IWeapon) holder.mEquipment).getRange()));
            holder.equipmentDamageDropdown.setText(((IWeapon) holder.mEquipment).returnDamageDice());
        }

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
                    if(holder.mEquipment.getMagicBonus() > 0)
                    {
                        SwitchVisibility(holder.magicBonus);
                    }
                    if(holder.mEquipment.getAbilities()!= null && holder.mEquipment.getAbilities().length > 1)
                    {
                        SwitchVisibility(holder.abilities);
                    }
                    SwitchVisibility(holder.equipmentName);
                    SwitchVisibility(holder.magicBonusDropdownLabel);
                    SwitchVisibility(holder.magicBonusDropdown);
                    SwitchVisibility(holder.equipmentAbilitiesDropdownLabel);
                    SwitchVisibility(holder.equipmentAbilitiesDropdown);
                    SwitchVisibility(holder.equipmentNameDropdownLabel);
                    SwitchVisibility(holder.equipmentNameDropdown);
                    if(!(holder.mEquipment instanceof IArmor))
                    {
                        SwitchVisibility(holder.equipmentCriticalDropdownLabel);
                        SwitchVisibility(holder.equipmentCriticalDropdown);
                        SwitchVisibility(holder.damageTypeDropdownLabel);
                        SwitchVisibility(holder.damageTypeDropdown);
                        SwitchVisibility(holder.equipmentRangeDropdownLabel);
                        SwitchVisibility(holder.equipmentRangeDropdown);
                        SwitchVisibility(holder.equipmentDamageDropdownLabel);
                        SwitchVisibility(holder.equipmentDamageDropdown);
                    }
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
        //Todo:Low priority, but see if we can clean this up at some point. Trying to maintain 18 views is ugly
        private final View recycledRow;
        private final TextView magicBonus;
        private final TextView abilities;
        private final TextView equipmentName;
        private final TextView equipmentLabel;
        private final TextView magicBonusDropdownLabel;
        private final TextView magicBonusDropdown;
        private final TextView equipmentAbilitiesDropdownLabel;
        private final TextView equipmentAbilitiesDropdown;
        private final TextView equipmentNameDropdownLabel;
        private final TextView equipmentNameDropdown;
        private final TextView equipmentCriticalDropdownLabel;
        private final TextView equipmentCriticalDropdown;
        private final TextView damageTypeDropdownLabel;
        private final TextView damageTypeDropdown;
        private final TextView equipmentRangeDropdownLabel;
        private final TextView equipmentRangeDropdown;
        private final TextView equipmentDamageDropdownLabel;
        private final TextView equipmentDamageDropdown;
        private IEquipment mEquipment;

        public ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            magicBonus =  view.findViewById(R.id.MagicBonus);
            abilities = view.findViewById(R.id.EquipmentAbilities);
            equipmentName = view.findViewById(R.id.EquipmentName);
            equipmentLabel = view.findViewById(R.id.EquipmentLabel);
            magicBonusDropdownLabel = view.findViewById(R.id.MagicBonusDropdownLabel);
            magicBonusDropdown = view.findViewById(R.id.MagicBonusDropdown);
            equipmentAbilitiesDropdownLabel = view.findViewById(R.id.EquipmentAbilitiesDropdownLabel);
            equipmentAbilitiesDropdown = view.findViewById(R.id.EquipmentAbilitiesDropdown);
            equipmentNameDropdownLabel = view.findViewById(R.id.EquipmentNameDropdownLabel);
            equipmentNameDropdown = view.findViewById(R.id.EquipmentNameDropdown);
            equipmentCriticalDropdownLabel = view.findViewById(R.id.EquipmentCriticalDropdownLabel);
            equipmentCriticalDropdown = view.findViewById(R.id.EquipmentCriticalDropdown);
            damageTypeDropdownLabel = view.findViewById(R.id.DamageTypeDropdownLabel);
            damageTypeDropdown = view.findViewById(R.id.DamageTypeDropdown);
            equipmentRangeDropdownLabel = view.findViewById(R.id.EquipmentRangeDropdownLabel);
            equipmentRangeDropdown = view.findViewById(R.id.EquipmentRangeDropdown);
            equipmentDamageDropdownLabel = view.findViewById(R.id.EquipmentDamageDropdownLabel);
            equipmentDamageDropdown = view.findViewById(R.id.EquipmentDamageDropdown);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + equipmentName.getText() + "'";
        }
    }

    private void SwitchVisibility(TextView in)
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
