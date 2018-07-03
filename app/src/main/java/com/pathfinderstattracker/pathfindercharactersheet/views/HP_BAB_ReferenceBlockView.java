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
public class HP_BAB_ReferenceBlockView extends LinearLayout
{
    private TextView hitPoints;
    private TextView baseAttackBonus;


    public HP_BAB_ReferenceBlockView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        hitPoints = this.findViewById(R.id.HitPointValue);
        baseAttackBonus = this.findViewById(R.id.BaseAttackBonusValue);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.hp_bab_reference_block_view, this);
    }

    public void setValues(IHitPoints hitPoints, int baseAttackBonus)
    {
        this.hitPoints.setText(Integer.toString(hitPoints.getValue()));
        this.baseAttackBonus.setText(Integer.toString(baseAttackBonus));
    }
}
