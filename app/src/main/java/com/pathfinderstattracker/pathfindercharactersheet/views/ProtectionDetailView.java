package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

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

    public void setValues(int magicBonus, String equipmentAbilities, String equipmentName, String equipmentWeightCategory, int checkPenalty, int maxDex, int spellFailure, double weight)
    {
        this.magicBonus.setText("+" + Integer.toString(magicBonus) + " ");
        this.equipmentAbilities.setText(equipmentAbilities);
        this.equipmentName.setText(equipmentName);
        this.equipmentWeightCategory.setText(equipmentWeightCategory);
        this.checkPenalty.setText("-" + Integer.toString(checkPenalty));
        this.maxDex.setText(Integer.toString(maxDex));
        this.spellFailure.setText(Integer.toString(spellFailure) + "%");
        this.weight.setText(Double.toString(weight) + " lbs");
    }

}
