package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;

/**
 * TODO: document your custom view class.
 */
public class ProtectionDetailView extends ConstraintLayout
{

    private TextView magicBonus;
    private TextView equipmentAbilities;
    private TextView equipmentName;
    private TextView equipmentWeightCategory;
    private TextView checkPenalty;
    private TextView maxDex;
    private TextView spellFailure;
    private TextView weight;

    public ProtectionDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.protection_detail_view, this);
    }

    protected void onFinishInflate()
{
    super.onFinishInflate();
    magicBonus = this.findViewById(R.id.MagicBonusDropdown);
    equipmentAbilities = this.findViewById(R.id.EquipmentAbilitiesDropdown);
    equipmentName = this.findViewById(R.id.EquipmentNameDropdown);
    equipmentWeightCategory= this.findViewById(R.id.WeightCategoryDropdown);
    checkPenalty = this.findViewById(R.id.CheckPenaltyDropdown);
    maxDex = this.findViewById(R.id.MaxDexDropdown);
    spellFailure = this.findViewById(R.id.SpellFailureDropdown);
    weight = this.findViewById(R.id.WeightDropdown);
}

    public void setValues(IProtection protectionItem)
    {
        this.magicBonus.setText("+" + Integer.toString(protectionItem.getMagicBonus()) + " ");
        this.equipmentAbilities.setText(protectionItem.createAbilitiesString());
        this.equipmentName.setText(protectionItem.getName());
        if(protectionItem instanceof IShield)
        {
            this.equipmentWeightCategory.setText(((IShield)protectionItem).getWeightCategory().toString());
        }
        else if(protectionItem instanceof IArmor)
        {
            this.equipmentWeightCategory.setText(((IArmor)protectionItem).getWeightCategory().toString());
        }
        this.checkPenalty.setText("-" + Integer.toString(protectionItem.getArmorCheckPenalty()));
        this.maxDex.setText(Integer.toString(protectionItem.getMaximumDexBonus()));
        this.spellFailure.setText(Integer.toString(protectionItem.getArcanceSpellFailureChance()) + "%");
        this.weight.setText(Double.toString(protectionItem.getCurrentWeight()) + " lbs");
    }
}
