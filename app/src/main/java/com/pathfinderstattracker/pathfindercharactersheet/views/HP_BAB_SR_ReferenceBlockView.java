package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IHitPoints;

/**
 * TODO: document your custom view class.
 */
public class HP_BAB_SR_ReferenceBlockView extends LinearLayout
{
    private TextView hitPoints;
    private TextView baseAttackBonus;
    private TextView spellResistance;


    public HP_BAB_SR_ReferenceBlockView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        hitPoints = this.findViewById(R.id.HitPointValue);
        baseAttackBonus = this.findViewById(R.id.BaseAttackBonusValue);
        spellResistance = this.findViewById(R.id.SpellResistanceValue);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.hp_bab_sr_reference_block_view, this);
    }

    public void setValues(IHitPoints hitPoints, int baseAttackBonus, int spellResistance)
    {
        this.hitPoints.setText(Integer.toString(hitPoints.getValue()));
        this.baseAttackBonus.setText(Integer.toString(baseAttackBonus));
        this.spellResistance.setText(Integer.toString(spellResistance));
    }
}
