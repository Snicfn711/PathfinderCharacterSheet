package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Damage;

/**
 * TODO: document your custom view class.
 */
public class WeaponDetailView extends ConstraintLayout
{

    private TextView magicBonus;
    private TextView equipmentAbilities;
    private TextView equipmentName;
    private TextView equipmentCritical;
    private TextView damageTypes;
    private TextView equipmentRange;
    private TextView equipmentDamage;

    public WeaponDetailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.weapon_detail_view, this);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        magicBonus = this.findViewById(R.id.MagicBonusDropdown);
        equipmentAbilities = this.findViewById(R.id.EquipmentAbilitiesDropdown);
        equipmentName = this.findViewById(R.id.EquipmentNameDropdown);
        equipmentCritical= this.findViewById(R.id.EquipmentCriticalDropdown);
        damageTypes = this.findViewById(R.id.DamageTypeDropdown);
        equipmentRange = this.findViewById(R.id.EquipmentRangeDropdown);
        equipmentDamage = this.findViewById(R.id.EquipmentDamageDropdown);
    }

    public void setValues(int magicBonus, String equipmentAbilities, String equipmentName, String equipmentCritical, String damageTypes, int equipmentRange, String equipmentDamage)
    {
        this.magicBonus.setText("+" + Integer.toString(magicBonus) + " ");
        this.equipmentAbilities.setText(equipmentAbilities);
        this.equipmentName.setText(equipmentName);
        this.equipmentCritical.setText(equipmentCritical);
        this.damageTypes.setText(damageTypes);
        this.equipmentRange.setText(Integer.toString(equipmentRange));
        this.equipmentDamage.setText(equipmentDamage);
    }

}
