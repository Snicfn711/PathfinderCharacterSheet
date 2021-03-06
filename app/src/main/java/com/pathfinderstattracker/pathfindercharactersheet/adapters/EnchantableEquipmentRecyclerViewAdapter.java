package com.pathfinderstattracker.pathfindercharactersheet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmorEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.viewmodels.EquipmentReferenceFragment.OnListFragmentInteractionListener;
import com.pathfinderstattracker.pathfindercharactersheet.views.ProtectionDetailView;
import com.pathfinderstattracker.pathfindercharactersheet.views.WeaponDetailView;

import java.util.List;

import static com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher.SwitchVisibility;

public class EnchantableEquipmentRecyclerViewAdapter extends RecyclerView.Adapter<EnchantableEquipmentRecyclerViewAdapter.ViewHolder>
{

    private final List<IEquipment> mValues;
    private final OnListFragmentInteractionListener mListener;

    public EnchantableEquipmentRecyclerViewAdapter(List<IEquipment> items, OnListFragmentInteractionListener listener)
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
        holder.mEquipment = mValues.get(position);
        
        if(holder.mEquipment.getMagicBonus() > 0)
        {
            holder.magicBonus.setText(String.format("+%s ", Integer.toString(holder.mEquipment.getMagicBonus())));
        }
        else
        {
            holder.magicBonus.setVisibility(View.GONE);
        }
        holder.equipmentName.setText(holder.mEquipment.getName());
        holder.equipmentLabel.setText(holder.mEquipment.getClass().getSimpleName());
        if(holder.mEquipment instanceof IWeapon)
        {            
            String equipmentEnchantments = CreateEnchantmentString((IWeapon)holder.mEquipment);
            holder.abilities.setText(equipmentEnchantments);
            holder.weaponDetailView.setValues((IWeapon)holder.mEquipment);
            if(equipmentEnchantments.equals("None"))
            {
                holder.abilities.setVisibility(View.GONE);
            }
        }
        else if(holder.mEquipment instanceof IArmor)
        {            
            String equipmentEnchantments = CreateEnchantmentString((IArmor)holder.mEquipment);
            holder.abilities.setText(equipmentEnchantments);
            holder.protectionDetailView.setValues((IArmor)holder.mEquipment);
            if(equipmentEnchantments.equals("None"))
            {
                holder.abilities.setVisibility(View.GONE);
            }
        }
        else if(holder.mEquipment instanceof IShield)
        {            
            String equipmentEnchantments = CreateEnchantmentString((IShield)holder.mEquipment);
            holder.abilities.setText(equipmentEnchantments);
            holder.protectionDetailView.setValues((IShield)holder.mEquipment);
            if(equipmentEnchantments.equals("None"))
            {
                holder.abilities.setVisibility(View.GONE);
            }
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
                    //Replace the summary view with the detail view
                    if(holder.mEquipment.getMagicBonus() > 0)
                    {
                        SwitchVisibility(holder.magicBonus);
                    }
                    SwitchVisibility(holder.equipmentName);
                    if(holder.mEquipment instanceof IWeapon)
                    {
                        SwitchVisibility(holder.weaponDetailView);
                        if(((IWeapon)holder.mEquipment).getEnchantments() != null && ((IWeapon)holder.mEquipment).getEnchantments().size() >= 1)
                        {
                            SwitchVisibility(holder.abilities);
                        }
                    }
                    else if(holder.mEquipment instanceof IProtection)
                    {
                        SwitchVisibility(holder.protectionDetailView);
                    }
                    SwitchVisibility(holder.unequipButton);
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
        private final TextView magicBonus;
        private final TextView abilities;
        private final TextView equipmentName;
        private final TextView equipmentLabel;
        private final WeaponDetailView weaponDetailView;
        private final ProtectionDetailView protectionDetailView;
        private final Button unequipButton;
        private IEquipment mEquipment;

        public ViewHolder(View view)
        {
            super(view);
            recycledRow = view;
            magicBonus =  view.findViewById(R.id.MagicBonus);
            abilities = view.findViewById(R.id.EquipmentAbilities);
            equipmentName = view.findViewById(R.id.EquipmentName);
            equipmentLabel = view.findViewById(R.id.EquipmentLabel);
            weaponDetailView = view.findViewById(R.id.WeaponDetailView);
            protectionDetailView = view.findViewById(R.id.ProtectionDetailView);
            unequipButton = view.findViewById(R.id.EquipmentRowUnequipButton);
        }

        @Override
        public String toString()
        {
            return super.toString() + " '" + equipmentName.getText() + "'";
        }
    }

    private String CreateEnchantmentString(IWeapon weapon)
    {
        List<IWeaponEnchantment> enchantments = weapon.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    private String CreateEnchantmentString(IArmor armor)
    {
        List<IArmorEnchantment> enchantments = armor.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
            for (IArmorEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    private String CreateEnchantmentString(IShield shield)
    {
        List<IWeaponEnchantment> enchantments = shield.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(shield.getEnchantments() != null && enchantments.size() >= 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

}
