package com.pathfinderstattracker.pathfindercharactersheet.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;

public class SpellResistanceReferenceBlockView extends LinearLayout
{
    private TextView spellResistanceView;

    public SpellResistanceReferenceBlockView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initializeViews(context);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        spellResistanceView = this.findViewById(R.id.SpellResistanceValue);
    }

    private void initializeViews(Context context)
    {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.spell_resistance_reference_view, this);
    }

    public void setValues(int spellResistance)
    {
        this.spellResistanceView.setText(Integer.toString(spellResistance));
    }
}
